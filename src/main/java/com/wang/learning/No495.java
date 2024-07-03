package com.wang.learning;

public class No495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len=timeSeries.length;
        int sum=0;
        for (int i = 0; i < len-1; i++) {
            int dur=timeSeries[i+1]-timeSeries[i];
            if(dur>=duration){
               sum+=duration;
            }
            else{
               sum+=dur;
            }
        }

        sum+=duration;

        return sum;
    }

    public static void main(String[] args) {
        int[] ts={1,4};
        int duration=2;
        System.out.println(new No495().findPoisonedDuration(ts, duration));
    }
}
