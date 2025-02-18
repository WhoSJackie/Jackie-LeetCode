package com.wang.Leetcode;

import com.wang.common.ListNode;

public class No61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
        int cnt = 0,total=0;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        ListNode tempNode;
        // 将指针反转一次，并且计数
        while (nextNode!=null){
            cnt++;
            tempNode = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = tempNode;
        }
        total = cnt;
        head.next = null;
        cnt = k%(cnt+1);
        // 走到cnt反转一次，接下来接着cnt继续反转
        ListNode newHead = reverseListNode(curNode,0,cnt-1);
        return reverseListNode(newHead,cnt,total);
    }

    private ListNode reverseListNode(ListNode head,int s,int e){
        if (head==null) return head;
        ListNode curNode = head;
        ListNode preSNode = null;
        // 找到开始节点
        int cnt = 0;
        while (cnt<s){
            preSNode = curNode;
            curNode = curNode.next;
            cnt++;
        }
        ListNode sNode = curNode;
        ListNode nextNode = curNode.next;
        ListNode tempNode;

        while (nextNode!=null && cnt<e){
            cnt++;
            tempNode = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = tempNode;
        }
        if (s>0){
            preSNode.next = curNode;
            sNode.next = nextNode;
            return head;
        }
        sNode.next = nextNode;
        return curNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode no2 = new ListNode(2);
        ListNode no3 = new ListNode(3);
        head.next = no2;
        no2.next = no3;
        no3.next = null;
        ListNode listNode = new No61().rotateRight(head, 4);
        System.out.println(listNode);
    }
}
