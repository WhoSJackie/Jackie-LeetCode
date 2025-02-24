package com.wang.java_Learning.IO.reportProcessor;

import com.wang.java_Learning.IO.utils.DefaultExcelUtils;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ReportDefaultExcelUtils<T> extends DefaultExcelUtils<T> {

    @Override
    public Map<String, Object> execute(T t, Map<String, Object> params) {
        return super.execute(t, params);
    }

    @Override
   public void doBusiness(Sheet sheet, Map<String, Object> res,int type){
        ReportHandleProcessor processor = ReportHandleContext.getProcessor(type);
        processor.doProcess(sheet,res);
   }

    public static void main(String[] args) {
        Object obj = new Object();
        ReportDefaultExcelUtils<Object> utils = new ReportDefaultExcelUtils<Object>();
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
