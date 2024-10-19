package com.wang.javaL.IO.reportProcessor;

import com.wang.javaL.util.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.*;

public class BuildRiskFieldsProcessor implements ReportHandleProcessor{
    @Override
    public void doProcess(Sheet sheet, Map<String, Object> res) {
        Map<Integer, List<int[]>> mergeRange = new HashMap<>();
        // 先获取每一层合并单元格范围
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
            int firstRow = mergedRegion.getFirstRow();
            int firstColumn = mergedRegion.getFirstColumn();
            int lastRow = mergedRegion.getLastRow();
            int lastColumn = mergedRegion.getLastColumn();
            if (firstRow>=10 && firstRow<=12){
                List<int[]> ranges = mergeRange.getOrDefault(firstRow,new ArrayList<>());
                ranges.add(new int[]{firstColumn,lastColumn});
                mergeRange.put(firstRow,ranges);
            }
        }
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            int rowNum = row.getRowNum();
            if (rowNum>=10 && rowNum<=12){
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String value = cell.getStringCellValue();
                    int colIndex = cell.getColumnIndex();
                    // 进行字段拼接
                    if (rowNum==12){
                        if (StringUtils.isEmpty(value)){
                            Map<Integer,String> temp = (Map)res.get(String.valueOf(rowNum-1));
                            if (temp.get(colIndex)!=null){
                                Map<Integer,String> re = (Map)res.getOrDefault(String.valueOf(rowNum),new HashMap<>());
                                re.put(colIndex,temp.get(colIndex));
                                res.put(String.valueOf(rowNum),re);
                            }else{
                                temp = (Map)res.get(String.valueOf(rowNum-2));
                                if (temp.get(colIndex)!=null){
                                    Map<Integer,String> re = (Map)res.getOrDefault(String.valueOf(rowNum),new HashMap<>());
                                    re.put(colIndex,temp.get(colIndex));
                                    res.put(String.valueOf(rowNum),re);
                                }
                            }
                            continue;
                        }
                        // 如果属于合并单元格，则与上层进行合并
                        int inRange = findInRange(rowNum-1, cell.getColumnIndex(), mergeRange);
                        if (inRange!=-1){
                            Map<Integer,String> tmp = (Map)res.getOrDefault(String.valueOf(rowNum),new HashMap<>());
                            Map<Integer,String> lastRow = (Map)res.get(String.valueOf(rowNum-1));
                            tmp.put(colIndex,value+"("+lastRow.get(inRange)+")");
                            res.put(String.valueOf(rowNum),tmp);
                        }
                    } else{
                        if (StringUtils.isEmpty(cell.getStringCellValue())) continue;
                        Map<Integer,String> tmp = (Map)res.getOrDefault(String.valueOf(rowNum),new HashMap<>());
                        tmp.put(colIndex,value);
                        res.put(String.valueOf(rowNum),tmp);
                    }
                }
            } else if (rowNum>12) break;
        }

        // 进行sql语句拼接
        Map<Integer,String> risks= (Map)res.get("12");
        StringBuilder sb  =new StringBuilder();
        for (Integer risk : risks.keySet()) {
            sb.append("insert into rdt_risk_index_detail (id,riskname) values (").append(risk).append(",'").append(risks.get(risk)).append("');");
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    private int findInRange(int row,int index, Map<Integer,List<int[]>> rangeMap){
        List<int[]> ranges = rangeMap.get(row);
        for (int[] range : ranges) {
            for (int i = 0; i < range.length; i++) {
                if (index>=range[0]&&index<=range[1]){
                    return range[0];
                }
            }
        }
        return -1;
    }
}
