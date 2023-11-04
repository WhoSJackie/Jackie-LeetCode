package com.wang.Leetcode.weekContest.week319;

import com.wang.common.TreeNode;

import java.util.*;

public class No2471 {

    public int minimumOperations(TreeNode root) {
        if (root==null){
            return 0;
        }
        int res = 0;
        int count;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            count = queue.size();

            while (count>0){
                TreeNode temp = queue.poll();
                arr.add(temp.val);
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
                count--;
            }
            // 达到这层最大值，进行交换
            if (arr.size()>=2){
                res+=minOperator(arr);
            }
            arr.clear();
        }
        return res;
    }

    private int minOperator(List<Integer> arr){
        int res = 0;
        List<Integer> temp = new ArrayList<>(arr);
        temp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        for (int i=0;i<arr.size();i++) {
            if (arr.get(i) >(temp.get(i))){
                if (arr.indexOf(arr.get(i))<arr.indexOf(temp.get(i))){
                    Collections.swap(arr,arr.indexOf(arr.get(i)),arr.indexOf(temp.get(i)));
                    res++;
                }
            } else if(arr.get(i) <(temp.get(i))){
                if (arr.indexOf(arr.get(i))>arr.indexOf(temp.get(i))){
                    Collections.swap(arr,arr.indexOf(arr.get(i)),arr.indexOf(temp.get(i)));
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(3,new TreeNode(7),new TreeNode(6)),new TreeNode(2,new TreeNode(5),new TreeNode(4)));
        System.out.println(new No2471().minimumOperations(root));
    }

}
