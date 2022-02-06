package com.example.hosptialtag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//get请求
@RequestMapping("/test")
public class test {
    public  String test(){
        return  "test测试";
    }



}
