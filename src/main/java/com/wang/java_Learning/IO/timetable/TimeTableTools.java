package com.wang.java_Learning.IO.timetable;

import com.wang.common.enums.HandleProcessEnum;
import com.wang.java_Learning.IO.utils.DefaultExcelUtils;
import com.wang.java_Learning.utils.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeTableTools {

    private final static String[] dayOfWeek= new String[]{"周一","周二","周三","周四","周五","周六","周日"};
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
    private final static Long dayTimeMill = 24*60*60*1000L;

    public void filterName(Map<String,Object> params,String targetFilePath,String filterName,String startDate,String endDate){
        DefaultExcelUtils<Object> excelUtils = new DefaultExcelUtils<>();
        Map<String, Object> res = excelUtils.execute(new Object(), params);
        // 检查文件夹存在
        File fileDir = new File(targetFilePath);
        if (!fileDir.exists()){
            fileDir.mkdir();
        }
        File file = new File(targetFilePath+File.separator+filterName+".xlsx");
        Workbook book = null;
        try (FileOutputStream output = new FileOutputStream(file)){
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            book = new XSSFWorkbook();
            Sheet sheet1 = book.createSheet("sheet1");
            /** 创建样式  **/
            sheet1.setDefaultColumnWidth(21);
            sheet1.setDefaultRowHeightInPoints(20.75f);
            // 设置字体
            Font fontText = book.createFont();
            fontText.setFontName("宋体");
            fontText.setBold(true);
            fontText.setFontHeightInPoints((short)16);

            // 设置背景色
            CellStyle cellStyle = book.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            int colNum = 0,rowNum = 0;
            // 创建第一行
            Row row = sheet1.createRow(rowNum++);
            for (int i = 0; i < dayOfWeek.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(buildRichText(dayOfWeek[i],fontText));
            }
            // 创建具体内容行
            List<String> dateList = buildTimeLine(startDate, endDate);
            if (dateList.size()!=res.size()) throw new RuntimeException("输入的日期和读取课程表的日期不一致!");
            Row newRow = null;
            Row headRow = null;
            for (int i = 0; i < dateList.size(); i++) {
                colNum=i%7;
                // 写入日期
                if (colNum==0){
                    headRow = sheet1.createRow(rowNum++);
                    newRow = sheet1.createRow(rowNum++);
                }
                // 写日期
                Cell headCell = headRow.createCell(colNum);
                String date = dateList.get(i);
                headCell.setCellValue(buildRichText(date,fontText));
                // 写内容
                Cell cell = newRow.createCell(colNum);
                List<String> nameArr = (List)res.get(date);
                String s = "";
                if (nameArr!=null && nameArr.size()>0) s = nameArr.stream().filter(item -> item.contains(filterName)).findFirst().orElse("");
                cell.setCellValue(buildRichText(s,fontText));
                if (!StringUtils.isEmpty(s)) cell.setCellStyle(cellStyle);
            }
            book.write(output);
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                book.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private List<String> buildTimeLine(String startDate,String endDate){
        List<String> dateList = new ArrayList<>();
        try {
            Long start = sdf.parse(startDate).getTime();
            Long end = sdf.parse(endDate).getTime();
            Long cur = start;
            while (cur<=end){
                dateList.add(sdf.format(cur).substring(5));
                cur +=dayTimeMill;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateList;
    }
    public XSSFRichTextString buildRichText(String value,Font font){
        XSSFRichTextString richText = new XSSFRichTextString();
        richText.setString(value);
        richText.applyFont(font);
        return richText;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件路径:");
        String filePath = scanner.nextLine();
        System.out.println("请输入sheet号:");
        int ix  = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入过滤姓名:");
        String filterName = scanner.nextLine();
        System.out.println("请输入目标excel地址:");
        String tarFilePath = scanner.nextLine();
        System.out.println("请输入开始日期(xxxx年x月x日):");
        String startDate = scanner.nextLine();
        System.out.println("请输入结束日期(xxxx年x月x日):");
        String endDate = scanner.nextLine();
        Map<String,Object> params = new HashMap<>();
        params.put("filePath",filePath);
        params.put("sheetIx",ix);
        params.put("bigXlsxFlag",0);
        params.put("type", HandleProcessEnum.TIMETABLE.getCode());
        new TimeTableTools().filterName(params,tarFilePath,filterName,startDate,endDate);
    }


}
