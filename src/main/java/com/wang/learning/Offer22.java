package com.wang.learning;

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l=head;
        if(head==null){
            return null;
        }
        int sum=0;
        while(l.next!=null){
            l=l.next;
            sum++;
        }
        int count=sum-k+1;
        l=head;
        while(count!=0){
            l=l.next;
            count--;
        }
        return l;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


