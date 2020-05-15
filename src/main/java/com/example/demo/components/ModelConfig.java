package com.example.demo.components;

import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cirmons
 * @Date: 2019-05-14
 */
@Configuration
public class ModelConfig {
    //    /**
//     *  模型句柄平均占用内存 300 MB
//     */
//    private final static long AVARAGE_MODEL_SIZE = 300 * 1024 * 1024;
//
//    /**
//     * OCR 处理可用内存 = JVM整体内存 * k ，一般情况下，系数 k=0.8
//     */
//    private final static double OCR_AVAILABLE_MEMORY_FACTOR = 0.8;
//
//
//
//
    
    @Bean
    public CommonHandlerFactory commonHandlerFactory(){
        return new CommonHandlerFactory();
    }
    
    @Bean
    public KeyedPooledObjectFactory handlerFactory() {
        return new HandlerFactory();
    }
//
//    @Bean
//    protected int resourcePoolSize(){
//        long maxM = Runtime.getRuntime().maxMemory();
//        int proceNum = Runtime.getRuntime().availableProcessors();
//
//        int mem_size = (int) Math.ceil(maxM * OCR_AVAILABLE_MEMORY_FACTOR / AVARAGE_MODEL_SIZE);
//        int proce_size = proceNum * 2 - 1;
//
//        return Math.min(mem_size,proce_size);
//    }
//
    
    /**
     * 资源池配置<br/>
     * 当 MaxTotal = MaxTotalPerKey，资源池策略为允许抢占，例如，模型A请求较多，模型B请求较少或者没有请求，此时资源池释放掉模型B的资源加载更多模型A<br/>
     * 资源池大小理论值计算规则：<br/>
     * - 模型句柄平均占用内存 300 MB <br/>
     * - OCR平均处理速度 2个/线程 <br/>
     * - OCR 处理可用内存 = JVM整体内存 * k ，一般情况下，系数 k=0.8<br/>
     * 资源池大小理论值：
     * MIN( CEIL(MEN * 0.8 / 300 MB), （2 * threads - 1）) <br/>
     *
     * @return
     */
    @Bean
    public GenericKeyedObjectPoolConfig poolConfig() {
        GenericKeyedObjectPoolConfig conf = new GenericKeyedObjectPoolConfig();
//        conf.setJmxEnabled(false);
//
        conf.setMaxTotal(15);
        conf.setMaxTotalPerKey(15);
//        conf.setMinIdlePerKey(0);
//        conf.setSoftMinEvictableIdleTimeMillis(1000 * 60 * 5); // 允许空闲时间（单位：ms）
//        conf.setTimeBetweenEvictionRunsMillis(60000); // 驱逐线程的运行间隔（单位：ms）
        conf.setNumTestsPerEvictionRun(0); // 每次回收检查的池对象个数（value=0：不回收资源；value<0: ceil(池中空闲资源数/abs(value)); value>0 : min(value,池中空闲的资源数)）
        return conf;
    }
    
    @Bean
    public KeyedObjectPool<String, String> modelPool(KeyedPooledObjectFactory<String, String> handlerFactory,
                                                     GenericKeyedObjectPoolConfig poolConfig) {
        return new GenericKeyedObjectPool(handlerFactory, poolConfig);
    }
    
    @Bean
    public GenericObjectPoolConfig<String> commonPoolConfig(){
        GenericObjectPoolConfig<String> c = new GenericObjectPoolConfig<String>();
        c.setMaxTotal(15);
//        c.setBlockWhenExhausted();
        return c;
    }
    
    
    @Bean
    public GenericObjectPool<String> commonPool(PooledObjectFactory<String> factory, GenericObjectPoolConfig<String> config){
        return new GenericObjectPool<>(factory,config);
    }
    
    
    
}
