package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Cirmons
 * @Date: 2020-05-20
 */
public class MathTest {
    
    @Test
    public void math(){
        
//        int a = 1;
//        int b = 21;
//        System.out.println((float)a/(float)b);
        
        
        String a = "";
        JSONArray objects = JSON.parseArray(a);
    
        System.out.println(1);
    
    }
    
    
    @Test
    public void testMap(){
        List<String> strings = Arrays.asList("a1", "a2", "a3", "a4");
        List<String> sub = strings.subList(0, 2);
        strings.removeAll(sub);
    
        System.out.println(1);
    
    }
    
    
    private static class A{
        boolean a;
    }
    @Test
    public void testBool(){
        A obj = new A();
        System.out.println(obj.a);
    }
    
    @Test
    public void testString(){
        String st = null;
        if("aa".equalsIgnoreCase(st))
            System.out.println(1);
        
        
    }
    
}
