package com.wang.javaL.IO;

import com.monitorjbl.xlsx.StreamingReader;
import com.wang.javaL.IO.reportProcessor.ReportHandleContext;
import com.wang.javaL.IO.reportProcessor.ReportHandleProcessor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.util.*;

public class ExcelUtils extends FileUtils{

    @Override
    List<String> execute(String filePath, int... a) {
        List<String> strs = new ArrayList<>();
        try (FileInputStream input = new FileInputStream(filePath)){
            Workbook workbook = StreamingReader.builder()
                    .bufferSize(4096) // 设置缓存的大小
                    .rowCacheSize(100) // 缓存行的数量，也就是每次读取多少行到内存中，而不是一下子全都加载进内存
                    .open(input); // 设置要打开的文件
            int sheetIx = a[0];
            int type = a[1];
            Sheet sheet = workbook.getSheetAt(sheetIx);
            ReportHandleProcessor processor = ReportHandleContext.getProcessor(type);
            processor.doProcess(sheet,strs);
        } catch (Exception e){
            e.printStackTrace();
        }
        return strs;
    }


    public static void main(String[] args) {
        List<String> list = new ExcelUtils().execute("D:\\work\\报送口径文档\\报送口径文档\\east5\\信托业监管数据标准化规范(2024)\\规范附件1：金融监管总局信托业监管数据标准化规范一览表.xlsx",4,ReportHandleProcessor.CREATE_TB);
        for (int i = 0; i < list.size(); i++) {
//            if (i>=41) {
//
//            }
            System.out.println(list.get(i));
        }
    }



}
