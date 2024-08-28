package com.wang.Leetcode;

import com.wang.common.ListNode;

public class No024 {

    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        // 处理前两个节点
        ListNode l1 = head,temp = head.next,l2 = head.next.next;
        temp.next = l1;
        l1.next = l2;
        head = temp;
        while (l2!=null && l2.next!=null){
            temp = l2.next;
            l2.next = temp.next;
            temp.next = l2;
            l1.next = temp;
            l1 = l2;
            l2 = l2.next;
        }
        return head;
    }

}
