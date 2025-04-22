package com.security.documentversioncontrol.dto.response;

import lombok.Data;

@Data
public class UploadDocumentResponse {
    private String fileName;
    private String version;
    private String s3Link;
}
