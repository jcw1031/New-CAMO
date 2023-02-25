package com.woopaca.newcamo.exception.handler;

import com.woopaca.newcamo.exception.CamoException;
import com.woopaca.newcamo.exception.handler.dto.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CamoExceptionHandler {

    @ExceptionHandler(CamoException.class)
    public ResponseEntity<ErrorResponseDto> userExceptionHandler(
            CamoException exception, HttpServletRequest request
    ) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.of(exception, request);
        return ResponseEntity.status(errorResponseDto.getStatusCode())
                .body(errorResponseDto);
    }
}
