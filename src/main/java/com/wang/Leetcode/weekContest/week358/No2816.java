package com.wang.Leetcode.weekContest.week358;

import com.wang.common.ListNode;

public class No2816 {

    public ListNode doubleIt(ListNode head) {
        // 收集各个节点的信息，组成数字，为了防止溢出，使用字符串
        StringBuilder str = new StringBuilder();
        ListNode temp = head;
        // 收集各位数字，进行翻倍计算
        while (temp!=null){
            str.append(temp.val);
            temp=temp.next;
        }
        // 进行翻倍计算
        char[] chars = str.toString().toCharArray();
        int add=0;
        str = new StringBuilder();
        int tmp=-1;
        for (int i = chars.length-1; i >=0; i--) {
            tmp = (chars[i]-'0')*2+add;
            add = tmp/10;
            tmp = tmp-add*10;
            str.append(tmp);
        }
        if (add!=0) str.append(add);

        // 将获得的string转成链表
        char[] chs = str.toString().toCharArray();
        // 转换成节点,建立头节点
        ListNode newHead = new ListNode(chs[chs.length-1]-'0');
        temp = newHead;
        for (int i = chs.length-2; i >=0 ; i--) {
            ListNode newNode = new ListNode(chs[i]-'0');
            temp.next = newNode;
            temp = temp.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(5);
//        l.next = new ListNode(8);
//        l.next.next = new ListNode(9);
        ListNode newHead = new No2816().doubleIt(l);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
