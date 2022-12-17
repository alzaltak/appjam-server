package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class LikeExist extends CustomException {

    public static final CustomException EXCEPTION =
            new LikeExist();

    private LikeExist() {
        super(ErrorCode.LIKE_EXIST);
    }

}
