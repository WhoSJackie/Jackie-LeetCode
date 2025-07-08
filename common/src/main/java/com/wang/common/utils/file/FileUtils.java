package com.wang.common.utils.file;

import java.util.Map;

public abstract class FileUtils<T> {
    public Map<String,Object> params;

    public void setBusiParam(){
        // 放入公共默认参数
        params.put("filePath","");
    }
    public void preHandle(Map<String,Object> params){}

    public abstract Map<String,Object> execute(T t, Map<String, Object> params);

    public void postHandle(T t,Map<String,Object> params){}

    public Object getRes(){
        return null;
    }


}
