package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Strings;

/**
 * @Author: Cirmons
 * @Date: 2022-12-02
 */
public class GeneralCSV {
    
    
    public void csv(){
        
        String title = "picId,truthValue,modelValue,filename";
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    public static void main(String[] args) {
    
    
//        String a = null;
//        boolean blank = StringUtils.isBlank(a);
//        System.out.println(blank);
    
    
        String title = "picId,truthValue,modelValue,filename";
        String[] split = title.split(",");
        System.out.println(Strings.join(split.toString()));
    
    
    }
    
    
    
    
    
    
}
