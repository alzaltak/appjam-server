package com.example.appjamserver.global.exception;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;

public class ImageNotFound extends CustomException {

    public static final CustomException EXCEPTION =
            new ImageNotFound();

    private ImageNotFound() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }

}
