package com.wang.learning;

public class No400 {
    public int findNthNum(int n){
        //位数
        int level=0;
        //偏移量
        long diff=0;
        long y=n;
        for (int i = 1; i <= 9; i++) {
            y=(long)(y-(i*9*Math.pow(10,i-1)));
            if(y<=0){
               level=i;
               diff=(long)(y+(i*9*Math.pow(10,i-1)));
               break;
            }
        }

        //找到相对n位数起始数对应的真实数偏移量
        long quotient=(diff-1)/level;
        //对应真实数中的第几位
        long rem=(diff-1)%level;
        if(level==1){
            quotient=diff/level-1;
            rem=1;
        }
        //找到对应位数起始数
        int start=(int)(Math.pow(10,level-1));
        //得到真实数
        long cur=start+quotient;
        long num=cur;
        long res=cur;
        //得到真实数汇总对应位的数字
        for (int i = 0; i < level-rem; i++) {
            res=num%10;
            num/=10;
        }
        return (int)res;

    }

    public static void main(String[] args) {
        System.out.println(new No400().findNthNum(1000000000));
    }

}
