package com.wang.Leetcode.get_offer;

public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode temp = head;
        ListNode newHead = head;
        while (head.next!=null){
            temp = head.next;
            head.next = temp.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }
}
