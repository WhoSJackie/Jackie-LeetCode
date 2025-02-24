package com.wang.learning;

import com.wang.common.TreeNode;

public class No437 {
    int sum=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return sum;
        }
        sumMethod(root,targetSum);
        if(root.left!=null){
            pathSum(root.left,targetSum);

        }
        if(root.right!=null){
            pathSum(root.right,targetSum);
        }
        return sum;
    }

    public void sumMethod(TreeNode root,int targetSum){
        if(root==null){
            return;
        }

        if(targetSum-root.val==0){
            sum++;
        }

        if(root.left!=null){
            sumMethod(root.left,targetSum-root.val);

        }
        if(root.right!=null){
            sumMethod(root.right,targetSum-root.val);
        }
    }


}


