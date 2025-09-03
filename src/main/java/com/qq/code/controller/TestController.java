package com.qq.code.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {


    @RequestMapping("/a")
    public String hello(){
        return "hello |QQ";
    }


}
