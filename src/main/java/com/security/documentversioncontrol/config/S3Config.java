package com.security.documentversioncontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    private String accessKeyId = System.getenv("AWS_ACCESS_KEY_ID");
    private String secretKey = System.getenv("AWS_SECRET_KEY");
    private String s3Region = System.getenv("AWS_REGION");
    private String s3BucketName = System.getenv("S3_BUCKET_NAME");
    private String awsSessionId= System.getenv("AWS_SESSION_ID");

    @Bean
    public S3Client s3Client() {



        /* Todo: Use this line If you want to use your own AWS Credentials */
        //   AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretKey);

        /* Todo : Use this for Aws Academy Student Access*/
        AwsSessionCredentials credentials = AwsSessionCredentials.create(
                accessKeyId,
                secretKey,
                awsSessionId
            );
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
