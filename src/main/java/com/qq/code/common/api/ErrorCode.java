package com.qq.code.common.api;

import lombok.Getter;

public enum ErrorCode {
    //资源没找到
    NOT_FOUND(404,"Not Found !"),

    //用户为授权
    UNAUTHORIZED(401,"User Is Unauthorized !");


    private final Integer code;

    private final String message;

    ErrorCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
