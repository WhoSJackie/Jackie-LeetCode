package com.wang.java_Learning.springframework.beans;

import com.wang.java_Learning.springframework.beans.factory.DisposableBean;
import com.wang.java_Learning.springframework.beans.factory.InitializingBean;

public class ApiService implements InitializingBean, DisposableBean {

    private String uid;

    private ApiDao apiDao;

    private String location;

    private String company;

    public void testService(){
        System.out.println("name is: "+apiDao.queryUserName(uid));
        System.out.println("company is: "+this.company);
        System.out.println("location is: "+this.location);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ApiDao getApiDao() {
        return apiDao;
    }

    public void setApiDao(ApiDao apiDao) {
        this.apiDao = apiDao;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
