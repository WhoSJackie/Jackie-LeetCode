package com.wang.java_Learning.IO.utils;

import com.monitorjbl.xlsx.StreamingReader;
import com.wang.java_Learning.IO.reportProcessor.ReportHandleContext;
import com.wang.java_Learning.IO.reportProcessor.ReportHandleProcessor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtils<T> extends FileUtils<T>{

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
            // todo:和业务耦合度太高，考虑如何拆分
            ReportHandleProcessor processor = ReportHandleContext.getProcessor(type);
            processor.doProcess(sheet,res);
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
        params.put("sheetIx",ReportHandleProcessor.TB_FIELDS);
        params.put("bigXlsxFlag",1);
    }

    public static void main(String[] args) {
        Object obj = new Object();
        FileUtils<Object> utils = new ExcelUtils<Object>();
        utils.setBusiParam();
        Map<String,Object> res = utils.execute(obj,utils.params);
        Map<String,Object> r = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()) return 1;
                else if (o1.length()<o2.length()) return -1;
                else{
                    return o1.compareTo(o2);
                }
            }
        });
        // testBuildRiskFieldsProcessor
//        Map<Integer,Object> sol = (Map)res.get("12");
//        for (Integer ix : sol.keySet()) {
//            System.out.println(ix+"->"+sol.get(ix));
//        }

        // testCreateRpTableProcessor
//        TreeMap<String,Object> sortMap = new TreeMap<>();
//        sortMap.putAll(res);
//        for (Map.Entry<String, Object> entry : sortMap.entrySet()) {
//            // System.out.println(entry.getKey());
//            CreateTbPojo pojo = (CreateTbPojo)entry.getValue();
//            System.out.println(pojo.getSqlScript());
//            System.out.println();
//        }
        // tbField
        Map<String,Object> fieldSortMap = new TreeMap<>(res);
        for (Map.Entry<String, Object> entry : fieldSortMap.entrySet()) {
            String tbName = entry.getKey();
            String[] split = tbName.split("_");
            String docno = split[0];
            String fileno = "EAST5_01_"+docno;
            String vertype = "EAST5";
            String verno = "01";
            String tableName = split[1];
            String docTarget = "RP_EAST5_"+docno;
            String docBex = "pkg_report_east5.krdt_east5_"+docno;
            String writer = "com.szkingdom.krdt.service.impl.BaseSeparatorTxtWriter";
            System.out.println(String.format("insert into rdt_ex_type(FILENO,VERTYPE,VERNO,DOCNO,DOCNOTE,DOCDIRECT,DOCNAME,DOCTARGET,DOCBEX,WRITER) values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');", fileno, vertype, verno, docno, tableName, "E", tableName, docTarget, docBex, writer));
        }

    }



}
