package com.example.demo.service;

/**
 * @Author: Cirmons
 * @Date: 2020-04-29
 */
public interface DemoService {
    
    String hello(String name);
    
    String resoucePoolWork(String key);
    
    String commonPoolWork();
    
    String customPoolWork();
    
}
