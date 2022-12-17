package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class RemoveLikeExist extends CustomException {

    public static final CustomException EXCEPTION =
            new RemoveLikeExist();

    private RemoveLikeExist() {
        super(ErrorCode.REMOVE_LIKE_EXIST);
    }

}
