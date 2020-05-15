package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.enums.Capability;
import com.example.demo.enums.CapabilityEnum;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.enums.CapabilityEnum.*;

/**
 * @Author: Cirmons
 * @Date: 2020-05-09
 */
public class EnumTests {
    
    @Test
    public void contains() {
        
        Set<CapabilityEnum> all = Arrays.stream(values()).collect(Collectors.toSet());
        Set<CapabilityEnum> sub1 = Arrays.asList(SERVER_CAP_1V1, SERVER_CAP_1V1_CHANNEL, SERVER_CAP_QUALITY).stream().collect(Collectors.toSet());
        Set<CapabilityEnum> sub2 = Arrays.asList(SERVER_CAP_OCR_BANKCARD, SERVER_CAP_LIVENESS, SERVER_CAP_QUALITY).stream().collect(Collectors.toSet());
        
        
        System.out.println(all.containsAll(sub1));
        System.out.println(all.containsAll(sub2));
    }
    
    
    @Test
    public void testFanshe() {
        
        Set<CapabilityEnum> set = new HashSet<>();
        Capability capability = new Capability();
        
        
        Field[] declaredFields = capability.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                field.setAccessible(true);
                Object value = field.get(capability);
                if (value != null && value instanceof Integer && ((Integer) value) > 0) {
                    set.add(CapabilityEnum.valueOf(field.getName().toUpperCase()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            
            
        }
        
        
        System.out.println(JSON.toJSONString(set));
        
    }
    
    
    @Test
    public void str(){
        
        String a = "{\n" +
                "\t\"object_\": {\n" +
                "\t\t\"bitField0_\": 0,\n" +
                "\t\t\"type_\": 0,\n" +
                "\t\t\"portraitImageLocation_\": {\n" +
                "\t\t\t\"panoramicImageSize_\": {\n" +
                "\t\t\t\t\"width_\": 0,\n" +
                "\t\t\t\t\"height_\": 0,\n" +
                "\t\t\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\t\t\"unknownFields\": {\n" +
                "\t\t\t\t\t\"fields\": {},\n" +
                "\t\t\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"memoizedSize\": -1,\n" +
                "\t\t\t\t\"memoizedHashCode\": 0\n" +
                "\t\t\t},\n" +
                "\t\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\t\"unknownFields\": {\n" +
                "\t\t\t\t\"fields\": {},\n" +
                "\t\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"memoizedSize\": -1,\n" +
                "\t\t\t\"memoizedHashCode\": 0\n" +
                "\t\t},\n" +
                "\t\t\"objectId_\": \"\",\n" +
                "\t\t\"associations_\": [],\n" +
                "\t\t\"algo_\": {\n" +
                "\t\t\t\"appName_\": \"#appName\",\n" +
                "\t\t\t\"appVersion_\": 1,\n" +
                "\t\t\t\"objectType_\": \"\",\n" +
                "\t\t\t\"objectVersion_\": 1,\n" +
                "\t\t\t\"data_\": {\n" +
                "\t\t\t\t\"typeUrl_\": \"\",\n" +
                "\t\t\t\t\"value_\": \"#value\",\n" +
                "\t\t\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\t\t\"unknownFields\": {\n" +
                "\t\t\t\t\t\"fields\": {},\n" +
                "\t\t\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"memoizedSize\": -1,\n" +
                "\t\t\t\t\"memoizedHashCode\": 0\n" +
                "\t\t\t},\n" +
                "\t\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\t\"unknownFields\": {\n" +
                "\t\t\t\t\"fields\": {},\n" +
                "\t\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"memoizedSize\": -1,\n" +
                "\t\t\t\"memoizedHashCode\": 0\n" +
                "\t\t},\n" +
                "\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\"unknownFields\": {\n" +
                "\t\t\t\"fields\": {},\n" +
                "\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t},\n" +
                "\t\t\"memoizedSize\": -1,\n" +
                "\t\t\"memoizedHashCode\": 0\n" +
                "\t},\n" +
                "\t\"cameraInfo_\": {\n" +
                "\t\t\"cameraId_\": \"\",\n" +
                "\t\t\"deviceId_\": \"#deviceId\",\n" +
                "\t\t\"deviceType_\": \"\",\n" +
                "\t\t\"placeCode_\": \"\",\n" +
                "\t\t\"placeName_\": \"\",\n" +
                "\t\t\"tollgateId_\": \"\",\n" +
                "\t\t\"tollgateName_\": \"\",\n" +
                "\t\t\"sourceId_\": \"\",\n" +
                "\t\t\"internalId_\": {\n" +
                "\t\t\t\"regionId_\": 1,\n" +
                "\t\t\t\"cameraIdx_\": 1,\n" +
                "\t\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\t\"unknownFields\": {\n" +
                "\t\t\t\t\"fields\": {},\n" +
                "\t\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"memoizedSize\": -1,\n" +
                "\t\t\t\"memoizedHashCode\": 0\n" +
                "\t\t},\n" +
                "\t\t\"zoneId_\": \"\",\n" +
                "\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\"unknownFields\": {\n" +
                "\t\t\t\"fields\": {},\n" +
                "\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t},\n" +
                "\t\t\"memoizedSize\": -1,\n" +
                "\t\t\"memoizedHashCode\": 0\n" +
                "\t},\n" +
                "\t\"panoramicImage_\": {\n" +
                "\t\t\"format_\": 1,\n" +
                "\t\t\"data_\": {\n" +
                "\t\t\t\"bytes\": [],\n" +
                "\t\t\t\"hash\": 0\n" +
                "\t\t},\n" +
                "\t\t\"url_\": \"#url\",\n" +
                "\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\"unknownFields\": {\n" +
                "\t\t\t\"fields\": {},\n" +
                "\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t},\n" +
                "\t\t\"memoizedSize\": -1,\n" +
                "\t\t\"memoizedHashCode\": 0\n" +
                "\t},\n" +
                "\t\"capturedTime_\": {\n" +
                "\t\t\"seconds_\": #capturedTime,\n" +
                "\t\t\"nanos_\": 0,\n" +
                "\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\"unknownFields\": {\n" +
                "\t\t\t\"fields\": {},\n" +
                "\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t},\n" +
                "\t\t\"memoizedSize\": -1,\n" +
                "\t\t\"memoizedHashCode\": 0\n" +
                "\t},\n" +
                "\t\"receivedTime_\": {\n" +
                "\t\t\"seconds_\": #receivedTime,\n" +
                "\t\t\"nanos_\": 0,\n" +
                "\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\"unknownFields\": {\n" +
                "\t\t\t\"fields\": {},\n" +
                "\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t},\n" +
                "\t\t\"memoizedSize\": -1,\n" +
                "\t\t\"memoizedHashCode\": 0\n" +
                "\t},\n" +
                "\t\"objectIndexInFrame_\": 0,\n" +
                "\t\"extraInfo_\": \"\",\n" +
                "\t\"trackEvent_\": 1,\n" +
                "\t\"relativeTime_\": {\n" +
                "\t\t\"seconds_\": 0,\n" +
                "\t\t\"nanos_\": 0,\n" +
                "\t\t\"memoizedIsInitialized\": -1,\n" +
                "\t\t\"unknownFields\": {\n" +
                "\t\t\t\"fields\": {},\n" +
                "\t\t\t\"fieldsDescending\": {}\n" +
                "\t\t},\n" +
                "\t\t\"memoizedSize\": -1,\n" +
                "\t\t\"memoizedHashCode\": 0\n" +
                "\t},\n" +
                "\t\"nsId_\": \"\",\n" +
                "\t\"memoizedIsInitialized\": 1,\n" +
                "\t\"unknownFields\": {\n" +
                "\t\t\"fields\": {},\n" +
                "\t\t\"fieldsDescending\": {}\n" +
                "\t},\n" +
                "\t\"memoizedSize\": -1,\n" +
                "\t\"memoizedHashCode\": 0\n" +
                "}\n";
        
        
        System.out.println(a);
    }
    
}
