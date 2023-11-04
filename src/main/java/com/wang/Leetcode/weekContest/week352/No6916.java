package com.wang.Leetcode.weekContest.week352;

import java.util.ArrayList;
import java.util.List;

public class No6916 {

    static  boolean[] isNotPrime = new boolean[1000001];
    static{
        isNotPrime[1] = true;
        for (int i=2;i<1000001;i++){
            if (!isNotPrime[i]){
                for (int j=2*i;j<1000001;j+=i){
                    isNotPrime[j] = true;
                }
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i=2;i<=n/2;i++){
            List<Integer> tmpRes = new ArrayList<>();
            int r = n-i;
            // 判断两数是否是质数
            if (!isNotPrime[i]&&!isNotPrime[r]) {
                tmpRes.add(i);
                tmpRes.add(r);
                res.add(tmpRes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> primePairs = new No6916().findPrimePairs(2);
        for (List<Integer> primePair : primePairs) {
            System.out.println(primePair.get(0));
            System.out.println(primePair.get(1));
        }
    }


}
