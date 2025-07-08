package com.wang.java_Learning.IO.processor;

import com.wang.common.utils.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.text.SimpleDateFormat;
import java.util.*;

public class TimeTableProcessor implements HandleProcessor {
    @Override
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
                String str = cell.getStringCellValue();
                res.add((str==null || "".equals(str))?"":str.substring(5));
            }
        }
        return res;
    }

}
