package com.woopaca.newcamo.exception.user;

import com.woopaca.newcamo.exception.CamoError;

public class NotValidateDuplicateEmail extends UserException {

    public NotValidateDuplicateEmail() {
        super(UserError.NOT_VALIDATE_DUPLICATE_EMAIL);
    }
}
