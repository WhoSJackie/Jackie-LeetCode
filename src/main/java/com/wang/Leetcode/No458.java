package com.wang.Leetcode;

public class No458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //向下取整,获得能够验证的次数
        int literator=minutesToTest/minutesToDie;
        int times=literator+1;
        return (int) Math.ceil(Math.log(buckets)/Math.log(times));
    }
}
