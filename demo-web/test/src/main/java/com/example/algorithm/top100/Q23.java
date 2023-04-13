package com.example.algorithm.top100;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 23. 合并 K 个升序链表
 * 困难
 * 2.4K
 * 相关企业
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @Author: Cirmons
 * @Date: 2023-04-13
 */
public class Q23 {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        
        List<Integer> integers = Arrays.stream(lists)
                .map(n -> node2List(n))
                .reduce((l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                })
                .get();
        Collections.sort(integers);
        return list2Node(integers);
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

//        ListNode[] nodes = new ListNode[]{
//                list2Node(Arrays.asList(1, 2, 4)),
//                list2Node(Arrays.asList(1,3,4)),
//                list2Node(Arrays.asList(2,6))
//        };
        
        ListNode[] nodes = null;
        
        ListNode afterNode = mergeKLists(nodes);
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
