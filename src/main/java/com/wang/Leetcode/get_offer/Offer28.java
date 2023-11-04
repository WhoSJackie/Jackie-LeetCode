package com.wang.Leetcode.get_offer;

import com.wang.common.TreeNode;

public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        return root==null||(root.left==null&&root.right==null)||compTwoTree(root.left,root.right);
    }

    public boolean compTwoTree(TreeNode A,TreeNode B){
        if (A==null&&B==null) return true;
        if ((A==null&&B!=null)||(A!=null&&B==null)) return false;
        return (A.val==B.val)&&(compTwoTree(A.left,B.left))&&(compTwoTree(A.right,B.right));
    }

}
