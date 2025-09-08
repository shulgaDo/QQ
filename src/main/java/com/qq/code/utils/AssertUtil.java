package com.qq.code.utils;

import com.qq.code.exception.BizException;

/**
 * 断言工具类
 */
public class AssertUtil {

    /**
     * 若条件为真，则抛出异常
     * @param condition
     * @param message
     */
    public static void isError(Boolean condition,String message){
       if(condition){
           throw new BizException(message);
       }
    }
}
