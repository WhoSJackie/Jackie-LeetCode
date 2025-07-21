package com.wang.common.utils;

import com.wang.common.ListNode;

public class ListNodeUtil {

    public static ListNode buildListNode(int[] arr){
        ListNode listNode = new ListNode();
        ListNode cur = listNode;
        for (int i : arr) {
            ListNode curNode = new ListNode(i);
            cur.next = curNode;
            cur = curNode;
        }
        return listNode.next;
    }

    public static void visitList(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
