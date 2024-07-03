package com.wang.learning;

public class No1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int row=bookings.length;
        int[] res=new int[n];
        for (int i = 0; i < row; i++) {
           int start=bookings[i][0];
           int end=bookings[i][1];
           int data=bookings[i][2];
           for(int j=start-1;j<end;j++){
               res[j]+=data;
           }

        }
        return res;
    }

    public int[] corpFlightBookings2(int[][] bookings, int n){
        int row=bookings.length;
        int[] res=new int[n];

        //求出差分数组
        for (int i = 0; i < row; i++) {
            int start=bookings[i][0]-1;
            int end=bookings[i][1]-1;
            int data=bookings[i][2];
            res[start]+=data;
            if(end+1<n){
                res[end+1]-=data;
            }
        }

        ///通过差分数组还原原数组
        int[] sol=new int[n];
        sol[0]=res[0];
        for (int i = 1; i < n; i++) {
            sol[i]=sol[i-1]+res[i];
        }
        return sol;
    }

}
