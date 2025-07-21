package com.wang.Leetcode;


import com.wang.common.ListNode;
import com.wang.common.TreeNode;
import com.wang.common.utils.ListNodeUtil;
import com.wang.common.utils.TreeNodeUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class EasySolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        int sum = 0,carry = 0;
        while (l1!=null && l2!=null){
            int temp = l1.val+l2.val+carry;
            sum = temp%10;
            res.next = new ListNode(sum);
            res = res.next;
            carry = temp/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1!=null || l2!=null){
            ListNode temp = l1!=null?l1:l2;
            while (temp!=null){
                int tmpSum = temp.val+carry;
                carry = 0;
                sum = tmpSum%10;
                res.next = new ListNode(sum);
                carry = tmpSum/10;
                res = res.next;
                temp = temp.next;
            }
        }
        if(carry!=0) {
            res.next = new ListNode(carry);
        }
        return head.next;
    }



    public static void main(String[] args) {
        ListNode merge = new EasySolution().addTwoNumbers(ListNodeUtil.buildListNode(new int[]{9,9,9,9,9,9,9}),ListNodeUtil.buildListNode(new int[]{9,9,9,9}));
        ListNodeUtil.visitList(merge);
    }


}
