package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class UserExist extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExist();

    private UserExist() {
        super(ErrorCode.USER_EXIST);
    }

}
