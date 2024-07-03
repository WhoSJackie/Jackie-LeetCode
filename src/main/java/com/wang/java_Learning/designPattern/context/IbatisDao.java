package com.wang.java_Learning.designPattern.context;

public class IbatisDao extends AbstractDao{

    @Override
    public void execute(Long id) {
        System.out.println("ibatisDao...");
    }
}
