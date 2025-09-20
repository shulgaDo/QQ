package com.qq.code.enums;

public enum SchoolLevelEnum implements GenerateEnum{
    PRIMARY(1,"小学"),
    JUNIOR(2,"中学");

    private final int code;

    private final String name;

    SchoolLevelEnum(int code, String name) {
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
