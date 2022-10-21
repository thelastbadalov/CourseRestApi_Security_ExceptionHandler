package com.example.courserestapi.Exception;

public enum ErrorCodeEnum {
COURSE_NOT_FOUND(1001,"can not find coruse given id"),
VALIDATION_ERROR(1002,"is not valid"),
UNKNOWN_ERROR(1000,"unknown error");
private final String message;
private final int code;
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    ErrorCodeEnum(int code, String message) {

    this.message = message;
      this.code=code;
}
}
