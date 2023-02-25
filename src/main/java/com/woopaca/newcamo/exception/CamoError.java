package com.woopaca.newcamo.exception;

import org.springframework.http.HttpStatus;

public interface CamoError {

    HttpStatus getHttpStatus();

    String getMessage();
}
