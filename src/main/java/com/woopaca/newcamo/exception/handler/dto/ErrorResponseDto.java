package com.woopaca.newcamo.exception.handler.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponseDto {

    private int statusCode;
    private String errorType;
    private String message;
    private String path;

    @Builder
    public ErrorResponseDto(int statusCode, String errorType, String message, String path) {
        this.statusCode = statusCode;
        this.errorType = errorType;
        this.message = message;
        this.path = path;
    }
}
