package com.wang.javaL.IO.reportProcessor;

import com.wang.javaL.util.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateRpTableProcessor implements ReportHandleProcessor{



    @Override
    public void doProcess(Sheet sheet, List<String> strs) {
        Iterator<Row> rowIterator = sheet.rowIterator();
        int rix=0;
        String tbName = "";
        StringBuilder sb = new StringBuilder();
        // 表的结尾符号
        boolean tbEnd = false;
        List<String> pkList = new ArrayList<>();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            if (rix++<4) continue;
            Iterator<Cell> cellIterator = row.cellIterator();
            int index=0;
            // 处理行数据
            boolean flag = false;
            String fieldName = "";
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                String v = cell.getStringCellValue().trim();
                // 如果第一列有值，则是主体划分
                if (index==1){
                    if (!StringUtils.isEmpty(v)){
                        continue;
                    }
                }
                // 如果第四列有值，第五列没值，则是表的划分
                if (index==4){
                    if (!StringUtils.isEmpty(v)) {
                        String no = v;
                        char theme;
                        if (no.length()==3){
                            theme = (char)('A'+(Integer.valueOf(no.substring(0,1))-1));
                        } else{
                            theme = (char)('A'+(Integer.valueOf(no.substring(0,2))-1));
                        }
                        tbName = "RP_EAST5_"+ String.valueOf(theme) +no;
                        flag = true;
                    }
                }
                if (index==5){
                    if (flag && StringUtils.isEmpty(v)){
                        sb.append("create table ").append(tbName).append("\n").append("(").append("\n").append("  BATCHNO      INTEGER NOT NULL,").append("\n");
                    }
                }
                if (index==7){
                    // 字段名
                    if (!StringUtils.isEmpty(v)) {
                        fieldName = v;
                        sb.append("  ").append(fieldName).append("    ");
                        if ("CJRQ".equalsIgnoreCase(fieldName)) {
                            // 到达表的结尾
                            tbEnd=true;
                        }
                    }
                }
                if (index==11){
                    // 字段类型
                    if (!StringUtils.isEmpty(v)) {
                        sb.append(transferDateType(v));
                    }
                }
                if (index == 12){
                    // 判断主键
                    if (!StringUtils.isEmpty(fieldName)){
                        if ((!StringUtils.isEmpty(v) && (v.contains("PK")))||("ID".equalsIgnoreCase(fieldName))){
                            pkList.add(fieldName);
                            sb.append(" NOT NULL,\n");
                        } else{
                            sb.append(",\n");
                        }
                    }
                }
                index++;
            }
            if (tbEnd){
                // 到达一个表的结尾
                sb.append("  DATASOURCE   CHAR(1)").append("\n").append(");").append("\n").
                        append("alter table ").append(tbName).append(" add constraint ").append(tbName).append(" primary key (BATCHNO");
                for (String s : pkList) {
                    sb.append(",").append(s);
                }
                sb.append(");\n");
                strs.add(String.valueOf(sb));
                tbEnd=false;
                sb.setLength(0);
                // 清空主键列表
                pkList.clear();
            }
        }
    }


    private String transferDateType(String val){
        StringBuilder sb = new StringBuilder();
        if (val.contains("!")){
            // Id
            sb.append("VARCHAR(36)");
        } else if ("an".equals(val.substring(0,2))){
            // 变长字符串
            String[] sp = val.split("\\.\\.");
            if (sp.length!=2) throw new RuntimeException("变长字符串类型转换失败!");
            sb.append("VARCHAR2(").append(sp[1]).append(")");
        } else if (val.contains("(")){
            // 数值类型,带小数点
            String[] split = val.split("\\(");
            if (split.length!=2) throw new RuntimeException("数字类型转换失败!");
            sb.append("NUMBER(").append(split[0]).append(",").append(split[1].substring(0,split[1].length()-1)).append(")");
        } else if("n".equals(val.substring(0,1))){
            String[] sp = val.split("\\.\\.");
            if (sp.length!=2) throw new RuntimeException("变长数字类型转换失败!");
            sb.append("NUMBER(").append(sp[1]).append(")");
        } else if ("YYYY-MM".equalsIgnoreCase(val.substring(0,7))){
            sb.append("VARCHAR2(").append(val.length()).append(")");
        } else{
            sb.append("ERROR");
        }
        return sb.toString();
    }
}
