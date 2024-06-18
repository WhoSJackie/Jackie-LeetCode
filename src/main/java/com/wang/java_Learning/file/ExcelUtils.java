package com.wang.java_Learning.file;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelUtils {

    public static void parseXlsm(String filePath){
        try (FileInputStream input = new FileInputStream(filePath)){
            Workbook workbook = StreamingReader.builder()
                    .bufferSize(4096) // 设置缓存的大小
                    .rowCacheSize(100) // 缓存行的数量，也就是每次读取多少行到内存中，而不是一下子全都加载进内存
                    .open(input); // 设置要打开的文件
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    System.out.println(cell.getStringCellValue().trim());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXlsm("C:\\Users\\jiami\\Desktop\\DQ01_产品基本信息.xlsm");
    }


}
