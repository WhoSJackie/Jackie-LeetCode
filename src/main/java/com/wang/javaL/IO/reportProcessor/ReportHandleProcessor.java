package com.wang.javaL.IO.reportProcessor;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.Map;

public interface ReportHandleProcessor {
    int CREATE_TB = 0;
    int TB_FIELDS = 1;
    int BUILD_RISK = 2;

    void doProcess(Sheet sheet, Map<String,Object> res);


}
