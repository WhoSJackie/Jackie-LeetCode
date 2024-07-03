package com.wang.learning;

import java.util.ArrayDeque;
import java.util.Queue;

public class CBTInserter {
    TreeNode root;
    Queue<TreeNode> candidate;

    public CBTInserter(TreeNode root) {
        candidate = new ArrayDeque<>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            // 如果至少存在一个空子节点的节点，加入候选队列
            if (!(temp.left != null && temp.right != null)) {
                candidate.offer(temp);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode candi = candidate.peek();
        if (candi.left==null){
            candi.left = child;
        } else{
            candi.right = child;
            // 该节点已经插满，需要出队
            candidate.poll();
        }
        // 在队尾插入子节点
        candidate.offer(child);
        return candi.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
