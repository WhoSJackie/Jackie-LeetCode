package com.wang.java_Learning.IO.processor;

import com.wang.java_Learning.IO.HandleProcessEnum;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Map;

public class HandleContext {


    public static HandleProcessor getProcessor(int type){
        return HandleProcessEnum.getByCode(type).getProcessor();
    }

    public static void DoProcess(int type, Sheet sheet, Map<String,Object> res){
        HandleProcessEnum.getByCode(type).getProcessor().doProcess(sheet,res);
    }

}
