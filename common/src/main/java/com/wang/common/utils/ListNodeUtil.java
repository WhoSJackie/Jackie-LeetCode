package com.wang.common.utils;

import com.wang.common.ListNode;

public class ListNodeUtil {

    public static<T> ListNode buildListNode(int[] arr){
        ListNode listNode = new ListNode();
        ListNode cur = listNode;
        for (int i : arr) {
            ListNode curNode = new ListNode(i);
            cur.next = curNode;
            cur = curNode;
        }
        return listNode.next;
    }






}
