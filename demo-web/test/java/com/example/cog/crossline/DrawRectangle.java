package com.example.cog.crossline;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author: Cirmons
 * @Date: 2019-08-26
 */
public class DrawRectangle {
    
    
    @Test
    public void testDrawRect2() {
        String imagePath = "/Users/xupeng/Desktop/import/sample/xray02.png";
        String extension = FilenameUtils.getExtension(imagePath);
        
        int x = 43;
        int y = 109;
        int width = 550;
        int height = 493;
        Color color = Color.RED;
        int strokeWidth = 3;
        
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            drawRectangleOnImage(image, x, y, width, height, color, strokeWidth);
            ImageIO.write(image, extension, new File("/Users/xupeng/Desktop/import/sample/xray02_" + System.currentTimeMillis() + "." + extension));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    @Test
    public void testDrawRect() {
        String imagePath = "/Users/xupeng/Desktop/import/sample/xray02.png";
        String extension = FilenameUtils.getExtension(imagePath);
        String newImagePath = imagePath.split("\\.")[0] + System.currentTimeMillis() + "." + extension;
        
        
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            
            
            drawRectangleOnImage(image, new RectangleInfo(43, 109, 550, 493, Color.RED, 5));
            drawRectangleOnImage(image, new RectangleInfo(292, 407, 265, 149, Color.GREEN, 3));
            drawRectangleOnImage(image, new RectangleInfo(164, 213, 167, 250, Color.BLUE, 3));
            drawRectangleOnImage(image, new RectangleInfo(359, 260, 152, 206, Color.YELLOW, 3));
            
            ImageIO.write(image, extension, new File(newImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    @Test
    public void testDrawText() {
        String imagePath = "/Users/xupeng/Desktop/import/sample/xray02.png";
        String extension = FilenameUtils.getExtension(imagePath);
        String newImagePath = imagePath.split("\\.")[0] + System.currentTimeMillis() + "." + extension;
        
        
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            drawTextOnImage(image, new TextInfo("abc", 44, 110));
            ImageIO.write(image, extension, new File(newImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    public static void drawTextOnImage(BufferedImage image, TextInfo... texts) {
        if (texts == null || texts.length <= 0)
            return;
        Graphics2D g2d = image.createGraphics();
        for (TextInfo text : texts) {
            g2d.setFont(text.font);
            g2d.setColor(text.color);
            
            // 在指定位置绘制文本
            g2d.drawString(text.content, text.x, text.y);
        }
        g2d.dispose();
    }
    
    
    public static void drawRectangleOnImage(BufferedImage image, int x, int y, int width, int height, Color color, int strokeWidth) {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawRect(x, y, width, height);
        g2d.dispose();
    }
    
    public static void drawRectangleOnImage(BufferedImage image, RectangleInfo... rects) {
        if (rects == null || rects.length <= 0)
            return;
        Graphics2D g2d = image.createGraphics();
        for (RectangleInfo rect : rects) {
            g2d.setColor(rect.color);
            g2d.setStroke(new BasicStroke(rect.strokeWidth));
            g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
        g2d.dispose();
    }
    
    
    public static class TextInfo {
        public String content;
        public int x;
        public int y;
        public Color color = Color.RED;
        public Font font = new Font("Arial", Font.BOLD, 36);
        
        public TextInfo(String content, int x, int y) {
            this.content = content;
            this.x = x;
            this.y = y;
        }
        
        public TextInfo(String content, int x, int y, Color color, Font font) {
            this.content = content;
            this.x = x;
            this.y = y;
            this.color = color;
            this.font = font;
        }
    }
    
    public static class RectangleInfo {
        public int x;
        public int y;
        public int width;
        public int height;
        public Color color = Color.RED;
        public int strokeWidth = 3;
        
        public RectangleInfo(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
        public RectangleInfo(int x, int y, int width, int height, Color color, int strokeWidth) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
            this.strokeWidth = strokeWidth;
        }
    }
    
    
}
