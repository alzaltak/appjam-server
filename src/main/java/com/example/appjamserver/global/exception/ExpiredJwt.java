package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class ExpiredJwt extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwt();

    private ExpiredJwt() {
        super(ErrorCode.EXPIRED_JWT);
    }

}
