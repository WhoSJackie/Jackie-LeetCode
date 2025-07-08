package com.wang.java_Learning.exception;

public class TryCatch {

    public int testException() {
        try {
            for (int j = 0; j < 10000; j++) {
//                if (j==2) {
//                    System.out.println("跳出!");
//                    return j;
//                }
//                if (j==6)  throw new Exception("error");
                Thread.sleep(500);
                System.out.println(j);
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new TryCatch().testException());
    }

}
