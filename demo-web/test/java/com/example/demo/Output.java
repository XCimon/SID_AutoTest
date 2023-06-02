package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Cirmons
 * @Date: 2023-05-08
 */

public class Output {
    
    
    @Test
    public void test1() {
        try {
            String s = FileUtils.readFileToString(new File("test/resources/output.json"), "utf-8");
            JSONArray jsonArr = JSON.parseArray(s);
            
            
            JSONArray newJsonArr = new JSONArray();
            int cnt = 0;
            for (int i = 0; i < jsonArr.size(); i++) {
                JSONObject json = (JSONObject) jsonArr.get(i);
                Double confidence = json.getDouble("confidence");
                if (confidence > 0.7) {
                    newJsonArr.add(json);
                    cnt++;
                }
            }
            System.out.println(">>> total:" + cnt + "\n" + newJsonArr.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
}
