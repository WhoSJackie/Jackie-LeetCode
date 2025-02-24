package com.wang.java_Learning.IO.reportProcessor;

import com.wang.java_Learning.IO.pojo.TbFieldPojo;
import com.wang.java_Learning.IO.pojo.TbFieldsPojo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class East5BuildImpExcelTool {

    private static final String STAR_DELIMITER = "*";
    private static final String DOT_DELIMITER = ".";

    public void buildSingleImpExcelFile(String filePath,String fileName,String sheetName,TbFieldsPojo data,boolean isXlsx){
        filePath = filePath+fileName+DOT_DELIMITER+(isXlsx?"xlsx":"xls");
        File file = new File(filePath);
        Workbook book = null;
        try (FileOutputStream outputStream = new FileOutputStream(file)){
            boolean flag = true;
            if (!file.exists()){
                flag = false;
                flag = file.createNewFile();
            }
            if (!flag) throw new RuntimeException("文件创建失败！");
            book = new XSSFWorkbook();
            Sheet sheet = book.createSheet(sheetName);
            sheet.setDefaultColumnWidth(24);

            // ******创建样式*******
            XSSFRichTextString richText = new XSSFRichTextString();
            // 设置字体
            Font fontStar = book.createFont();
            fontStar.setFontName("微软雅黑");
            fontStar.setColor(Font.COLOR_RED);

            Font fontText = book.createFont();
            fontText.setFontName("微软雅黑");

            // 设置居中
            CellStyle cellStyle = book.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);

            // *******创建样式结束******

            // 创建行
            Row row = sheet.createRow(0);
            List<TbFieldPojo> dataList =  data.getFields();
            if (CollectionUtils.isEmpty(dataList)) throw new RuntimeException("数据列表为空，请检查数据!");
            for (int i = 0; i < dataList.size(); i++) {
                TbFieldPojo pojo = dataList.get(i);
                Cell cell = row.createCell(i);
                if (pojo.isRequiredFlag()){
                    richText.setString(STAR_DELIMITER);
                    richText.applyFont(fontStar);
                    richText.append(pojo.getFcname(),(XSSFFont) fontText);
                } else{
                    richText.setString(pojo.getFcname());
                    richText.applyFont(fontText);
                }
                cell.setCellStyle(cellStyle);
                cell.setCellValue(richText);
            }
            book.write(outputStream);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                book.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void buildEast5ImpExcelFile(String filePath,int sheetIx,boolean isXlsx,int bigXlsxMode){
        Map<String,Object> params = new HashMap<>();
        params.put("filePath",filePath);
        params.put("sheetIx",sheetIx);
        params.put("bigXlsxFlag",bigXlsxMode);
        params.put("type",ReportHandleProcessor.TB_FIELDS);
        Object obj = new Object();
        Map<String, Object> file1 = new ReportDefaultExcelUtils().execute(obj,params);
        // 排序
        Map<String,Object> map = new TreeMap();
        map.putAll(file1);
        for (String s : map.keySet()) {
            System.out.println("*******"+s+"_处理中****************");
            TbFieldsPojo res = (TbFieldsPojo)file1.get(s);
            // 处理id字段
            List<TbFieldPojo> fields = res.getFields();
            for (int i = 0; i < fields.size(); i++) {
                if (fields.get(i)!=null && "ID".equalsIgnoreCase(fields.get(i).getFcname())){
                    fields.get(i).setFcname("ID(系统生成，无需填写)");
                    fields.get(i).setRequiredFlag(false);
                    break;
                }
            }
            buildSingleImpExcelFile("C:\\Users\\jiami\\Desktop\\east5_import\\",s,s,res,isXlsx);
        }
        System.out.println("处理成功!");
    }


    public static void main(String[] args) {
        new East5BuildImpExcelTool().buildEast5ImpExcelFile("D:\\work\\报送口径文档\\报送口径文档\\east5\\2024.8监管数据规范化\\附件1：金融监管总局信托业监管数据标准化规范（2024版）一览表.xlsx",4,true,1);
    }


}
