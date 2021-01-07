package com.example.demo.controller;

import com.example.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @Author Cirmons
 * @Date 2018-06-06
 */
@Slf4j
@Api(value = "demo api")
@RestController
@RequestMapping("/demo")
public class DemoController {
    
    @Autowired
    private DemoService demoService;
    
    
    @ApiOperation(value = "hello", httpMethod = "GET")
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        try {
            Thread.sleep(4000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return demoService.hello(name);
    }
    
    @ApiOperation(value = "hello", httpMethod = "GET")
    @GetMapping("/hellob")
    public Callable<String> helloB(@RequestParam String name) {
        
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
    
                try {
                    Thread.sleep(4000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return demoService.hello(name);
            }
        };
    }
    
    
    
    @ApiOperation(value = "handler", httpMethod = "GET")
    @GetMapping("/handler")
    public String handler(@RequestParam String key) {
        return demoService.resoucePoolWork(key);
    }
    
    @ApiOperation(value = "common", httpMethod = "GET")
    @GetMapping("/common")
    public String commonhandler() {
        return demoService.commonPoolWork();
    }
    
    
    @ApiOperation(value = "custom", httpMethod = "GET")
    @GetMapping("/custom")
    public String custom() {
        return demoService.customPoolWork();
    }
    
}
