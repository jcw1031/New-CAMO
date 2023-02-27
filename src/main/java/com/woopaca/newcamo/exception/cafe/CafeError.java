package com.woopaca.newcamo.exception.cafe;

import com.woopaca.newcamo.exception.CamoError;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum CafeError implements CamoError {

    CAFE_DUPLICATE(HttpStatus.CONFLICT, "중복된 카페입니다.");

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
