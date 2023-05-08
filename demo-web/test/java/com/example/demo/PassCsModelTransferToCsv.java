package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cirmons
 * @Date: 2023-03-06
 */


public class PassCsModelTransferToCsv {
    
    @Test
    public void read() throws IOException {
        
        // read json
        String filePath = "/Users/xupeng/Desktop/model/passcs-model.json";
        String modelStr = FileUtils.readFileToString(new File(filePath), "utf-8");
        JSONObject modelJson = JSON.parseObject(modelStr);
    
    
        // extract
        JSONArray properties = modelJson.getJSONArray("properties");
        for (int i = 0; i < properties.size(); i++) {
            JSONObject property = properties.getJSONObject(i);
            String name = property.getString("name");
    
    
            List<String> lines = new ArrayList<>();
            JSONArray fields = property.getJSONArray("fields");
            for (int j = 0; j < fields.size(); j++) {
                JSONObject filed = fields.getJSONObject(j);
                String key = filed.getString("key");
                System.out.println("-------->>>start");
                System.out.println(key);
                String value = filed.getString("value");
                System.out.println(value);
                System.out.println("-------->>>end");
                lines.add(new StringBuilder(key).append("\t").append(value).toString());
            }
            
            
            // save csv
            String outputFileDir = "/Users/xupeng/Desktop/model/";
            File outCsvFile = new File(outputFileDir + name +".csv");
            FileUtils.writeLines(outCsvFile, lines);
        }
        
        
        
        
        
        
    
    
    }
    
    
    
    
}
