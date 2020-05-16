package com.example.demo.service.impl;

import com.example.demo.components.ModelLoader;
import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
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
    private ModelLoader modelLoader;
    
    @Autowired
    private KeyedObjectPool<String, String> modelPool;
    
    @Autowired
    private GenericObjectPool<String> commonPool;
    
    @Override
    public String hello(String name) {
        return "hello DemoA " + name;
    }
    
    @Override
    public String resoucePoolWork(String key) {
        
        String res = "";
        
        String handler = null;
        try {
            handler = modelPool.borrowObject(key);
            log.info(">>> [borrow] before work, key is: {}, handler is:{}", key, handler);
            
            
            // sleep 100ms
            Thread.sleep(3 * 1000);
            res = "[resoucePoolWork] handler is: " + handler;
            
            
            log.info(">>> [handling]  modelPool.getNumActive(): {}, modelPool.getNumActive(key):{},  modelPool.getNumIdle(): {}, modelPool.getNumIdle(key): {}",
                    modelPool.getNumActive(),
                    modelPool.getNumActive(key),
                    modelPool.getNumIdle(),
                    modelPool.getNumIdle(key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (StringUtils.isNotBlank(handler)) {
                try {
                    modelPool.returnObject(key, handler);
                    log.info(">>> [return] after work, key is: {}, handler is:{}", key, handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
    
    
   
    
    @Override
    public String commonPoolWork() {
        
        
        String res = "";
        
        String handler = null;
        try {
            handler = commonPool.borrowObject();
            log.info(">>> [borrow-commonPool] before work, handler is:{}", handler);
            
            // sleep 100ms
            Thread.sleep(100);
            res = "[resoucePoolWork-commonPool] handler is: " + handler;
            
            
            log.info(">>> [handling-commonPool]  modelPool.getNumActive(): {}, modelPool.getNumIdle(): {}, getNumWaiters(): {}",
                    commonPool.getNumActive(),
                    commonPool.getNumIdle(),
                    commonPool.getNumWaiters());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (StringUtils.isNotBlank(handler)) {
                try {
                    commonPool.returnObject(handler);
                    log.info(">>> [return-commonPool] after work,  handler is:{}", handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
    
    @Override
    public String customPoolWork() {
        String res = "";
    
        String handler = null;
        try {
            handler = modelLoader.borrow();
            log.info(">>> [borrow-custompool] before work, handler is:{}", handler);
        
            // sleep 100ms
            Thread.sleep(100);
            res = "[custompool] handler is: " + handler;
            
            log.info(">>> [handling-custompool]  modelLoader.getHandlerPool().size(): {}, modelLoader.getHandlerPool().remainingCapacity(): {}",
                    modelLoader.getHandlerPool().size(),
                    modelLoader.getHandlerPool().remainingCapacity());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (StringUtils.isNotBlank(handler)) {
                try {
                    modelLoader.returnObject(handler);
                    log.info(">>> [return-custompool] after work,  handler is:{}", handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return res;

    }
}
