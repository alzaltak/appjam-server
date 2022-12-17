package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class InternalServerError extends CustomException {

    public static final CustomException EXCEPTION =
            new InternalServerError();

    private InternalServerError() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }

}
