package com.wang.java_Learning.IO.utils;

import com.monitorjbl.xlsx.StreamingReader;
import com.wang.common.enums.HandleProcessEnum;
import com.wang.java_Learning.IO.reportProcessor.HandleContext;
import com.wang.java_Learning.IO.reportProcessor.HandleProcessor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class DefaultExcelUtils<T> extends FileUtils<T>{

    @Override
    public Map<String,Object> execute(T t,Map<String,Object> params) {
        String filePath = params.get("filePath").toString();
        int type = Integer.parseInt(params.get("type").toString());
        int sheetIx = Integer.parseInt(params.get("sheetIx").toString());
        int isBigXlsx = Integer.parseInt(params.getOrDefault("bigXlsxFlag",0).toString());
        Map<String, Object> res= new HashMap<>();
        Workbook workbook = null;
        try (FileInputStream input = new FileInputStream(filePath)){
            if (isBigXlsx==1){
                workbook = StreamingReader.builder()
                        .bufferSize(4096) // 设置缓存的大小
                        .rowCacheSize(100) // 缓存行的数量，也就是每次读取多少行到内存中，而不是一下子全都加载进内存
                        .open(input); // 设置要打开的文件
            } else{
                workbook = WorkbookFactory.create(input);
            }
            Sheet sheet = workbook.getSheetAt(sheetIx);
            // 和业务耦合度太高，考虑拆分,可以考虑使用子类继承该类实现具体业务代码来实现
            doBusiness(sheet,res,type);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
     void setBusiParam() {
        params.put("filePath","D:\\work\\报送口径文档\\报送口径文档\\east5\\2024.8监管数据规范化\\附件1：金融监管总局信托业监管数据标准化规范（2024版）一览表.xlsx");
        params.put("type",4);
        params.put("sheetIx", HandleProcessEnum.TB_FIELDS);
        params.put("bigXlsxFlag",1);
    }

    public void doBusiness(Sheet sheet, Map<String, Object> res,int type){
        HandleProcessor processor = HandleContext.getProcessor(type);
        processor.doProcess(sheet,res);
    }

    public static void main(String[] args) {

    }



}
