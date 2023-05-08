package com.example.demo;

/**
 * @Author: Cirmons
 * @Date: 2023-04-03
 */
public class StringEquals {
    
    public static void main(String[] args) {
        
        String s = "babad";
//        System.out.println(s.substring(s.length() - 1, s.length()));
//
//        System.out.println(checkReverseEqual(s));
        String s1 = longestPalindrome(s);
        System.out.println(s1);
        
        
    }
    
    public static boolean checkReverseEqual(String s) {
        char[] oriChars = s.toCharArray();
        boolean isEqual = true;
        for (int i = 0; i < oriChars.length; i++) {
            if (oriChars[i] != oriChars[(oriChars.length - 1) - i])
                isEqual = false;
        }
        return isEqual;
    }
    
    
    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        
        // 计算数组索引的起点、重点和中间位置
        
        int left = 0;
        int right = 0;
        
        int maxLeft = 0;
        int maxLen = 1;
        int len = 1;
        
        
        char[] sArr = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            
            while (right < s.length() && sArr[i] == sArr[right]) {
                len++;
                right++;
            }
            while (left > -1 && sArr[i] == sArr[left]) {
                len++;
                left--;
            }
            while (left > -1 && right < s.length() && sArr[left] == sArr[right]) {
                len = len + 2;
                left--;
                right++;
            }
            
            if (len > maxLen) {
                maxLeft = left;
                maxLen = len;
            }
            len = 1;
            
        }
        
        
        return s.substring(maxLeft + 1, maxLeft + maxLen + 1);


//        int len = 1;


//        return maxSubStr;
    }
    
    
}
