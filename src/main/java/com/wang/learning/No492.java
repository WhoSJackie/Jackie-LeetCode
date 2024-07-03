package com.wang.learning;

public class No492 {
    public int[] constructRectangle(int area) {
        int begin=(int)Math.sqrt(area);
        while(area%begin!=0){
            begin--;
        }
        return new int[]{area/begin,begin};
    }

    public static void main(String[] args) {
       int[] a= new No492().constructRectangle(10000000);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
