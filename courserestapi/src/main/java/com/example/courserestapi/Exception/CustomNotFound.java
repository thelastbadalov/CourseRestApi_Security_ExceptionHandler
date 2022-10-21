package com.example.courserestapi.Exception;

public class CustomNotFound extends RuntimeException{
private final String message;
private final int code;

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public CustomNotFound(ErrorCodeEnum errorCodeEnum){
    super(errorCodeEnum.getMessage());
    this.message=errorCodeEnum.getMessage();
    this.code=errorCodeEnum.getCode();
}
}
