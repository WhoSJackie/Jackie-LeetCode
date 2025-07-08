package com.wang.java_Learning.designPattern.context;

public class DaoContext {

    private AbstractDao abstractDao;

    public DaoContext(AbstractDao abstractDao){
        this.abstractDao = abstractDao;
    }

    public void executeClient(){
        abstractDao.execute(1L);
    }


}
