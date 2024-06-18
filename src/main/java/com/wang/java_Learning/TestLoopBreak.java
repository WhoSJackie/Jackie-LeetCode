package com.wang.java_Learning;

public class TestLoopBreak {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            if (i==3||i==4) {
                break;
            } else {
                System.out.println(i);
            }
        }

    }

}
