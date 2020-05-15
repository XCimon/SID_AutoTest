package com.example.demo.service.impl;

import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.KeyedObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Author: Cirmons
 * @Date: 2020-04-29
 */
@Service
@Slf4j
@Primary
@ConditionalOnExpression("${demo.A.enable:true}")
public class DemoAServiceImpl implements DemoService {
    
    
    @Autowired
    private KeyedObjectPool<String, String> modelPool;
    
    @Override
    public String hello(String name) {
        return "hello DemoA " + name;
    }
    
    @Override
    public String resoucePoolWork(String key) {
    
        String handler = null;
    
        try {
            handler = modelPool.borrowObject(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(StringUtils.isNotBlank(handler)) {
                try {
                    modelPool.returnObject(key, handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    
    
        return null;
    }
}
