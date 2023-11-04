package com.wang.Leetcode;

public class No275 {


    public int hIndex(int[] citations) {
        int size = citations.length;
        int h=0;
        int r = citations[0];
        int l;
        for (int i = size-1; i > 0; i--) {
            r = citations[i];
            // 查找使用二分法
            l = citations[i-1];
            while (l<r){
                int mid = l+(r-l)/2;
                if (mid>=(size-i)) {
                    r = mid;
                } else{
                    l = mid+1;
                }
            }
            if (l<=(size-i)) h = l;
            if (h!=0) break;
        }
        // 下标为0时
        if (h==0){
            for (int j=r;j>=0;j--){
                if (size>=j){
                    h = j;
                    break;
                }
            }
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new No275().hIndex(new int[]{0,1,3,5,6}));
    }

}
