package com.security.documentversioncontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    private String accessKeyId = System.getenv("S3_ACCESS_KEY_ID");
    private String secretKey = System.getenv("S3_SECRET_KEY");
    private String s3Region = System.getenv("S3_REGION");
    private String s3BucketName = System.getenv("S3_BUCKET_NAME");

    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretKey);
        return S3Client.builder()
                .region(Region.of(s3Region))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    @Bean
    public String getBucketName() {
        return s3BucketName;
    }
}
