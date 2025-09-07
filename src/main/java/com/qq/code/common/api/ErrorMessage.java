package com.qq.code.common.api;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    IS_TOO_LONG("Password is too long !");

    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
