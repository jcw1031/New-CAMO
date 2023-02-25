package com.woopaca.newcamo.exception.user;

import com.woopaca.newcamo.exception.CamoError;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum UserError implements CamoError {

    USER_EMAIL_DUPLICATE(HttpStatus.CONFLICT, "중복된 이메일입니다."),
    INVALID_CHECK_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호 확인이 일치하지 않습니다."),
    EMAIL_OR_PASSWORD_INCORRECT(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 일치하지 않습니다."),
    NOT_VALIDATE_DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "이메일 중복 확인을 하지 않았습니다.");

    private HttpStatus httpStatus;
    private String message;

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
