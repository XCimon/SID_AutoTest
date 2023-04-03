package com.example.demo;

import org.junit.Test;

/**
 * @Author: Cirmons
 * @Date: 2021-01-05
 */
public class IPTest {
    
    
    @Test
    public void testIP(){
        
        String ip = "299.11.55.44";
        String regx = "/^((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)$/";
    
        System.out.println(ip.matches(regx));
        
        System.out.println(1);
        
    }
    
    
    @Test
    public void testJarFilePath(){
        String path1 = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String path2 = System.getProperty("java.class.path");
        System.out.println(1);
    }
    
}
