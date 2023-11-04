package com.wang.Leetcode.get_offer;

import com.wang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root==null) return res;
        List<Integer> temp = new ArrayList<>();
        dfs(root,0,target,temp);
        return res;
    }

    public void dfs(TreeNode node,int sum,int target,List<Integer> list){
        if (node==null) return;
        // 到达叶子结点
        list.add(node.val);
        if (node.left==null&&node.right==null){
            if (sum+node.val==target){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        dfs(node.left,sum+node.val,target,list);
        if (node.left!=null) list.remove(list.size()-1);
        dfs(node.right,sum+node.val,target,list);
        if (node.right!=null) list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);
        List<List<Integer>> res = new Offer34().pathSum(node, 22);
    }


}
