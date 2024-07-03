package com.wang.java_Learning.designPattern.context;

public class DaoClient {

    public static void main(String[] args) {
        DaoContext daoContext = new DaoContext(new HibernateDao());
        daoContext.executeClient();
    }


}
