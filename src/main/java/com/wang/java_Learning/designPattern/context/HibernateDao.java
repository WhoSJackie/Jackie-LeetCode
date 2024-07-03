package com.wang.java_Learning.designPattern.context;

public class HibernateDao extends AbstractDao{
    @Override
    public void execute(Long id) {
        System.out.println("hibernate dao...");
    }
}
