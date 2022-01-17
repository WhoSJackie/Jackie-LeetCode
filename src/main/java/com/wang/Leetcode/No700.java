package com.wang.Leetcode;

public class No700 {
    TreeNode res;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }

        searchBST(root.left,val);
        if(root.val==val){
            res=root;
        }
        searchBST(root.right,val);

        return res;
    }

}
