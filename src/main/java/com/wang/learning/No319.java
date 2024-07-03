package com.wang.learning;

public class No319 {
    //法一，超时
    public int bulbSwitch(int n) {
        //true代表亮，false代表灭
        boolean[] flag=new boolean[n];
        for (int i = 1; i <= n; i++) {
            int j=i-1;
            while(j<n){
                flag[j]=!flag[j];
                j=j+i;
            }
        }

        int sum=0;
        for (int x = 0; x < n; x++) {
            if(flag[x]){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new No319().bulbSwitch(99999999));
    }

    //法二

}
