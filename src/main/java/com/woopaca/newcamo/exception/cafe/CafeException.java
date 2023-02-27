package com.woopaca.newcamo.exception.cafe;

import com.woopaca.newcamo.exception.CamoError;
import com.woopaca.newcamo.exception.CamoException;

public abstract class CafeException extends CamoException {

    public CafeException(CamoError camoError) {
        super(camoError);
    }
}
