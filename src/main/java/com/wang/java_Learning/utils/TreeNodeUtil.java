package com.wang.java_Learning.utils;

import com.wang.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNodeUtil {

    public static void treeVisit(TreeNode root){
        if (root==null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        System.out.println(root.getVal());
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode==null) continue;
                System.out.print(curNode.left!=null?curNode.left.getVal():"");
                System.out.print("\t");
                System.out.print(curNode.right!=null?curNode.right.getVal():"");
                if (curNode.left!=null)queue.offer(curNode.left);
                if (curNode.right!=null)queue.offer(curNode.right);
            }
            System.out.println();
        }
    }

}
