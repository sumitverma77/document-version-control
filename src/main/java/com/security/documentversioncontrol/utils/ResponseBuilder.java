package com.security.documentversioncontrol.utils;

import com.security.documentversioncontrol.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;

public class ResponseBuilder {
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(HttpStatus.OK.value(), message, data);
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus status) {
        return new ApiResponse<>(status.value(), message, null);
    }
}
