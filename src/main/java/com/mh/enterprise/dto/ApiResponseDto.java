package com.mh.enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> {
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    private int status;

    private String message;

    private T data;

    public static <T> ApiResponseDto<T> success(T data) {
        return ApiResponseDto.<T>builder()
                .status(200)
                .message("Success")
                .data(data)
                .build();
    }

    public static <T> ApiResponseDto<T> success(String message, T data) {
        return ApiResponseDto.<T>builder()
                .status(200)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponseDto<T> created(T data) {
        return ApiResponseDto.<T>builder()
                .status(201)
                .message("Created")
                .data(data)
                .build();
    }

    public static <T> ApiResponseDto<T> error(int status, String message) {
        return ApiResponseDto.<T>builder()
                .status(status)
                .message(message)
                .build();
    }
}