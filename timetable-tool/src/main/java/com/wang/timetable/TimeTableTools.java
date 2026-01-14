package com.wang.timetable;

import com.monitorjbl.xlsx.StreamingReader;
import com.wang.common.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeTableTools {

    private final static String[] dayOfWeek= new String[]{"周一","周二","周三","周四","周五","周六","周日"};
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
    private final static Long dayTimeMill = 24*60*60*1000L;

    private final static Logger log = LogManager.getLogger(TimeTableTools.class);

    public void filterName(Map<String,Object> params,String targetFilePath,String filterName){
        Map<String, Object>  res = execute(params);
        // 检查文件夹存在
        File fileDir = new File(targetFilePath);
        if (!fileDir.exists()){
            fileDir.mkdir();
        }
        File file = new File(targetFilePath+File.separator+filterName+".xlsx");
        Workbook book = null;
        int stuCount = 0;
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
            String[] sedate = getStartDateAndEndDate(res);
            List<String> dateList = buildTimeLine(sedate[0],sedate[1]);
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
                if (!StringUtils.isEmpty(s)) {
                    cell.setCellStyle(cellStyle);
                    stuCount++;
                }
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
        log.info("生成文件成功!");
        log.info("学生课程总数: "+stuCount);
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

    private String[] getStartDateAndEndDate(Map<String,Object> res){
        String startDate = "",endDate="";
        try{
            Calendar cal = Calendar.getInstance();
            for (String s : res.keySet()) {
                s = cal.get(Calendar.YEAR)+"年"+s;
                if (StringUtils.isEmpty(startDate)){
                    startDate = s;
                } else{
                    long time = sdf.parse(startDate).getTime();
                    long time1 = sdf.parse(s).getTime();
                    if (time1<time) startDate = s;
                }
                if (StringUtils.isEmpty(endDate)){
                    endDate = s;
                } else{
                    long time = sdf.parse(endDate).getTime();
                    long time1 = sdf.parse(s).getTime();
                    if (time1>time) endDate = s;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new String[]{startDate,endDate};
    }

    public Map<String,Object> execute(Map<String,Object> params) {
        String filePath = params.get("filePath").toString();
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
            doProcess(sheet,res);
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

    public void doProcess(Sheet sheet, Map<String, Object> res) {
        List<String> date = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        int rowNum = 0,colNum = 0,rowFlag = 1,colFlag = 6;

        // 行遍历
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // 第一行不处理
            if (rowNum==0) {
                rowNum++;
                continue;
            }
            // 到达新的一周
            if (rowNum==rowFlag){
                rowFlag+=colFlag;
                Iterator<Cell> cellIterator = row.cellIterator();
                // 获取新的日期
                date = getDate(cellIterator);
                rowNum++;
                continue;
            }
            // 列遍历
            colNum = 0;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (colNum>6) break;
                String key = date.get(colNum);
                // 保证课表的日期都存在
                List<String> strArr = (List<String>) res.getOrDefault(key, new ArrayList<>());
                if (!res.containsKey(key)) res.put(key,strArr);
                // 跳过空单元格
                if (StringUtils.isEmpty(cell.getStringCellValue())) {
                    colNum++;
                    continue;
                }
                strArr.add(cell.getStringCellValue());
                res.put(key,strArr);
                colNum++;
            }
            rowNum++;
        }
        // 去除空的键
        res.remove("");
    }

    // 读取日期头
    private List<String> getDate(Iterator<Cell> cellIterator){
        List<String> res = new ArrayList<>();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            CellType cellType = cell.getCellType();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
            if (cellType.equals(CellType.NUMERIC)){
                Date date = cell.getDateCellValue();
                res.add(sdf.format(date).substring(5));
            } else{
                String strDate = cell.getStringCellValue();
                res.add(strDate);
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        TimeTableTools timeTableTools = new TimeTableTools();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入文件路径:");
//        String filePath = scanner.nextLine();
//        System.out.println("请输入sheet号(从0开始):");
//        int ix  = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("请输入目标excel地址:");
//        String tarFilePath = scanner.nextLine();
//        Map<String,Object> params = new HashMap<>();
//        params.put("filePath",filePath.trim().replace("\"",""));
//        params.put("sheetIx",ix);
//        params.put("bigXlsxFlag",0);
//        System.out.println("请输入过滤姓名(输入exit为退出):");
//        String filterName = scanner.nextLine().trim();
//        timeTableTools.filterName(params,tarFilePath,filterName);
//        while (!"exit".equals(filterName)){
//            System.out.println("请输入过滤姓名(输入exit为退出):");
//            filterName = scanner.nextLine();
//            if ("exit".equals(filterName)) break;
//            timeTableTools.filterName(params,tarFilePath,filterName);
//        }
        log.info("test1");
    }


}
