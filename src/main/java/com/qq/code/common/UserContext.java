package com.qq.code.common;

import com.qq.code.entity.User;

public class UserContext {

    private static final ThreadLocal<User> USER = new ThreadLocal<>();

    public static void setUser(User user){
        USER.set(user);
    }

    public static User getUser(){
        return USER.get();
    }

    public static void clear(){
        USER.remove();
    }

}
