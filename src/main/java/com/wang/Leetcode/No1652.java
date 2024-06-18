package com.wang.Leetcode;

public class No1652 {

    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        boolean flag = true;
        if (k==0) return res;
        if (k<0) {
            flag = false;
            k = -k;
        }
        int idx=0;
        for (int i = 0; i < len; i++) {
            idx=k;
            int count=0;
            while (idx!=0){
                count+=code[!flag?(i+len-(idx--))%len:(i+idx--)%len];
            }
            res[i] = count;
        }
        return res;
    }

    // 滑动窗口
    public int[] decrypt1(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l++];
            w += code[++r];
        }
        return res;
    }


    public int[] decrypt2(int[] code, int k) {
        int n = code.length;
        if (k==0) return new int[n];
        int[] res = new int[2*n];
        int[] temp = new int[n];
        System.arraycopy(code,0,res,0,n);
        System.arraycopy(code,0,res,n,n);
        code = res;
        // 设定滑动窗口的左右边界
        int l = k>0?1:n+k;
        int r = k>0?k:n-1;
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            cnt+=code[i];
        }
        for (int i = 0; i < n; i++) {
            temp[i] = cnt;
            // 移动滑动窗口，计算新的
            cnt-=code[l++];
            cnt+=code[++r];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] res = new No1652().decrypt2(new int[]{5,7,1,4},3);
        for (int re : res) {
            System.out.println(re);
        }
    }

}
