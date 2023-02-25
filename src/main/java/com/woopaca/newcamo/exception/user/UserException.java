package com.woopaca.newcamo.exception.user;

import com.woopaca.newcamo.exception.CamoError;
import com.woopaca.newcamo.exception.CamoException;
import lombok.Getter;

@Getter
public abstract class UserException extends CamoException {

    public UserException(CamoError camoError) {
        super(camoError);
    }
}
