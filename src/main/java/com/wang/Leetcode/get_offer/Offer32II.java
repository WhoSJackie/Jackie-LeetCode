package com.wang.Leetcode.get_offer;

import com.wang.Leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer32II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int count=queue.size();
        List<Integer> li = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            li.add(node.val);
            count--;
            if (node.left!=null){
                queue.addLast(node.left);
            }
            if (node.right!=null){
                queue.addLast(node.right);
            }

            if (count==0)   {
                res.add(li);
                li = new ArrayList<>();
                count = queue.size();
            }

        }
        return res;
    }

}
