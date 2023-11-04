package com.wang.Leetcode;

import com.wang.common.TreeNode;

public class No2331 {

    public boolean evaluateTree(TreeNode root) {
        if (root.val<2) return root.val==1;
        return preTree(root);
    }

    public boolean preTree(TreeNode root){
        if (root.left==null&&root.right==null){
            return root.val == 1;
        }

        if (root.val == 2) return preTree(root.left)||preTree(root.right);
        if (root.val == 3) return preTree(root.left)&&preTree(root.right);

        return root.val==1;
    }

}
