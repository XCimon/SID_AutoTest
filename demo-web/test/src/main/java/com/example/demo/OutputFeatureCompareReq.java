package com.example.demo;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cirmons
 * @Date: 2022-05-18
 */
public class OutputFeatureCompareReq {
    
    
    public static String getOneFeature(){
        String fea = "{\n" +
                "    \"type\": \"face\",\n" +
                "    \"version\": 25100,\n" +
                "    \"blob\": \"U09GMQxiAAAQAgAAAAEAAAAAAAAFAAAAAAAAAAAAAAAgCQ23h7U3z1e+13FEAc/XIuJhRA22S+pMtWxa+q6gRpr3aDl59d0ZXpX2auTWpXXHCkV+YRwLc186NYzT5yFrAEi4IU9R3JudnBpvPYAHUwQH+bz5DLz0LTZVsvjneYR8kG2/+Zhgrun/m4lJYhGoK1FV5gcB2YRaH9qydhMthLpvkUYSj04rxfShi1mG9/gQuICaEiaRuMyYem1E5qQfU1rQcmDpCNwEcXmJXnKZBdC7L5t5LitbVYqgQdBh6IdwjzRFsTb6ElVleiJqHiIwiEm6bJuNsIZSgZEr0HI4lwkt0VJ21cYs0USKC1H1OiNegx8QQrmLkmtrQh2W6HgtKIOVfqTutuCpwhjvDjmQ/2F3YLZB8Xuq1L/YIWLe35uN6avOMhT50RIPu31zAwV12rGe2q8nWSbIki9iOj6P9Vb5CwZc73GEltwBn0PyF5VZv23wfZswIXXHnsweXX+E47+t8Oj51++ilU5Gf7oyFh8gAgQ6Gr7SRnKAR4Hm25YKtj5FywZAigyqPJs6KM0Wf30QcagDhY8d2TsDpBIRTyDC4YaxnnYwSZFQMGoSWhEH4oDLB+l98tun+1hYKtfqZ7SWdxc2PbquXYARCZbAwBpjhznoAGnOduYfUnsB8PU4V1Xbib26/ppd4yfVMWbUDANxl6gAQtwD4ukZ4qJuaSqOMBfdZTQSB9uHfbvB8LA=\"\n" +
                "}";
        return fea;
    }
    
    public static String readOtherFeature(){
        String str = null;
        try {
            FileInputStream fis = new FileInputStream("test/resources/features.json");
            str = IOUtils.toString(fis, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    
    public static class Feature{
        private String type;
        private int version;
        private String blob;
    
        public String getType() {
            return type;
        }
    
        public void setType(String type) {
            this.type = type;
        }
    
        public int getVersion() {
            return version;
        }
    
        public void setVersion(int version) {
            this.version = version;
        }
    
        public String getBlob() {
            return blob;
        }
    
        public void setBlob(String blob) {
            this.blob = blob;
        }
    }
    
    public static class CompareObj{
        private Feature one;
        private Feature other;
    
        public CompareObj(Feature one, Feature other) {
            this.one = one;
            this.other = other;
        }
    
        public Feature getOne() {
            return one;
        }
    
        public void setOne(Feature one) {
            this.one = one;
        }
    
        public Feature getOther() {
            return other;
        }
    
        public void setOther(Feature other) {
            this.other = other;
        }
    }
    
    @Test
    public void test() {
        List<CompareObj> list = new ArrayList<>();
        
        Feature one = JSON.parseObject(getOneFeature(), Feature.class);
        
        
        JSONArray objects = JSON.parseObject(readOtherFeature()).getJSONArray("responses").getJSONObject(0).getJSONArray("objects");
        for (int i = 0; i < objects.size(); i++) {
            String featureStr = objects.getJSONObject(i).getJSONObject("feature").toJSONString();
            Feature newone = JSON.parseObject(JSON.toJSONString(one), Feature.class);
            Feature other = JSON.parseObject(featureStr, Feature.class);
            
            CompareObj obj = new CompareObj(newone,other);
            list.add(obj);
        }
    
        String str = JSON.toJSONString(list);
        System.out.println(str);
        try {
            FileUtils.write(new File("/Users/xupeng/Desktop/list.txt"), str,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
}
