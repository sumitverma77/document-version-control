package com.security.documentversioncontrol.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretKey;
    @Value("${aws.s3.region}")
    private String s3Region;
    @Value("${aws.s3.bucketName}")
    private String s3BucketName;
    @Value("${aws.sessionId}")
    private String awsSessionId;
    @Value("${spring.profiles.active}")
    private String activeProfie;

    @Bean
    public S3Client s3Client() {
    AwsCredentials credentials = null ;

        if (activeProfie.equals("dev")) {
             credentials = AwsBasicCredentials.create(accessKeyId, secretKey);
        }
        else if (activeProfie.equals("prod")) {
         credentials = AwsSessionCredentials.create(
                accessKeyId,
                secretKey,
                awsSessionId
            );
        }
        else {
            throw new IllegalArgumentException("Invalid profile: " + activeProfie);
        }
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
