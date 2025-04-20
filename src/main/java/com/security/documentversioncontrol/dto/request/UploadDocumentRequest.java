package com.security.documentversioncontrol.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadDocumentRequest {
    private MultipartFile file;
}
