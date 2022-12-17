package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class InvalidJwt extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwt();

    private InvalidJwt() {
        super(ErrorCode.INVALID_JWT);
    }

}
