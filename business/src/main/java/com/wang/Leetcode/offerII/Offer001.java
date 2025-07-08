package com.wang.Leetcode.offerII;

public class Offer001 {

    public int divide(int a, int b) {
        if (a==Integer.MIN_VALUE&&b==-1){
            return Integer.MAX_VALUE;
        }
        boolean flag = false;
        if (a>0){
            flag = !flag;
            a = -a;
        }
        if (b>0){
            flag = !flag;
            b = -b;
        }

        int res = div(a,b);
        return flag?-res:res;
    }

    public int div(int a,int b){

        int res=0;
        while (a<=b){
            int cnt=1;
            int temp = b;
            while (temp>=0xc0000000&&a<=(temp+temp)){
                cnt+=cnt;
                temp+=temp;
            }
            res+=cnt;
            a-=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer001().divide(-2147483648, 1));
    }

}
