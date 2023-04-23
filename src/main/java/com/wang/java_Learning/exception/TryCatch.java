package com.wang.java_Learning.exception;

public class TryCatch {

    public int testException() {
        int i = 0;
        try {
            i++;
            throw new Exception("error");
        } catch (Exception e) {
            return i++;
        } finally {
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TryCatch().testException());
    }

}
