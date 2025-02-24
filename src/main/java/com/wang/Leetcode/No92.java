package com.wang.Leetcode;


import com.wang.common.ListNode;

public class No92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null || left==right || head.next==null) return head;
        ListNode curNode = head;
        ListNode preSNode = null;
        // 找到开始节点
        int cnt = 1;
        while (cnt<left){
            preSNode = curNode;
            curNode = curNode.next;
            cnt++;
        }
        // 记住开始的节点，方便最后修改next
        ListNode sNode = curNode;
        ListNode nextNode = curNode.next;
        ListNode tempNode;

        while (nextNode!=null && cnt<right){
            // 计数
            cnt++;
            // 修改next指正
            tempNode = nextNode.next;
            nextNode.next = curNode;
            // 移动到下一个位置
            curNode = nextNode;
            nextNode = tempNode;
        }
        // 如果是链表中间调转位置，修改头尾的next指针连接
        if (left>1){
            preSNode.next = curNode;
            sNode.next = nextNode;
            return head;
        }
        sNode.next = nextNode;
        return curNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3,new ListNode(5));
        ListNode listNode = new No92().reverseBetween(head, 1, 2);
    }

}
