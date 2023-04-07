package com.example.algorithm.top100;

import org.junit.Test;

/**
 * 8. 字符串转换整数 (atoi)
 * 中等
 * 1.6K
 * 相关企业
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * ------
 * <p>
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 * <p>
 * <p>
 * ----
 * 示例 1：
 * <p>
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："42"（读入 "42"）
 * ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 示例 2：
 * <p>
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 * ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 * ^
 * 第 3 步："   -42"（读入 "42"）
 * ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 示例 3：
 * <p>
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 * ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 *
 * @Author: Cirmons
 * @Date: 2023-04-06
 */
public class Q8 {

//    public int myAtoi(String s) {
//
//        char[] chars = s.toCharArray();
//
//
//        for (int i = 0; i < chars.length; i++) {
//            // 如果是第一位且为符号'-'，符号后一位是数字，这样的符号不做替换
//            boolean flagCheck0 = chars[i] == '-'
//                    && (i == 0 && i + 1 < chars.length && isDigest(chars[i + 1]));
//
//            // 如果不是第一位且为符号'-'，且符号前一位不是数字，符号后一位是数字，这样的符号不做替换
//            boolean flagCheck1 = chars[i] == '-'
//                    && (i + 1 < chars.length && isDigest(chars[i + 1]))
//                    && (i != 0 && i - 1 > 0 && !isDigest(chars[i - 1]));
//
//            if (isDigest(chars[i]) || flagCheck0 || flagCheck1) {
//                continue;
//            }
//            chars[i] = '#';
//        }
//
//        String[] split = new String(chars).split("#");
//        if (split.length <= 0)
//            return 0;
//
//
//        int value = 0;
//        boolean isNegative = false;
//        for (String str : split) {
//            if ("".equals(str))
//                continue;
//
//            if (str.charAt(0) == '-')
//                isNegative = true;
//            try {
//                value = Integer.parseInt(str);
//            } catch (NumberFormatException e) {
//                value = Integer.MAX_VALUE;
//                if (isNegative)
//                    value = Integer.MIN_VALUE;
//
//            }
//            break;
//        }
//        return value;
//    }
    
    public int myAtoi(String s) {
        int value = 0;
        char[] chars = s.trim().toCharArray();
        
        // check
        boolean checkMoreThan1 = chars.length > 1 && (isDigest(chars[0]) || (chars[0] == '-' || chars[0] == '+') && isDigest(chars[1]));
        if (chars.length < 1 || chars.length == 1 && !isDigest(chars[0]) || !checkMoreThan1) {
            return value;
        }
        
        
        
        return value;
    }
    
    
    public boolean isDigest(char c) {
        char[] defaultChars = "0123456789".toCharArray();
        boolean flag = false;
        for (char defaultChar : defaultChars) {
            if (c == defaultChar) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    
    @Test
    public void test() {
        
        String s = "3.14159";
        
        int i = myAtoi(s);
        System.out.println(i);
        
        
    }
    
    
}
