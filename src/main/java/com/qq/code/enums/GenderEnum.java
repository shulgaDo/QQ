package com.qq.code.enums;

import com.qq.code.exception.BizException;

public enum GenderEnum {

    MALE(0,"男"),
    FEMALE(1,"女");

    private final int code;

    private final String gender;

    GenderEnum(int code,String gender){
        this.code = code;
        this.gender = gender;
    }

    public int getCode() {
        return code;
    }

    public String getGender() {
        return gender;
    }

    public static String toGender(int code){
        for (GenderEnum gender: GenderEnum.values()
             ) {
           if(gender.code == code){
               return gender.getGender();
           }
        }
        throw new BizException("找不到！");
    }
}
