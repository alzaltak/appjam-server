package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class CannotReview extends CustomException {

    public static final CustomException EXCEPTION =
            new CannotReview();

    private CannotReview() {
        super(ErrorCode.CANNOT_REVIEW);
    }

}
