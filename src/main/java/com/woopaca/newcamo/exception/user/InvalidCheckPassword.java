package com.woopaca.newcamo.exception.user;

public class InvalidCheckPassword extends UserException {

    public InvalidCheckPassword() {
        super(UserError.INVALID_CHECK_PASSWORD);
    }
}
