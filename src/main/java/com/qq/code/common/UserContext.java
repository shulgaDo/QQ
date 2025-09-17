package com.qq.code.common;

import com.qq.code.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserContext {

    private static final ThreadLocal<User> User = new ThreadLocal<>();

    public void setUser(User user){
        User.set(user);
    }

    public static User getUser(){
        return User.get();
    }

    public static void clear(){
        User.remove();
    }

}
