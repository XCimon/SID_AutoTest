package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonToYamlConverter {
   
    @Test
    public void test(){
    
        try {
            String s = FileUtils.readFileToString(new File("test/resources/label.json"),"utf-8");
            convert(s);
    
            // 2
            System.out.println("---------");
            String s1 = convertJsonToYaml2(s);
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    @Test
    public void xrayLabelToYaml(){
        try {
            String s = FileUtils.readFileToString(new File("test/resources/label.json"),"utf-8");
            JSONObject json = JSON.parseObject(s);
            JSONArray jsonArray = new JSONArray();
            for (Object label : json.getJSONArray("labels")) {
                JSONObject labelJson = (JSONObject)label;
                JSONObject obj = new JSONObject();
                obj.put(labelJson.getString("id"),labelJson.getString("label"));
                jsonArray.add(obj);
            }
    
            String resultJson = jsonArray.toJSONString();
            System.out.println(resultJson);
    
            // 1
            jsonArrayConvert(resultJson);
            
            // 2
            System.out.println("---------");
            String s1 = convertJsonToYaml2(resultJson);
            System.out.println(s1);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    }
    
    
    public void convert(String jsonStr){
        try {
            // 从标准输入读取JSON字符串
            ObjectMapper objectMapper = new ObjectMapper();
            Map<?, ?> json = objectMapper.readValue(jsonStr,Map.class);
//            Map<?, ?> json = objectMapper.readValue(System.in, Map.class);
        
            // 创建YAML输出器
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yaml = new Yaml(options);
        
            // 将JSON转换为YAML，并写入标准输出
            String yamlString = yaml.dump(json);
            System.out.println(yamlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void jsonArrayConvert(String jsonArrStr){
        try {
            // 从标准输入读取JSON字符串
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<?, ?>> jsonArray = objectMapper.readValue(jsonArrStr, ArrayList.class);
            
            
            // 创建YAML输出器
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true); // 输出格式化
            options.setCanonical(false); // 不输出'---'
            Yaml yaml = new Yaml(options);
            
            // 将JSON转换为YAML，并写入标准输出
//            String yamlString = yaml.dumpAll(jsonArray.iterator());
            String yamlString = yaml.dump(jsonArray.iterator());
            System.out.println(yamlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    /*
        try {
            // 从标准输入读取JSON字符串数组
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<?, ?>> jsonArray = objectMapper.readValue(System.in, ArrayList.class);
        
            // 将JSON数组转换为字符串映射
            List<Map<String, Object>> stringArray = new ArrayList<>();
            for (Map<?, ?> map : jsonArray) {
                Map<String, Object> stringMap = new LinkedHashMap<>();
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    String key = entry.getKey().toString();
                    Object value = entry.getValue();
                    stringMap.put(key, value);
                }
                stringArray.add(stringMap);
            }
        
            // 创建YAML输出器
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true); // 输出格式化
            options.setCanonical(false); // 不输出'---'
            Yaml yaml = new Yaml(options);
        
            // 将字符串映射转换为YAML，并写入标准输出
            String yamlString = yaml.dumpAsMap(stringArray);
            System.out.println(yamlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
    
    
    
    
    public static String convertJsonToYaml(String json) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        YAMLMapper yamlMapper = new YAMLMapper();
        
        // Deserialize JSON into a List of LinkedHashMaps
        List<LinkedHashMap<String, String>> list = jsonMapper.readValue(json,
                jsonMapper.getTypeFactory().constructCollectionType(List.class, LinkedHashMap.class));
        
        // Combine LinkedHashMaps into a single LinkedHashMap
        LinkedHashMap<String, String> combinedMap = new LinkedHashMap<>();
        for (LinkedHashMap<String, String> map : list) {
            combinedMap.putAll(map);
        }
        
        // Serialize combined LinkedHashMap to YAML
        return yamlMapper.writeValueAsString(combinedMap);
    }
    
    
    public static String convertJsonToYaml2(String json) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        YAMLMapper yamlMapper = new YAMLMapper();
        
        // Deserialize JSON into a List of Maps
        List<Map<String, String>> list = jsonMapper.readValue(json, new TypeReference<List<Map<String, String>>>() {});
        
        // Combine Maps into a single LinkedHashMap
        LinkedHashMap<String, String> combinedMap = new LinkedHashMap<>();
        for (Map<String, String> map : list) {
            combinedMap.putAll(map);
        }
        
        // Serialize combined LinkedHashMap to YAML
        return yamlMapper.writeValueAsString(combinedMap);
    }
    
    
}

