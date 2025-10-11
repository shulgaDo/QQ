package com.qq.code.enums;

public enum AlbumPermissEnum implements GenerateEnum{
    PUBLIC(1,"所有人"),
    QQ_FRIENDS(2,"QQ好友"),
    PRIVATE(3,"私密");

    private final int code;

    private final String name;

    AlbumPermissEnum(int code, String name) {
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
