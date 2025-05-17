package com.wang.java_Learning.equalTest;


import com.wang.java_Learning.utils.StringUtils;

import java.util.HashSet;

public class UserInfo {

    public UserInfo(){}

    public UserInfo(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }

        if(o==null){
            return false;
        }

        if(o instanceof UserInfo){
            UserInfo user=(UserInfo)o;
            if(equalsStr(this.name,user.name)&&this.age.equals(user.age)){
                return true;
            }
        }

        return false;
    }

    public boolean equalsStr(String str1,String str2){
        if(StringUtils.isEmpty(str1)&&StringUtils.isEmpty(str2)){
            return true;
        }

        if(!StringUtils.isEmpty(str1)&&str1.equals(str2)){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode(){
        int result=31;
        result=31*result+(name==null?0:name.hashCode());
        result=31*result+(age==null?0:age.hashCode());
        return result;
    }

    public static void main(String[] args) {
        UserInfo user1=new UserInfo(1L,"jackie",34);
        UserInfo user2=new UserInfo(2L,"jackie",34);
        System.out.println(user1.equals(user2));

        HashSet<UserInfo> set=new HashSet<>();
        set.add(user1);
        set.add(user2);

        System.out.println(set);
    }

}
