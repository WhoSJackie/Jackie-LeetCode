package com.wang.Leetcode;

import com.wang.common.TreeNode;

import java.util.*;

public class No652 {
    Map<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    private String dfs(TreeNode node){
        if (node==null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        String res = sb.toString();
        if (map.containsKey(res)){
            repeat.add(map.get(res));
        } else{
            map.put(res,node);
        }
        return res;
    }
}
