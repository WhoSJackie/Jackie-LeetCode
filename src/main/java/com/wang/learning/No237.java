package com.wang.learning;

import com.wang.common.ListNode;

public class No237 {
    public void deleteNode(ListNode node) {
        ListNode temp=node.next;
        node.val= temp.val;
        node.next=temp.next;
    }
}


