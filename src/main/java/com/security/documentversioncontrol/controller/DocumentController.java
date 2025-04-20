package com.security.documentversioncontrol.controller;

import com.security.documentversioncontrol.service.DocumentService;
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
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            String s3Link = documentService.uploadDocument(file);
            return new ResponseEntity<>(s3Link, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error uploading document", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
