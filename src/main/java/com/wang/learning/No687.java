package com.wang.learning;

public class No687 {

    int max;
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }

        int l=0,r=0,l1=0,r1=0;
        l = dfs(treeNode.left);
        r = dfs(treeNode.right);

        if ((treeNode.left!=null)&&(treeNode.left.val == treeNode.val)){
            l1 = l+1;
        }
        if ((treeNode.right!=null)&&(treeNode.right.val == treeNode.val)){
            r1 = r+1;
        }

        max = Math.max(max,l1+r1);
        return Math.max(l1,r1);
    }

}
