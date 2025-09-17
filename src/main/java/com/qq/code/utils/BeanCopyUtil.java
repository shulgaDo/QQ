package com.qq.code.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class BeanCopyUtil {

    public static void copyNonNullProperties(Object src,Object target){
        BeanUtils.copyProperties(src,target,getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames(Object source){
        final Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : BeanUtils.getPropertyDescriptors(source.getClass())) {
            try {
                Object srcValue = pd.getReadMethod().invoke(source);
                if (srcValue == null) {
                    emptyNames.add(pd.getName());
                }
            } catch (Exception ignored) {}
        }
        return emptyNames.toArray(new String[0]);
    }
}
