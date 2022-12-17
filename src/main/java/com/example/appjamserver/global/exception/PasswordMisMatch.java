package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class PasswordMisMatch extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMisMatch();

    private PasswordMisMatch() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }

}
