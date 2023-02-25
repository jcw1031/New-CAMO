package com.woopaca.newcamo.exception.handler.dto;

import com.woopaca.newcamo.exception.CamoException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

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

    public static ErrorResponseDto of(CamoException exception, HttpServletRequest request) {
        return ErrorResponseDto.builder()
                .statusCode(exception.getCamoError().getHttpStatus().value())
                .errorType(exception.getCamoError().getHttpStatus().name())
                .message(exception.getCamoError().getMessage())
                .path(request.getRequestURI())
                .build();
    }
}