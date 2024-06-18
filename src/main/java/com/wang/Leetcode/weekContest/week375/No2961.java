package com.wang.Leetcode.weekContest.week375;

import java.util.ArrayList;
import java.util.List;

public class No2961 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int cnt=0;
        List<Integer> re = new ArrayList<>();
        for (int i=0;i< variables.length;i++) {
            if (powAndMod(powAndMod(variables[i][0],variables[i][1],10),variables[i][2],variables[i][3])==target){
                re.add(i);
            }
        }
        return re;
    }

    private long powAndMod(long x, int n, int mod) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0){
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new No2961().getGoodIndices(new int[][]{{30,5,43,2},{15,50,35,41},{45,34,41,32},{14,37,33,13},{6,8,1,53},{37,1,12,52},{42,37,2,52},{9,2,15,3},{31,12,21,24},{52,24,6,12},{51,35,21,52},{30,18,10,2},{27,31,50,27},{29,25,26,32},{15,38,43,17},{22,12,16,43},{48,9,15,6},{41,26,22,21},{41,49,52,26},{53,38,9,33}},1);
        for (Integer re : res) {
            System.out.println(re);
        }
    }

}
