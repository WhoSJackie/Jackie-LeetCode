package com.wang.java_Learning.IO.processor;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.Map;

public interface HandleProcessor {

    void doProcess(Sheet sheet, Map<String,Object> res);


}
