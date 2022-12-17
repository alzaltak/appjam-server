package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class HomeNotFound extends CustomException {

    public static final CustomException EXCEPTION =
            new HomeNotFound();

    private HomeNotFound() {
        super(ErrorCode.HOME_NOT_FOUND);
    }

}
