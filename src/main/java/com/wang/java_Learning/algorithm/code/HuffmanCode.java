package com.wang.java_Learning.algorithm.code;

import com.wang.common.TreeNode;
import com.wang.java_Learning.utils.StringUtils;
import com.wang.java_Learning.utils.TreeNodeUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode {

    private StringBuilder sb = new StringBuilder();
    private boolean flag = false;
    public TreeNode<HuffmanObj> buildHuffmanCode(HuffmanObj[] huffmanObjArr){
        PriorityQueue<HuffmanObj> queue = new PriorityQueue<HuffmanObj>();
        Map<HuffmanObj,TreeNode<HuffmanObj>> map = new HashMap<>();
        for (HuffmanObj obj : huffmanObjArr) {
            queue.offer(obj);
        }
        TreeNode<HuffmanObj> root = null;
        while (queue.size()!=1){
            HuffmanObj minest = queue.poll();
            HuffmanObj minor = queue.poll();
            int newRate = minest.getRate()+minor.getRate();
            HuffmanObj newObj = new HuffmanObj(null,newRate);
            TreeNode<HuffmanObj> parent = new TreeNode<>(newObj);
            parent.left = map.getOrDefault(minest,new TreeNode<>(minest));
            parent.right = map.getOrDefault(minor,new TreeNode<>(minor));
            root = parent;
            map.put(newObj,parent);
            queue.offer(newObj);
        }
        return root;
    }

    public String buildCode(TreeNode root,String tarCode){
        sb.setLength(0);
        preOrder("",root,tarCode);
        return sb.toString();
    }

    private void preOrder(String str,TreeNode<HuffmanObj> root,String tarCode){
        if (root==null) return;
        if (tarCode.equals(root.getVal().getVal())) {
            flag = true;
            sb.append(str);
            return;
        }
        StringBuffer sb = new StringBuffer(str);
        if (!flag && root.left!=null){
            sb.append("0");
            preOrder(sb.toString(),root.left,tarCode);
            sb = new StringBuffer(str);
        }

        if (!flag && root.right!=null){
            sb.append("1");
            preOrder(sb.toString(),root.right,tarCode);
        }
    }

    public static void main(String[] args) {
        HuffmanCode huffmanCode = new HuffmanCode();
        HuffmanObj a = new HuffmanObj("a",450);
        HuffmanObj b = new HuffmanObj("b",350);
        HuffmanObj c = new HuffmanObj("c",90);
        HuffmanObj d = new HuffmanObj("d",60);
        HuffmanObj e = new HuffmanObj("e",30);
        HuffmanObj f = new HuffmanObj("f",20);
        HuffmanObj[] huffmanObjs = new HuffmanObj[]{a,b,c,d,e,f};
        TreeNode<HuffmanObj> root = huffmanCode.buildHuffmanCode(huffmanObjs);
        System.out.println(huffmanCode.buildCode(root, "b"));
    }

}
