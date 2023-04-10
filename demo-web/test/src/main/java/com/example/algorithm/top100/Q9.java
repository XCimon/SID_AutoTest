package com.example.algorithm.top100;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * ---
 * <p>
 * Given an integer x, return true if x is a  palindrome , and false otherwise.
 * <p>
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * @Author: Cirmons
 * @Date: 2023-04-10
 */
public class Q9 {
    
    
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        
        
        // 如果不考虑使用字符类型转换的方式，可以直接取余
        String str = x + "";
        char[] chars = str.toCharArray();
        
        char[] reverseChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reverseChars[i] = chars[chars.length - 1 - i];
        }
        Long reverseX = Long.parseLong(new String(reverseChars));
        return reverseX - x == 0;
    }
    
    
}
