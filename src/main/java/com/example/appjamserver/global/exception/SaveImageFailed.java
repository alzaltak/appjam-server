package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class SaveImageFailed extends CustomException {

    public static final CustomException EXCEPTION =
            new SaveImageFailed();

    private SaveImageFailed() {
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }

}
