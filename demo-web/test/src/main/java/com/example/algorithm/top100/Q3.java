package com.example.algorithm.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * 无重复字符的最长子串
 * <p>
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @Author: Cirmons
 * @Date: 2023-04-03
 */
public class Q3 {
    
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        
        char[] sArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(); // 存放字符，当做滑动窗口
        
        for (int i = 0; i < sArr.length; i++) {
            if (map.containsKey(sArr[i])) {
                Integer value = map.get(sArr[i]);
                left = left > value ? left : value;
            }
        }
        
        return 0;
        
        
    }
    
    
}
