package com.wang.Leetcode.get_offer;

import com.wang.Leetcode.TreeNode;

import java.util.*;

public class Offer32III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int count=1;
        // true代表正序，false代表逆序
        boolean flag = true;
        Deque<Integer> list = new LinkedList<>();
        while (!deque.isEmpty()){
            TreeNode node =deque.removeFirst();
            count--;
            if (!flag){
                list.offerFirst(node.val);
            } else{
                list.offerLast(node.val);
            }
            if (node.left!=null) deque.addLast(node.left);
            if (node.right!=null) deque.addLast(node.right);
            if (count==0){
                count = deque.size();
                res.add(new LinkedList<>(list));
                list = new LinkedList<>();
                // 到达一层的最后一个，反转flag
                flag = !flag;
            }
        }
        return res;
    }

}
