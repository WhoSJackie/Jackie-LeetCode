package com.wang.Leetcode.get_offer;

public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 遍历倒序的链表
        ListNode temp = head;
        int cnt = 0;
        while (temp!=null){
            cnt++;
            temp = temp.next;
        }
        int count=0;
        while (head!=null){
            if (count==(cnt-k)) break;
            count++;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new Offer22().getKthFromEnd(head,2);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
