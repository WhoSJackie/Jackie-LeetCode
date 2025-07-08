package com.wang.java_Learning.IO.processor;

import com.wang.common.pojo.TbFieldPojo;
import com.wang.common.pojo.TbFieldsPojo;
import com.wang.common.utils.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GetTableFieldsProcessor implements HandleProcessor {
    @Override
    public void doProcess(Sheet sheet, Map<String,Object> res) {
        Iterator<Row> rowIterator = sheet.rowIterator();
        int rix=0;
        String tbName = "";
        String tbchname = "";
        TbFieldsPojo fs = new TbFieldsPojo();
        // 表的结尾符号
        boolean tbEnd = false;
        TbFieldPojo f = null;
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
                if (index != 0 && index != 3 && index != 4 && index != 5 && index != 7 && index !=11 && index != 12 && index!=16) {
                    // 跳过无用列
                    index++;
                    continue;
                }
                String v = cell.getStringCellValue().trim();
                // 如果第一列有值，则是主体划分
                if (index==0){
                    if (!StringUtils.isEmpty(v)){
                        index++;
                        continue;
                    }
                }
                // 如果第五列有值，第六列没值，则是表的划分
                if (index==3){
                    if (!StringUtils.isEmpty(v)) {
                        tbchname = v;
                    }
                }
                if (index==4){
                    if (!StringUtils.isEmpty(v)) {
                        String no = v;
                        char theme;
                        if (no.length() == 3) {
                            theme = (char) ('A' + (Integer.valueOf(no.substring(0, 1)) - 1));
                        } else {
                            theme = (char) ('A' + (Integer.valueOf(no.substring(0, 2)) - 1));
                        }
                        tbName = "RP_EAST5_" + String.valueOf(theme) + no;
                        tbchname = theme + no + "_" + tbchname;
                        flag = true;
                    }
                }

                if (index==5){
                    if (flag && StringUtils.isEmpty(v)){
                        f = new TbFieldPojo();
                        continue;
                    }
                    if (!StringUtils.isEmpty(v)) f.setFcname(v);
                }
                if (index==7){
                    // 字段名
                    if (!StringUtils.isEmpty(v)) {
                        fieldName = v;
                        f.setFname(fieldName);
                        if ("CJRQ".equalsIgnoreCase(fieldName)) {
                            // 到达表的结尾
                            tbEnd=true;
                        }
                    }
                }
                if (index==11){
                    // 字段类型
                    if (!StringUtils.isEmpty(v)) {
                        f.setType(v);
                    }
                }
                // 设置主键
                if (index == 12){
                    if (!StringUtils.isEmpty(fieldName)){
                        if ((!StringUtils.isEmpty(v) && (v.contains("PK")))||("ID".equalsIgnoreCase(fieldName))){
                            f.setPkFlag(true);
                        }
                    }
                }
                // 设置必填字段
                if (index ==16){

                    if (!StringUtils.isEmpty(fieldName)){
                        if (!StringUtils.isEmpty(v) && "必填".equals(v)) f.setRequiredFlag(true);
                        List<TbFieldPojo> fields = fs.getFields();
                        if (fields==null){
                            fields = new ArrayList<>();
                        }
                        fields.add(new TbFieldPojo(f.getFname(),f.getFcname(),f.getType(),f.isPkFlag(),f.isRequiredFlag()));
                        fs.setFields(fields);
                        f = new TbFieldPojo();
                    }
                }
                index++;
            }
            if (tbEnd){
                // 到达一个表的结尾
                res.put(tbchname,new TbFieldsPojo(fs.getFields()));
                tbEnd = false;
                fs = new TbFieldsPojo();
            }
        }
    }
}
