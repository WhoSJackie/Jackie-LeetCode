package com.wang.learning;

public class No237 {
    public void deleteNode(ListNode node) {
        ListNode temp=node.next;
        node.val= temp.val;
        node.next=temp.next;
    }
}


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

