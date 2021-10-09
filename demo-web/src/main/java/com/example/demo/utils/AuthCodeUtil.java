package com.example.demo.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public class AuthCodeUtil {
    public static final int AUTHCODE_LENGTH = 5; // length of verification code
    public static final int SINGLECODE_WIDTH = 10; // width of one digit or character in the image
    public static final int SINGLECODE_HEIGHT = 25; // height of one digit or character in the image
    public static final int SINGLECODE_GAP = 5; // margin of a digit or character
    public static final int PADDING_TOP_BOT = 10;// padding of top and bottom
    public static final int PADDING_LEFT_RIGHT = 10; //padding of left and right
    public static final int IMG_WIDTH = AUTHCODE_LENGTH * (SINGLECODE_WIDTH + SINGLECODE_GAP) + PADDING_LEFT_RIGHT;
    public static final int IMG_HEIGHT = SINGLECODE_HEIGHT + PADDING_TOP_BOT;
    public static final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static Random random = new Random();
    
    
    public static String getAuthCode() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 5; i++) {// generate 6 digit and character
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }
    
    
    public static BufferedImage getAuthImg(String authCode) {
        // Set img width height type
        // RGB：red、green、blue
        BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_BGR);
        
        Graphics g = img.getGraphics();
        // Set the img background
        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        // draw a rectangle
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
        // color of verification code
        g.setColor(Color.BLACK);
        // Set font details
        g.setFont(new Font("Arial", Font.PLAIN, SINGLECODE_HEIGHT + 5));
        //draw the code in the image
        char c;
        for (int i = 0; i < authCode.toCharArray().length; i++) {
            c = authCode.charAt(i);
            g.drawString(c + "",
                    i * (SINGLECODE_WIDTH + SINGLECODE_GAP) + SINGLECODE_GAP / 2 + PADDING_LEFT_RIGHT / 2,
                    IMG_HEIGHT - PADDING_TOP_BOT / 2
            );
        }
        
        // add interferential elements - draw some random lines
        int linesCount = random.nextInt(10) + 5;
        for (int i = 0; i < linesCount; i++) {
            int x = random.nextInt(IMG_WIDTH);
            int y = random.nextInt(IMG_HEIGHT);
            int x2 = random.nextInt(IMG_WIDTH);
            int y2 = random.nextInt(IMG_HEIGHT);
            g.drawLine(x, y, x + x2, y + y2);
        }
        return img;
    }
    
    public static void test() {
        
        long t0 = System.currentTimeMillis();
        String authCode = getAuthCode();
//        System.out.println(authCode);
        
        long t1 = System.currentTimeMillis();
        BufferedImage authImg = getAuthImg(authCode);
        
        long t2 = System.currentTimeMillis();
        try {
            ImageIO.write(authImg, "jpeg", new File("/Users/cimon/Desktop/a/" + UUID.randomUUID().toString() + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        long t3 = System.currentTimeMillis();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(authImg, "jpeg", baos);
            long t4 = System.currentTimeMillis();
            byte[] bytes = baos.toByteArray();
            String imgBase64 = Base64.getEncoder().encodeToString(bytes);
            long t5 = System.currentTimeMillis();
//            System.out.println("data:image/jpeg;base64,"+imgBase64);
            
            
            System.out.println(MessageFormat.format(">>> generate auth code : {0} ms, create bufferedImg: {1} ms, write img to disk:{2} ms, bufferedImg2Stream: {3} ms, stream2Base64:{4}ms",
                    t1 - t0, t2 - t1, t3 - t2, t4 - t3, t5 - t4));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        
        int i = 0;
        while (i <= 10) {
            test();
            i++;
        }
        
    }


//    public static byte[] toByteArray(BufferedImage bi, String format)
//            throws IOException {
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ImageIO.write(bi, format, baos);
//        byte[] bytes = baos.toByteArray();
//        return bytes;
//
//    }
    
}