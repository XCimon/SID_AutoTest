package com.example.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cirmons
 * @Date: 2023-03-31
 */
public class GetSum {
    public int[] twoSum(int[] nums, int target) {
        
        int res[] = new int[2];
        
        int length = nums.length;
        
        // 找出小于或等于target的数组
        java.util.ArrayList<IndexObj> tmpList = new java.util.ArrayList<>();
        for(int i= 0;i<length;i++){
            int num = nums[i];
            if(num<=target){
                tmpList.add(new IndexObj(i,num));
            }
        }
        Object tmp[] = tmpList.toArray();
        
        // 遍历找出和为target的对象
        for (int i = 0; i < tmp.length; i++) {
            IndexObj a = (IndexObj)tmp[i];
            System.out.println("[a],index:" + a.index + ",value:" + a.value);
            for (int j = i + 1; j < tmp.length; j++) {
                IndexObj b = (IndexObj)tmp[j];
                System.out.println("[b],index:" + b.index + ",value:" + b.value);
                if (target == (a.value + b.value)) {
                    res[0] = a.index;
                    res[1] = b.index;
                    return res;
                }
            }
        }
        
        
        return res;
        
    }
    
    
    public static class IndexObj {
        public int index;
        public int value;
        
        public IndexObj(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    
    
    public static void main(String[] args) {
        int[] nums = new int[]{0,4,3,0};
        int target = 0;
        int res[] = new GetSum().twoSum(nums, target);
        System.out.println(JSON.toJSONString(res));
    }
}