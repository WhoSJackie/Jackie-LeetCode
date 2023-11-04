package com.wang.Leetcode.get_offer;

import com.wang.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer32I {

    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            list.add(node.val);
            if (node.left!=null) queue.offerFirst(node.left);
            if (node.right!=null) queue.offerFirst(node.right);
        }

        int[] res = new int[list.size()];
        int index=0;
        for (int i:list) {
            res[index++] = i;
        }
        return res;
    }


}
