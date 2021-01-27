package com.example.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Cirmons
 * @Date: 2021-01-27
 */
public class CompareTests {
    
    
    @Test
    public void cmp(){
    
        Arrays.asList(10, 43, 55, 22, 4)
                .stream()
                .max(Comparator.comparingInt(Integer::shortValue).reversed())
                .ifPresent(System.out::println);
       
    
    
    }
    
    
}
