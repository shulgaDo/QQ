package com.qq.code.enums;

public enum UniversityEnum implements GenerateEnum{
    BEIJING_UNIVERSITY(101,"北京大学"),
    TSINGHUA_UNIVERSITY(102,"清华大学"),
    HUNAN_UNIVERSITY(103,"湖南大学");

    private final int code;

    private final String name;

    UniversityEnum(int code,String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
