package com.example.aop.web.controller;

import com.example.aop.web.service.impl.NeedLogService;
import com.example.aop.web.service.impl.TestAopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestAopController {

    @Autowired
    TestAopServiceImpl testAopService;
    @Autowired
    NeedLogService needLogService;

    @RequestMapping(value = "/test1")
    public String test1() throws InterruptedException {
        return testAopService.test1();
    }

    @RequestMapping(value = "/test2")
    public String test2(HttpServletRequest request){
        request.getSession().setAttribute("token","Dengjinhui123");
        return testAopService.test2(request);
    }

    @RequestMapping(value = "/test3")
    public void test3(){
        needLogService.logMethod("xys");
        try {
            needLogService.exceptionMethod();
        } catch (Exception e) {
            // Ignore
        }
    }
}
