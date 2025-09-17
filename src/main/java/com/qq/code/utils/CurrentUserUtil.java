package com.qq.code.utils;

import com.qq.code.config.spring.CustomUserDetails;
import com.qq.code.entity.User;
import com.qq.code.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserUtil {

    @Autowired
    private UserRepository userRepository;

    public static User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDetails customUserDetails){
            return customUserDetails.getUser();
        }
        throw new RuntimeException("未登陆或者登陆已经过期了");
    }

}
