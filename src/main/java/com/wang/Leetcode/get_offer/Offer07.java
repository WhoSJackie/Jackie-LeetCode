package com.wang.Leetcode.get_offer;

import com.wang.Leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Offer07 {
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return bt(preorder,inorder,0,0,preorder.length-1);
    }

    public TreeNode bt(int[] preorder,int[] inorder,int preL,int l,int r){
        if (preL<0||preL>=inorder.length||l<0||r>=inorder.length||l>r) return null;
        TreeNode root = new TreeNode(preorder[l]);
        // 在中序数列中找出前序数列中下标为index的数
        int a = map.get(root.val);
        int leftLen = a-preL;
        root.left = bt(preorder,inorder,preL,l+1,l+leftLen);
        root.right = bt(preorder,inorder,preL+leftLen+1,l+leftLen+1,r);
        return root;
    }

}
