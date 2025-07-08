package com.wang.Leetcode.weekContest.week325;

public class No2515 {

    public int closetTarget(String[] words, String target, int startIndex) {
        // 两个方向
        int len = words.length;
        int clockWise = -1;
        int counterClockWise = -1;

        // 顺时针
        int num=startIndex;
        while (num<startIndex+len){
            clockWise++;
            if (words[(num%len)].equals(target)){
                break;
            }
            num++;
        }
        // 逆时针
        int counterNum=len;
        int sindex = startIndex;
        while (counterNum>=0){
            counterClockWise++;
            if (sindex<0){
                if (words[(sindex+len)%len].equals(target)){
                    break;
                }
            } else{
                if (words[(sindex)%len].equals(target)){
                    break;
                }
            }
            sindex--;
            counterNum--;
        }
        clockWise = (num==startIndex+len)?-1:clockWise;
        counterClockWise = (counterNum<0)?-1:counterClockWise;
        if (clockWise==-1&&counterClockWise==-1){
            return -1;
        }
        return Math.min(clockWise,counterClockWise);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hsdqinnoha","mqhskgeqzr","zemkwvqrww","zemkwvqrww","daljcrktje","fghofclnwp","djwdworyka","cxfpybanhd","fghofclnwp","fghofclnwp"};
        int res = new No2515().closetTarget(words,"zemkwvqrww",8);
        System.out.println(res);
    }

}
