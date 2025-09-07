package com.qq.code.common.api;

import lombok.Getter;

public enum StatusCode {
    //请求成功
    SUCCESS(200,"Request successful !"),

    //请求失败
    FAILED(500,"Request failed !");

    private final Integer code;

    private final String message;

    StatusCode(Integer code, String message){
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
