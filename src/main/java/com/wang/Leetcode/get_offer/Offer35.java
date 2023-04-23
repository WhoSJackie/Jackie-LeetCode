package com.wang.Leetcode.get_offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer35 {

    // 法一，使用list记录下表位置
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        List<Node> oIndex = new ArrayList<>();
        List<Node> cIndex = new ArrayList<>();
        // 第一次复制next信息
        Node newHead = new Node(head.val);
        Node temp = newHead;
        Node otmp = head;
        while (otmp.next!=null){
            temp.next = new Node(otmp.next.val);
            // list存储位置信息
            oIndex.add(otmp);
            cIndex.add(temp);
            otmp = otmp.next;
            temp = temp.next;
        }
        oIndex.add(otmp);
        cIndex.add(temp);

        // 第二次复制random信息
        temp = newHead;
        otmp = head;
        while (otmp!=null) {
            temp.random = null;
            if (otmp.random != null) {
                int index = oIndex.indexOf(otmp.random);
                temp.random = cIndex.get(index);
            }
            temp = temp.next;
            otmp = otmp.next;
        }
        return newHead;
    }

    // 法二，使用hashmap记录下标位置
    public Node copyRandomList1(Node head) {
        if (head==null) return null;
        Map<Node,Integer> oIndex = new HashMap<>();
        Map<Integer,Node> cIndex = new HashMap<>();
        // 第一次复制next信息
        Node newHead = new Node(head.val);
        Node temp = newHead;
        Node otmp = head;
        int index=0;
        while (otmp.next!=null){
            temp.next = new Node(otmp.next.val);
            // map存储位置信息
            oIndex.put(otmp,index);
            cIndex.put(index,temp);
            otmp = otmp.next;
            temp = temp.next;
            index++;
        }
        oIndex.put(otmp,index);
        cIndex.put(index,temp);

        // 第二次复制random信息
        temp = newHead;
        otmp = head;
        while (otmp!=null) {
            temp.random = null;
            if (otmp.random != null) {
                int ix = oIndex.get(otmp.random);
                temp.random = cIndex.get(ix);
            }
            temp = temp.next;
            otmp = otmp.next;
        }
        return newHead;
    }

    Map<Node,Node> cacheNode = new HashMap<>();
    // 法三 递归+哈希
    public Node copyRandomList2(Node head) {
        if (head==null) return null;
        // 缓存中不包括相应创建的节点，就进行创建
        if (!cacheNode.containsKey(head)){
            Node newNode = new Node(head.val);
            newNode.next = copyRandomList2(head.next);
            newNode.random = copyRandomList2(head.random);
            cacheNode.put(head,newNode);
        }
        return cacheNode.get(head);
    }


    public static void main(String[] args) {
        Node head = new Node(7);
        Node next1 = new Node(13);
        Node next2 = new Node(11);
        Node next3 = new Node(10);
        Node next4 = new Node(1);
        head.next = next1;
        head.random = null;
        next1.next = next2;
        next1.random = head;
        next2.next = next3;
        next2.random = next4;
        next3.next = next4;
        next3.random = next2;
        next4.next = null;
        next4.random = head;
        Node newHead = new Offer35().copyRandomList(head);
        while (newHead!=null){
            System.out.println(newHead.val);
            System.out.println(newHead.random==null?"null":newHead.random.val);
            newHead = newHead.next;
        }
    }

}

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}