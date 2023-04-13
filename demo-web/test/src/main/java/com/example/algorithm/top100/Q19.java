package com.example.algorithm.top100;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * ---
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 提示
 * 中等
 * 2.5K
 * 相关企业
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * ------
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @Author: Cirmons
 * @Date: 2023-04-13
 */
public class Q19 {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> list = node2List(head);
        list.remove(list.size() - n); // 删除链表的倒数第 n 个结点
        return list2Node(list);
    }
    
    // 链表转数组
    public List<Integer> node2List(ListNode node) {
        List<Integer> list = new ArrayList<>();
        
        ListNode curr = node;
        if (curr != null)
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
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        ListNode listNode = list2Node(integers);
        System.out.println(1);
        
        List<Integer> integers1 = node2List(listNode);
        System.out.println(2);
        
    }
    
    @Test
    public void test2() {
//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integers = Arrays.asList(1);
        ListNode listNode = list2Node(integers);
        
        ListNode afterNode = removeNthFromEnd(listNode, 1);
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
