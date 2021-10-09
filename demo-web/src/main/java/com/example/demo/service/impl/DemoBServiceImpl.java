package com.example.demo.service.impl;

import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

/**
 * @Author: Cirmons
 * @Date: 2020-04-29
 */
@Service
@Slf4j
@ConditionalOnExpression("${demo.B.enable:false}")
public class DemoBServiceImpl implements DemoService {
    
    @Override
    public String hello(String name) {
        return "hello DemoB " + name;
    }
    
    
    @Override
    public String resoucePoolWork(String key) {
        return null;
    }
    
    @Override
    public String commonPoolWork() {
        return null;
    }
    
    
    @Override
    public String customPoolWork() {
        return null;
    }
}
