package com.wang.java_Learning;

public class CompactCD {

    private static  CompactCD instance;

    private CompactCD(){}

    public static CompactCD getInstance(){
        if(instance==null){
            instance=new CompactCD();
        }

        return instance;
    }

}
