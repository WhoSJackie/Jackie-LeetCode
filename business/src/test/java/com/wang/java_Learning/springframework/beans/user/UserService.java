package com.wang.java_Learning.springframework.beans.user;

import lombok.Data;


public class UserService {

    private String userId;
    private IUserDao userDao;

    public String queryUserName(){
        return userDao.queryUserName(userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

}
