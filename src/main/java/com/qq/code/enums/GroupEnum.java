package com.qq.code.enums;

public enum GroupEnum implements GenerateEnum{
    MY_FRIENDS(1,"我的好友"),
    CLASSMATE(2,"同学"),
    UNIVERSITY(3,"大学");

    private final int code;

    private final String name;

    GroupEnum(int code,String name){
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
