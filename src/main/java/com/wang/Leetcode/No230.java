package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No230 {
    int res=0;
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        getMidTree(root,k);
        return list.get(k-1);
    }

    public void getMidTree(TreeNode root,int k){
        if(root==null){
            return;
        }
        getMidTree(root.left,k);
        list.add(root.val);
        if(list.size()>=k){
            return;
        }
        getMidTree(root.right,k);
    }

    public static void main(String[] args) {
        //头结点
//        TreeNode head=new TreeNode(5,new TreeNode(3,new TreeNode(2,new TreeNode(1),null),new TreeNode(4)),new TreeNode(6));
        TreeNode head=new TreeNode(1,null,new TreeNode(2));
        int ans=new No230().kthSmallest(head,3);
        System.out.println(ans);
    }
}


