package com.woopaca.newcamo.exception.handler.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woopaca.newcamo.exception.handler.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper mapper = new ObjectMapper();
    private final HttpStatus HTTP_STATUS = HttpStatus.FORBIDDEN;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .statusCode(HTTP_STATUS.value())
                .errorType(HTTP_STATUS.name())
                .message("접근 권한이 없습니다.")
                .path(request.getRequestURI())
                .build();

        response.setStatus(HTTP_STATUS.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        response.getWriter().write(mapper.writeValueAsString(errorResponseDto));
    }
}
