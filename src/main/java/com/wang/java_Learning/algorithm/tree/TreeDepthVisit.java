package com.wang.java_Learning.algorithm.tree;

import com.wang.common.TreeNode;

import java.util.*;

public class TreeDepthVisit {

    public int treeBreathVisit(TreeNode root){
        int res=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        int[] arr;
        while (!queue.isEmpty()){
            size = queue.size();
            arr = new int[size];
            int ix = 0;
            while (size>0){
                TreeNode node = queue.poll();
                arr[ix++] = (int)node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                size--;
            }
            res+=minSortOrder(arr);
        }
        return res;
    }

    private int minSortOrder(int[] arr){
        int count = 0;
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy);
        // 使用hashmap来存储值和对应下标
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i],i);
        }
        for (int i = 0; i < arr.length; i++) {
            int index = map.get(arr[i]);
            if (index!=i){
                swap(arr,i,index);
                count++;
            }
        }
        return count;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }

}
