package com.qq.code.controller;


import com.qq.code.common.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {


    @RequestMapping("/a")
    public ApiResponse<String> hello(){
        String s = "老子天下无敌！";
        return ApiResponse.success(s);
    }


}
