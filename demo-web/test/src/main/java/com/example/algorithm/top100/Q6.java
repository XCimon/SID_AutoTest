package com.example.algorithm.top100;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 6. N 字形变换
 * 中等
 * 2K
 * 相关企业
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * -----<br/>
 * 6. Zigzag Conversion
 * 中等
 * 2K
 * 相关企业
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 *
 * @Author: Cirmons
 * @Date: 2023-04-06
 */
public class Q6 {
    
    
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1)
            return s;
        int length = s.length();
        char[][] tmpArr = new char[numRows][length - 1];
        
        char[] chars = s.toCharArray();
        int x = 0;
        int y = 0;
        int cnt = 0;
        
        int xFlag = numRows;
        // transform data
        while (cnt < length) {
            while (y < numRows && cnt < length) {
                tmpArr[y][x] = chars[cnt];
                y++;
                cnt++;
            }
            y--;
            x++;
            while (x < xFlag && cnt < length) {
                y--;
                tmpArr[y][x] = chars[cnt];
                x++;
                cnt++;
            }
            y++;
            x--;
            xFlag = xFlag + numRows - 1;
        }
        
        // get result
        char[] newChars = new char[length];
        int index = 0;
        for (int i = 0; i < tmpArr.length; i++) {
            char[] row = tmpArr[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] != '\u0000') {
                    newChars[index] = row[j];
                    index++;
                }
            }
        }
        
        String newStr = new String(newChars);
        
        
        return newStr;
    }
    
    
    @Test
    public void test1() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        
        char[][] chars = new char[numRows][s.length()];
        chars[0][1] = 'l';
        chars[2][4] = '0';
        chars[2][3] = 'v';
        
        System.out.println(JSON.toJSONString(chars));
    }
    
    
    @Test
    public void test2() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        
        String convert = convert(s, numRows);
        System.out.println(convert);
        
    }
    
    @Test
    public void test3() {
        String s = "A";
        int numRows = 2;
        
        String convert = convert(s, numRows);
        System.out.println(convert);
        
        
    }
    
}
