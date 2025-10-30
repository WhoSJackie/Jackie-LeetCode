package com.wang.common;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ZGtgcsImp {

    public static void fillInfoByExcel(File file){
        List<String[]> infoList = readExcel(file,2);
        for (String[] info : infoList) {
            for (String s : info) {
                System.out.print(s+"->");
            }
            System.out.println();
        }
    }

    public static List<String[]> readExcel(File file, int rowStart){
        List<String[]> res = new ArrayList<>();
        InputStream is = null;
        try{
            is = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i=rowStart;i<=sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);
                int rowNum = row.getRowNum();
                System.out.println("列数据："+rowNum);
                String[] cellInfo = new String[rowNum];
                for (int j = 0; j < rowNum; j++) {
                    cellInfo[j] = row.getCell(j).getStringCellValue();
                }
                res.add(cellInfo);
            }
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        fillInfoByExcel(new File("C:\\Users\\jiami\\Desktop\\固定投顾费-20250925(1).xlsx"));
    }

}
