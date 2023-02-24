package com.woopaca.newcamo.exception.user;

public class DuplicateEmailException extends UserException {

    public DuplicateEmailException() {
        super(UserError.USER_EMAIL_DUPLICATE);
    }
}
