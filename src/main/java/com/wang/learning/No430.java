package com.wang.learning;

public class No430 {
    //法一
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    //法一 dfs
    public Node dfs(Node head){
        Node cur=head;
        //记录链表最后一个节点
        Node last=null;
        while(cur!=null){
            //优先处理子节点
            Node temp=cur.next;
            if(cur.child!=null){
                Node childLast=dfs(cur.child);
                cur.next=cur.child;
                cur.child.prev=cur;
                if(temp!=null){
                    childLast.next=temp;
                   temp.prev=childLast;
                }
                cur.child=null;
                last=childLast;
            }
            else{
                last=cur;
            }
            cur=temp;
        }
        return last;
    }


    Node last=null;
    //法二
    public Node flatten1(Node head) {
        if(head==null){
            return null;
        }

        Node temp=head.next;
        if(last!=null){
            last.next=head;
        }
        head.prev=last;
        last=head;
        flatten1(head.child);
        head.child=null;
        flatten1(temp);
        return head;
    }

    //法三
    public  Node flatten2(Node head){
        if(head==null){
            return null;
        }
        last=null;
        Node next=head.next;
        if(head.child!=null){
            head.next=head.child;
            head.child.prev=head;
            findLast(head.child);
            head.child=null;
        }
        if(next!=null&&last!=null){
            next.prev=last;
            last.next=next;
        }
        flatten2(head.child);
        flatten2(head.next);
        return head;
    }

    public  Node findLast(Node temp){
        if(temp==null){
            return null;
        }
        last=temp;
        findLast(temp.child);
        findLast(temp.next);
        return temp;
    }

    public static void main(String[] args) {
        Node head=new Node(1,null,null,null);
        Node temp=head;
        temp.next=new Node(2,null,null,null);
        temp=temp.next;
        temp.next=new Node(3,null,null,null);
        temp=temp.next;
        temp.child=new Node(7,null,null,null);
        temp.next=new Node(4,null,null,null);
        Node st=temp.child;
        temp=temp.next;
        temp.next=new Node(5,null,null,null);
        st.next=new Node(8,null,null,null);
        st.next.next=new Node(9,null,null,null);
        st.next.child=new Node(11,null,null,null);
        Node fin=st.next.child;
        fin.next=new Node(12,null,null,null);

        No430 n=new No430();
        n.flatten1(head);

    }

}



class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    Node(int val,Node prev,Node next,Node child){
        this.val=val;
        this.prev=prev;
        this.next=next;
        this.child=child;
    }
}
