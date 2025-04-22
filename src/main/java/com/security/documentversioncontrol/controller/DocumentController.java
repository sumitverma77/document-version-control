package com.security.documentversioncontrol.controller;

import com.security.documentversioncontrol.dto.response.ApiResponse;
import com.security.documentversioncontrol.dto.response.UploadDocumentResponse;
import com.security.documentversioncontrol.service.DocumentService;
import com.security.documentversioncontrol.utils.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<UploadDocumentResponse>> uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            UploadDocumentResponse uploadDocumentResponse = documentService.uploadDocument(file);
            return ResponseEntity.ok(ResponseBuilder.success(uploadDocumentResponse, "Document uploaded successfully"));
        }
        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBuilder.error("Failed to upload document", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }
}
