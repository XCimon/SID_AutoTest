package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @Author: Cirmons
 * @Date: 2023-01-31
 */
public class KafkaTest {
    
    
    public Map<String,Object> producerConfigs() {
        KafkaProperty kafkaProperty = new KafkaProperty();
    
        
        Map<String,Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperty.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.ACKS_CONFIG, "0");
        // 支持kafka 加密连接
        if(StringUtils.equalsIgnoreCase("true", kafkaProperty.getEnableSsl())) {
            props.put("sasl.mechanism", kafkaProperty.getSasl().getMechanism());
            props.put("security.protocol", kafkaProperty.getSecurity().getProtocol());
//            props.put(SslConfigs.SSL_PROTOCOL_CONFIG,"TLSv1.2,TLSv1.3");
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, kafkaProperty.getSsl().getTruststore().getLocation());
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, kafkaProperty.getSsl().getTruststore().getPassword());
            props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, kafkaProperty.getSsl().getKeystore().getLocation());
            props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, kafkaProperty.getSsl().getKeystore().getPassword());
            props.put(SaslConfigs.SASL_JAAS_CONFIG, kafkaProperty.getSasl().getJaas().getConfig());
            // 从Kafka 2.0.0版开始，默认情况下客户端连接以及broker之间的连接启用了服务器的主机名验证，为防止中间人攻击。
            // 可以通过将ssl.endpoint.identification.algorithm设置为空字符串来关闭服务器主机名验证。
            props.put("ssl.endpoint.identification.algorithm", "");
        }
        return props;
    }
    
//    public ProducerFactory<String,String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    public KafkaTemplate<String,String> kafkaTemplate() {
//        return new KafkaTemplate<String, String>(producerFactory());
//    }
    
    
    @Test
    public void testProducerSend(){
    
//        KafkaTemplate<String, String> kafkaTemplate = kafkaTemplate();
//
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("testabc", "", "mac-demo-" + System.currentTimeMillis());
    
    
        Producer<String,String> producer = new KafkaProducer<String, String>(producerConfigs());
        ProducerRecord pr = new ProducerRecord("testabc", 0, null, "", "mac-demo-" + System.currentTimeMillis());
        Future<RecordMetadata> future = producer.send(pr);
        while(!future.isDone()){
            System.out.println(">>>wait...");
            try {
                Thread.sleep(200l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(">>> done,"+future.isDone());
    
    }
    
    
    @Test
    public void testTemplateSend(){
        DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs());
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);
    
//        ProducerRecord pr = new ProducerRecord("testabc", null, null, "", "mac-demo-" + System.currentTimeMillis());
//        Future<RecordMetadata> future = kafkaTemplate.send(pr);
//
        Future future = kafkaTemplate.send("testabc", "mac-demo-" + System.currentTimeMillis());
        
        while(!future.isDone()){
            System.out.println(">>>wait...");
            try {
                Thread.sleep(200l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(">>> done,"+future.isDone());
        
    }
    
    
    
}
