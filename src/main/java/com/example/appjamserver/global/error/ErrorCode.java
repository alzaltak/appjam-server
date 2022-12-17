package com.example.appjamserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SAVE_IMAGE_FAILED(400, "Save Image Failed"),

    CANNOT_REVIEW(401, "Cannot Review"),
    CANNOT_LIKE_YOUR_SELF(401, "Cannot Like Your self"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    USER_NOT_FOUND(404, "User Not Found"),
    HOME_NOT_FOUND(404, "Home Not Found"),
    IMAGE_NOT_FOUND(404, "Image Not Found"),

    USER_EXIST(409, "User Exist"),
    LIKE_EXIST(409, "Like Exist"),
    REMOVE_LIKE_EXIST(409, "Remove Like Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
