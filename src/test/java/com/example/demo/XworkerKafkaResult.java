package com.example.demo;

import com.alibaba.fastjson.JSON;
import lombok.Builder;

/**
 * @Author: Cirmons
 * @Date: 2020-04-29
 */
@Builder
public class XworkerKafkaResult {
    
    private static final String appNameExpr = "\\#appName";
    private static final String valueExpr = "\\#value";
    private static final String deviceIdExpr = "\\#deviceId";
    private static final String imageUrlExpr = "\\#url";
    private static final String capturedTimeExpr = "\\#capturedTime";
    private static final String receivedTimeExpr = "\\#receivedTime";
    
    private final String msgTpl = "{\n" +
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
    
    private final String appName;
    private final String value;
    private final String deviceId;
    private final String imageUrl;
    private final Long capturedTime;
    private final Long receivedTime;
    
    public static void main(String[] args) {
        
        String value = "{\"id\":0,\"targets\":[{\"confidence\":0.4538730978965759,\"roi\":{\"height\":189,\"left\":878,\"top\":393,\"width\":72}},{\"confidence\":0.9672191143035889,\"roi\":{\"height\":248,\"left\":1066,\"top\":237,\"width\":169}},{\"confidence\":0.971024751663208,\"roi\":{\"height\":217,\"left\":146,\"top\":196,\"width\":146}}]}";
//        JSON.parseObject(value)
//
//        String messageStr = XworkerKafkaResult.builder()
//                .appName("handler.getAppName()")
//                .deviceId("message._getDeviceId()")
//                .imageUrl("message._getImageUrl()")
//                .value(value)
//                .capturedTime(System.currentTimeMillis())
//                .receivedTime(System.currentTimeMillis())
//                .build()
//                .generateXworkerResult();
    
        System.out.println(value.replaceAll("\"","\\\\\""));
        
        
        
    }
    
    public String generateXworkerResult() {
        return msgTpl.replaceAll(appNameExpr, appName)
                .replaceAll(valueExpr, value)
                .replaceAll(deviceIdExpr, deviceId)
                .replaceAll(imageUrlExpr, imageUrl)
                .replaceAll(capturedTimeExpr, capturedTime + "")
                .replaceAll(receivedTimeExpr, receivedTime + "");
    }
    
    
}