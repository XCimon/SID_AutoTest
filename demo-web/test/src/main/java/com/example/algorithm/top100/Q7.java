package com.example.algorithm.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 7. 整数反转
 * 中等
 * 3.8K
 * 相关企业
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * ---
 * 7. Reverse Integer
 * 中等
 * 3.8K
 * 相关企业
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 *
 * @Author: Cirmons
 * @Date: 2023-04-06
 */
public class Q7 {
    
    
    public int reverse(int x) {
        
        // 取绝对值转为字符数组反转
        char[] chars = (Math.abs(x) + "").toCharArray();
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        Collections.reverse(list);
        
        
        char[] newchars = new char[chars.length + 1];
        if (x < 0)
            newchars[0] = '-';
        else
            newchars[0] = '0';
        for (int i = 1; i <= list.size(); i++) {
            newchars[i] = list.get(i - 1);
        }
        String str = new String(newchars);
        int res = 0;
        try {
            res = Integer.parseInt(str);
        } catch (NumberFormatException e) {     // 边界检查，不用系统异常的边界检查，也可以取 Int.max\min 转为 char[],逐个字符比较
        }
        
        return res;
    }
    
    
    @Test
    public void test() {
        
        int a = 1534236469;
        int reverse = reverse(a);
        System.out.println(reverse);
        
    }
    
}
