package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class CannotLikeYourself extends CustomException {

    public static final CustomException EXCEPTION =
            new CannotLikeYourself();

    private CannotLikeYourself() {
        super(ErrorCode.CANNOT_LIKE_YOUR_SELF);
    }

}
