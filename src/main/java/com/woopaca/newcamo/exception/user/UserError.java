package com.woopaca.newcamo.exception.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserError {

    USER_EMAIL_DUPLICATE(HttpStatus.CONFLICT, "중복된 이메일입니다."),
    INVALID_CHECK_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    EMAIL_OR_PASSWORD_INCORRECT(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 일치하지 않습니다.");

    private HttpStatus httpStatus;
    private String message;
}
