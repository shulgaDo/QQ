package com.qq.code.exception;

public class BizException extends RuntimeException{

    private String errorMessage;

    public BizException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
