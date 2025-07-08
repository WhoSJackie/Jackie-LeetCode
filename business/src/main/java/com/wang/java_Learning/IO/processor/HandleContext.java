package com.wang.java_Learning.IO.processor;

import com.wang.java_Learning.IO.HandleProcessEnum;

public class HandleContext {


    public static HandleProcessor getProcessor(int type){
        return HandleProcessEnum.getByCode(type).getProcessor();
    }

}
