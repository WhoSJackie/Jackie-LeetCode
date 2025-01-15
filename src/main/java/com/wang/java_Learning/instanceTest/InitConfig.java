package com.wang.java_Learning.instanceTest;

import java.util.HashMap;
import java.util.Map;

public class InitConfig {

    private static InitConfig instance=new InitConfig();

    public static InitConfig getInstance(){
        return instance;
    }

    public Map<String,String> initConfig(String key){
        Map<String,String> authMap=new HashMap<>();
        if ("1".equals(key)){
            authMap.put(key,"one");
        }else if ("2" .equals(key)){
            authMap.put(key,"two");
        }
        if(!authMap.isEmpty()){
            return authMap;
        }
        return new HashMap<String,String>(){
            {
                put("0","empty");
            }
        };

    }

}
