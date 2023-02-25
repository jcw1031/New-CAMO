package com.woopaca.newcamo.exception.user;

public class InvalidSignInUser extends UserException {

    public InvalidSignInUser() {
        super(UserError.EMAIL_OR_PASSWORD_INCORRECT);
    }
}
