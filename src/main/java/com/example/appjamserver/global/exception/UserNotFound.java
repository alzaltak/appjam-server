package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class UserNotFound extends CustomException {

    public static final CustomException EXCEPTION =
            new UserNotFound();

    private UserNotFound() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
