package com.qq.code.enums;

public enum DepartmentEnum implements GenerateEnum{
    MATHEMATICS(201,"数学系"),
    PHYSICS(202,"物理系"),
    COMPUTER_SCIENCE(203,"计算机系");

    private final int code;

    private final String name;

    DepartmentEnum(int code, String name) {
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
