package com.woopaca.newcamo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class CamoException extends RuntimeException {

    private CamoError camoError;
}
