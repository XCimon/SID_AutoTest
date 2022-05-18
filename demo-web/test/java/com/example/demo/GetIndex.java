package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

/**
 * @Author: Cirmons
 * @Date: 2022-05-18
 */
public class GetIndex {
    
    @Test
    public void test(){
        
        String str = "{\n" +
                "    \"responses\": [\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0.036955893\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0.9954287\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0.02927336\n" +
                "        },\n" +
                "        {\n" +
                "            \"score\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    
    
        JSONArray responses = JSON.parseObject(str).getJSONArray("responses");
        for (int i = 0; i < responses.size(); i++) {
            Double score = responses.getJSONObject(i).getDouble("score");
            if(score > 0.6){
                System.out.println("score:"+score);
            System.out.println("index:"+i);}
        }
    
    }
    
    
}
