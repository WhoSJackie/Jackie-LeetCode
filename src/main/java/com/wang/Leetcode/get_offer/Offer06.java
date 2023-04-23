package com.wang.Leetcode.get_offer;

public class Offer06 {

    public int[] reversePrint(ListNode head) {
        if (head==null) return new int[0];
        if (head.next == null) return new int[]{head.val};
        int count=1;
        ListNode temp = head;
        ListNode newHead = head;
        while (head.next!=null){
            temp = head.next;
            head.next = temp.next;
            temp.next = newHead;
            newHead = temp;
            count++;
        }
        // 存储倒序后的值
        int[] res = new int[count];
        count=0;
        while (newHead!=null){
            res[count++] = newHead.val;
            newHead = newHead.next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        int[] res = new Offer06().reversePrint(head);
        for (int i : res) {
            System.out.println(i);
        }
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
