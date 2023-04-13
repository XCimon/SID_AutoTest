package com.example.algorithm.top100;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * ---
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @Author: Cirmons
 * @Date: 2023-04-13
 */
public class Q21 {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> integers1 = node2List(list1);
        List<Integer> integers2 = node2List(list2);
        
        integers1.addAll(integers2);
        Collections.sort(integers1);
        return list2Node(integers1);
        
    }
    
    // 链表转数组
    public List<Integer> node2List(ListNode node) {
        List<Integer> list = new ArrayList<>();
        
        ListNode curr = node;
        if (curr == null)
            return list;
        
        list.add(curr.val);
        while (curr.next != null) {
            curr = curr.next;
            list.add(curr.val);
        }
        return list;
    }
    
    // 数组转链表
    public ListNode list2Node(List<Integer> list) {
        if (list.size() <= 0)
            return null;
        
        ListNode head = new ListNode();
        ListNode curr = head;
        
        for (int i = 0; i < list.size(); i++) {
            curr.val = list.get(i);
            if (i + 1 < list.size()) {
                ListNode nextNode = new ListNode();
                curr.next = nextNode;
                curr = curr.next;
            }
        }
        return head;
    }
    
    
    @Test
    public void test() {
//        List<Integer> integers1 = Arrays.asList(1, 2, 4);
//        List<Integer> integers2 = Arrays.asList(1, 3, 4);
        List<Integer> integers1 = Arrays.asList();
        List<Integer> integers2 = Arrays.asList();
        ListNode listNode1 = list2Node(integers1);
        ListNode listNode2 = list2Node(integers2);
        
        ListNode afterNode = mergeTwoLists(listNode1, listNode2);
        List<Integer> afterList = node2List(afterNode);
        System.out.println(JSON.toJSONString(afterList));
    }
    
    
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
}
