package com.example.algorithm.top100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 14. 最长公共前缀
 * 简单
 * 2.7K
 * 相关企业
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @Author: Cirmons
 * @Date: 2023-04-11
 */
public class Q14 {
    
    public String longestCommonPrefix(String[] strs) {
        int maxi = strs.length;
        int maxj = Arrays.stream(strs).max(Comparator.comparingInt(String::length)).map(s -> s.length()).get();
        
        // 字符串数组转换为二维字符数字，方便后续列操作
        char[][] chars = new char[maxi][maxj];
        for (int i = 0; i < maxi; i++) {
            char[] strChars = strs[i].toCharArray();
            for (int j = 0; j < strChars.length; j++) {
                chars[i][j] = strChars[j];
            }
        }
        
        // 列操作比较，每次j+1，比较所有的str[i]字符，不同时则为终点
        int indexi = 0, indexj = 0;
        for (int j = 0; j < maxj; j++) {
            char stand = chars[0][j];
            boolean stop = false;
            indexj = j + 1; // 后面使用java string.subString(start,end), 是不包括end的
            for (int i = 0; i < maxi; i++) {
                if (chars[i][j] == '\u0000' || chars[i][j] != stand) {
                    indexi = i;
                    indexj = j;
                    stop = true;
                    break;
                }
            }
            if (stop)
                break;
        }
        
        // 返回最长公共前缀
        return (strs[indexi]).substring(0, indexj);
    }
    
    @Test
    public void test() {

//        String[] strs = new String[]{"flower","flow","flight"};
//        String[] strs = new String[]{"dog", "racecar", "car"};
        String[] strs = new String[]{"a", "a"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
        
        
    }
    
    
}
