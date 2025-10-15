package com.qq.code.enums;

public enum UserStatusEnum implements GenerateEnum{
    ONLINE(1,"在线"),
    JUST_ALONE(2,"想静静"),
    ON_STYLE(3,"学习中");

    private final int code;

    private final String name;

    UserStatusEnum(int code,String name){
       this.code = code;
       this.name = name;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
