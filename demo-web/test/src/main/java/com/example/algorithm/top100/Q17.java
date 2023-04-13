package com.example.algorithm.top100;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 中等
 * 2.4K
 * 相关企业
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * ----
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * ---
 * <p>
 * <p>
 * 2:abc,3:def,4：ghi,5:jkl,6:mno,7:pqrs,8:tuv,9:wxyz
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @Author: Cirmons
 * @Date: 2023-04-13
 */
public class Q17 {
    
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        char[] chars = digits.toCharArray();
        for (char c : chars) {
            int num = Integer.parseInt(String.valueOf(c));
            list = nextNumStrs(num, list);
        }
        return list;
    }
    
    
    // digit table with character
    private final static Map<Integer, char[]> digitMap = Map.of(
            2, "abc".toCharArray(),
            3, "def".toCharArray(),
            4, "ghi".toCharArray(),
            5, "jkl".toCharArray(),
            6, "mno".toCharArray(),
            7, "pqrs".toCharArray(),
            8, "tuv".toCharArray(),
            9, "wxyz".toCharArray()
    );
    
    public List<String> nextNumStrs(int num, List<String> currList) {
        List<String> res = currList != null ? new ArrayList<>(currList) : new ArrayList<>();
        
        char[] chars = digitMap.get(num);
        if (res.size() <= 0) {
            for (char c : chars) {
                res.add(String.valueOf(c));
            }
        } else {
            for (char c : chars) {
                for (String s : currList) {
                    res.add(new StringBuilder(s).append(c).toString());
                }
            }
        }
        
        // 只需要最终结果
        if (currList != null)
            res.removeAll(currList);
        return res;
    }
    
    
    @Test
    public void test() {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println(JSON.toJSONString(list));
        
    }
    
    
}
