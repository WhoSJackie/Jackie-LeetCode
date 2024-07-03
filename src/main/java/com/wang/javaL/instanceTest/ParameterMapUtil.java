package com.wang.javaL.instanceTest;

import java.util.Map;

public class ParameterMapUtil {

    protected static Map<String,String> parameterMap;

    private static String key="1";

    public static synchronized void initConfig(){
        if(parameterMap==null){
            parameterMap=InitConfig.getInstance().initConfig(key);
        }
    }

    public static Map<String,String> getParameterMap(){
        return parameterMap;
    }

}
