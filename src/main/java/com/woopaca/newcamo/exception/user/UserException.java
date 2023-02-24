package com.woopaca.newcamo.exception.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class UserException extends RuntimeException {

    private UserError userError;
}
