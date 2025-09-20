package com.qq.code.utils;

import com.qq.code.enums.GenerateEnum;

public class EnumUtil {
    public static <T extends Enum<T> & GenerateEnum> T getByCode(Class<T> enumClass, int code){
        for (T each: enumClass.getEnumConstants()
             ) {
           if(each.getCode() == code){
               return each;
           }
        }
        return null;
    }
}
