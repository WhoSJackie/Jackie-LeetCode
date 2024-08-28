package com.wang.javaL.IO.reportProcessor;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public interface ReportHandleProcessor {
    int CREATE_TB = 0;

   void doProcess(Sheet sheet,List<String> strs);


}
