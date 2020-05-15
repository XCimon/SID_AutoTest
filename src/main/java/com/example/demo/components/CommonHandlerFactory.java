package com.example.demo.components;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Cirmons
 * @Date: 2019-05-22
 */
@Slf4j
public class CommonHandlerFactory extends BasePooledObjectFactory<String> {
    
    AtomicInteger cnt = new AtomicInteger(0);
    
    @Override
    public String create() throws Exception {
        String key = "**handler**:";
        int count = cnt.incrementAndGet();
        log.info(">>> [HandlerFactory] create a new resource, key:{} ,total resource count:{}", key, count);
        return key + count;
    }
    
    @Override
    public PooledObject<String> wrap(String obj) {
        return new DefaultPooledObject<>(obj);
    }
    
    @Override
    public void destroyObject(PooledObject<String> p) throws Exception {
        log.info(">>> [HandlerFactory] destroy a resource,total resource count:{}", cnt.decrementAndGet());
        super.destroyObject(p);
    }
    
}
