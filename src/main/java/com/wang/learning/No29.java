package com.wang.learning;

public class No29 {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int index=0;
        boolean flag=false;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
            flag=true;
        }

        long d_1=dividend;
        long d_2=divisor;

        long d1=d_1<0?-d_1:d_1;
        long d2=d_2<0?-d_2:d_2;

        while(d1>=d2){
            long temp1=d2,cnt=1;
            while(temp1<=d1-temp1){
                temp1=temp1+temp1;
                cnt=cnt+cnt;
            }
            d1-=temp1;
            index+=cnt;
        }

        return flag?-index:index;
    }


    public int multiply(int facient,int factor){
        int ans=0;
        int index=0;
        while(factor!=0){
            if((factor&1)==1){
                ans=ans+(facient<<index);
                factor=factor>>1;
                index++;
            }
            else{
                factor=factor>>1;
                index++;
            }
        }

        return ans;
    }


    public int add(int a,int b){
        int aggre;
        while(b!=0){
            aggre=(a&b)<<1;
            a=a^b;
            b=aggre;
        }
        return a;
    }

    public int subtraction(int a,int b){
        b=add(~b,1);
        return add(a,b);
    }

    public static void main(String[] args) {
//        int a=8;
//        int index=0;
//        while(a!=0){
//            //当前位为1
//            if((a&1)==1){
//                System.out.println(index+"位为1");
//                a=a>>1;
//                index++;
//            }
//            else{
//                System.out.println(index+"位为0");
//                a=a>>1;
//                index++;
//            }
//        }

        No29 n=new No29();
//        System.out.println("加法为:"+n.add(3, 5));
//        System.out.println("减法为:"+n.subtraction(12,-7));
//        System.out.println("除法为:"+n.divide(26,5));
        System.out.println("乘法为:"+n.multiply(3,5));
    }
}
