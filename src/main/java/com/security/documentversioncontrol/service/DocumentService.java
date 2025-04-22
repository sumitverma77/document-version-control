package com.security.documentversioncontrol.service;

import com.security.documentversioncontrol.config.S3Config;
import com.security.documentversioncontrol.entity.Document;
import com.security.documentversioncontrol.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private S3Config s3Config;

    @Autowired
    private S3Client s3Client;

    @Autowired
    private DocumentRepository documentRepository;

    public String uploadDocument(MultipartFile file) throws IOException {
        String bucketName = s3Config.getBucketName();
        String key = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        String s3Link = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key)).toString();

        // Save document information to the database
        String fileName = file.getOriginalFilename();
        Document document = documentRepository.findByName(fileName);
        Integer version = 1;
        if (document != null) {
            version = document.getVersion() + 1;
        }
        document = new Document();
        document.setName(fileName);
        document.setS3Link(s3Link);
        document.setS3Key(key);
        document.setUploadDate(new Date());
        document.setVersion(version);
        documentRepository.save(document);

        return s3Link;
    }
}
