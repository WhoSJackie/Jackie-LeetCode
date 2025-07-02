package com.wang.java_Learning.IO.reportProcessor;

import com.wang.common.enums.HandleProcessEnum;

import java.util.HashMap;
import java.util.Map;

public class HandleContext {


    public static HandleProcessor getProcessor(int type){
        return HandleProcessEnum.getByCode(type).getProcessor();
    }

}
