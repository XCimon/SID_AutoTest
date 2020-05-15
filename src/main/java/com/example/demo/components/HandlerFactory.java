package com.example.demo.components;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Cirmons
 * @Date: 2019-05-22
 */
@Slf4j
public class HandlerFactory extends BaseKeyedPooledObjectFactory<String, String> {
    
    AtomicInteger cnt = new AtomicInteger(0);
    
    @Override
    public String create(String key) throws Exception {
        
        return key + cnt.incrementAndGet();
    }
    
    @Override
    public PooledObject<String> wrap(String value) {
        return new DefaultPooledObject<>(value);
    }


//
//
//    @Override
//    public Long create(KeyObject key) throws Exception {
//        long start = System.currentTimeMillis();
//
//        int mode = 0; // 目前除general model，识别模式参数传1，其他都用0
//        int threadNum = 1; // sdk 处理时的线程数
//        Long l = null;
//        switch (key.type) {
//            case OCR:
//            case OCR_GENERAL_0:
//                l = StidOcrNativeApi.StidOcrCreateHandle(key.modelPath, mode, threadNum);
//                break;
//            case OCR_GENERAL_1:
//                mode = 1;
//                l = StidOcrNativeApi.StidOcrCreateHandle(key.modelPath, mode, threadNum);
//                break;
//            case FACE:
//                l = StFaceNativeApi.dewatermark_create_handle(key.modelPath);
//                break;
//        }
//
//        if (log.isDebugEnabled())
//            log.debug(">>> 载入了模型：{}, 耗时：{} ms", key.modelPath, (System.currentTimeMillis() - start));
//        return l;
//    }
//
//    @Override
//    public PooledObject<Long> wrap(Long value) {
//        return new DefaultPooledObject<>(value);
//    }
//
//    @Override
//    public void destroyObject(KeyObject key, PooledObject<Long> p) {
//        if (log.isDebugEnabled())
//            log.debug(">>> 销毁了模型（{}）句柄：{}", key.modelPath, p.getObject());
//        StidOcrNativeApi.StidOcrDestroyHandle(p.getObject());
//    }
    

}
