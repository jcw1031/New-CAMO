package com.woopaca.newcamo.exception.handler.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woopaca.newcamo.exception.handler.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper mapper = new ObjectMapper();
    private final HttpStatus HTTP_STATUS = HttpStatus.UNAUTHORIZED;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .statusCode(HTTP_STATUS.value())
                .errorType(HTTP_STATUS.name())
                .message("인증에 실패하였습니다.")
                .path(request.getRequestURI())
                .build();

        response.setStatus(HTTP_STATUS.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        response.getWriter().write(mapper.writeValueAsString(errorResponseDto));
    }
}
