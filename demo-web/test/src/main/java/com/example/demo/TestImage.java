package com.example.demo;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

/**
 * @Author: Cirmons
 * @Date: 2020-06-17
 */
public class TestImage {
    
    
    @Test
    public void testImageTpe(){
        String path = "/Users/cimon/Desktop/b1.png";
    
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bi.getType());
    }
    
    
    
    @Test
    public void testImageBase64(){
        String path = "/Users/cimon/Desktop/a2.txt";
        try {
            String base = FileUtils.readFileToString(new File(path),"utf-8");
    
            byte[] bytes = Base64.getDecoder().decode(base);
    
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            BufferedImage bi = ImageIO.read(bis);
            System.out.println(bi.getType());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    @Test
    public void testImageURL(){
        String path = "https://hk.ulifestyle.com.hk/cms/images/topic/1024x576/201812/20181210161237_0_1.jpg";
        try {
            BufferedImage bi = bi = ImageIO.read(new URL(path));
            System.out.println(bi.getType());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testARGB(){
        String path = "/Users/cimon/Desktop/a1.png";
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bi.getType());
    
        
        convertRgbToBgr(bi.getRGB(0,0 ,bi.getWidth() ,bi.getHeight() ,null ,0 ,bi.getWidth() ),bi.getWidth(),bi.getHeight());
        
        
        byte[] bytes = convertArgbToBgr(bi);
        System.out.println(-1);
    
    
        
    }
    
    
    
    
    private static byte[] convertRgbToBgr(int[] rgbData, int width, int height) {
        byte[] bgrData = new byte[width * height * 3];
        for (int i = 0, b = 0; i < rgbData.length; i++) {
            bgrData[b++] = (byte)(rgbData[i]& 0xFF);
            bgrData[b++] = (byte)((rgbData[i] >> 8) & 0xFF);
            bgrData[b++] = (byte)((rgbData[i] >> 16) & 0xFF);
        }
        return bgrData;
    }
    
    private static byte[] convertArgbToBgr(BufferedImage argbImage) {
        int[] rgbData = argbImage.getRGB(0, 0, argbImage.getWidth(), argbImage.getHeight(), null, 0, argbImage.getWidth());
        return convertRgbToBgr(rgbData, argbImage.getWidth(), argbImage.getHeight());
    }
    
    
    
}
