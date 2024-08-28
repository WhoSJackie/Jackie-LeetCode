package com.wang.javaL.IO.reportProcessor;

import java.util.HashMap;
import java.util.Map;

public class ReportHandleContext {

    private static  Map<Integer,ReportHandleProcessor> typeMap = new HashMap<Integer,ReportHandleProcessor>(){{
        put(ReportHandleProcessor.CREATE_TB,new CreateRpTableProcessor());
    }};

    public static ReportHandleProcessor getProcessor(int type){
        return typeMap.get(type);
    }

}
