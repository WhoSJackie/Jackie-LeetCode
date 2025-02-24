package com.wang.java_Learning.IO.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class FileUtils<T> {
    public Map<String,Object> params;

    void setBusiParam(){
        // 放入公共默认参数
        params.put("filePath","");
    }
    void preHandle(Map<String,Object> params){}

    abstract Map<String,Object> execute(T t,Map<String,Object> params);

    void postHandle(T t,Map<String,Object> params){}

    Object getRes(){
        return null;
    }


}
