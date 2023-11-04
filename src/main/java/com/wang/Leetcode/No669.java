package com.wang.Leetcode;

import com.wang.common.TreeNode;

public class No669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(1,null,new TreeNode(2)),new TreeNode(4));
        new No669().trimBST(root,1,2);
    }


}
