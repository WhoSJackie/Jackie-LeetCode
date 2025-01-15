package com.wang.java_Learning.IO.reportProcessor;

import java.util.HashMap;
import java.util.Map;

public class ReportHandleContext {

    private static  Map<Integer,ReportHandleProcessor> typeMap = new HashMap<Integer,ReportHandleProcessor>(){{
        put(ReportHandleProcessor.CREATE_TB,new CreateRpTableProcessor());
        put(ReportHandleProcessor.TB_FIELDS,new GetTableFieldsProcessor());
        put(ReportHandleProcessor.BUILD_RISK,new BuildRiskFieldsProcessor());
    }};

    public static ReportHandleProcessor getProcessor(int type){
        return typeMap.get(type);
    }

}
