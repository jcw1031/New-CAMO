package com.woopaca.newcamo.exception.cafe;

public class DuplicateCafeException extends CafeException {

    public DuplicateCafeException() {
        super(CafeError.CAFE_DUPLICATE);
    }
}
