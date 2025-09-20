package com.qq.code.enums;

public enum DegreeEnum implements GenerateEnum{
    BACHELOR(1,"学士"),
    MASTER(2,"硕士"),
    DOCTOR(3,"博士");

    private final int code;

    private final String name;

    DegreeEnum(int code, String name) {
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
