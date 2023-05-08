package com.example.demo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Cirmons
 * @Date: 2023-03-31
 */
public class AddTwo {
    
    class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    
    static Object[] arr1 = {9};
    static Object[] arr2 = {1,9,9,9,9,9,9,9,9,9};
    
    
    public ListNode arr2Node(Object[] arr) {
        ListNode l = new ListNode((int) arr[0]);
        ListNode l0 = l;
        for (int i = 1; i < arr.length; i++) {
            int value = (int) arr[i];
            ListNode lnext = new ListNode(value);
            l0.next = lnext;
            l0 = lnext;
        }
        return l;
    }
    
    public List<BigInteger> node2List(ListNode node) {
        List<BigInteger> l = new ArrayList<>();
        ListNode current = node;
        while (true) {
            l.add(BigInteger.valueOf(current.val));
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        return l;
    }
    
    public BigInteger listReverse2Integer(List<BigInteger> list) {
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (BigInteger i : list) {
            sb.append(i);
        }
        return new BigInteger(sb.toString());
    }
    
    
    public static void main(String[] args) {
//        AddTwo o = new AddTwo();
//        ListNode node = o.arr2Node(arr1);
//        System.out.println(1);
//
//
//        List<Integer> list = o.node2List(node);
//        System.out.println(2);
//
//
//        int i = o.listReverse2Integer(list);
//        System.out.println(3);
        
        
        AddTwo o = new AddTwo();
        ListNode l1 = o.arr2Node(arr1);
        ListNode l2 = o.arr2Node(arr2);
    
        BigInteger d1 = o.listReverse2Integer(o.node2List(l1));
        BigInteger d2 = o.listReverse2Integer(o.node2List(l2));
        BigInteger sum = d1.add(d2);
        
        String str = sum.toString();
        char[] chars = str.toCharArray();
        List<Integer> intList = new ArrayList<>();
        for (char c : chars) {
            intList.add(Character.getNumericValue(c));
        }
        Collections.reverse(intList);
        Object[] resultArr = intList.stream().toArray();
        ListNode result = o.arr2Node(resultArr);
        System.out.println(100);
        
        
    }
    
    
}
