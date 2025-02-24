package com.wang.Leetcode;

import com.wang.common.ListNode;

public class No002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 设置哨兵
        ListNode sol = new ListNode(0);
        ListNode head = sol;
        int a1 = 0,a2 = 0 ,r = 0,sum=0;
        while (l1!=null || l2!=null){
            a1=0;
            a2=0;
            // 取值
            if (l1!=null){
                a1 = l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                a2 = l2.val;
                l2 = l2.next;
            }
            // 计算
            sum = a1+a2+r;
            r = sum>9?sum/10:0;
            sum = sum>9?sum%10:sum;
            head.next = new ListNode(sum);
            head = head.next;
        }
        // 如果还有余数，处理最后一位
        if (r>0){
            head.next = new ListNode(r);
        }
        return sol.next;
    }


}
