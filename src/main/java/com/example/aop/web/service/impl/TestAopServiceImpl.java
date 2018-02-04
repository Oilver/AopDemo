package com.example.aop.web.service.impl;

import com.example.aop.annotation.Cheaker;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TestAopServiceImpl {

    public String test1() throws InterruptedException {
        Thread.sleep(1000);
        return "正常！";
    }

    @Cheaker
    public String test2(HttpServletRequest request){
        return "你是邓锦辉......";
    }
}
