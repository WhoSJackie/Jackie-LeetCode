package com.wang.java_Learning.instanceTest;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FunctionTest {

    static{
        ParameterMapUtil.initConfig();
    }

    public Map<String,String> getParameterMap(){
        Map<String,String> res=Optional.ofNullable(ParameterMapUtil.getParameterMap()).orElse(new HashMap<String,String>(){{
           put("unknown","unknown");
        }});
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FunctionTest().getParameterMap());
    }

}
