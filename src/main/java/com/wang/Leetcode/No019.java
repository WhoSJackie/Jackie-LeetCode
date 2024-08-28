package com.wang.Leetcode;

import com.wang.common.ListNode;

public class No019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index=0;
        ListNode h = head;
        ListNode h1 = head;
        // 第一遍先扫描找到节点的总个数
        while (h!=null) {
            h = h.next;
            index++;
        }
        // 找到前置节点
        for (int i = 1; i < index - n; i++) {
            h1=h1.next;
        }
        if (index == n){
            return h1.next;
        } else if (h1.next!=null){
            h1.next = h1.next.next;
        }
        return head;
    }


}
