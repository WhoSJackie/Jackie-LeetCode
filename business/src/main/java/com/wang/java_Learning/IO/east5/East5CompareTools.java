package com.wang.java_Learning.IO.east5;

import com.wang.java_Learning.IO.HandleProcessEnum;
import com.wang.common.pojo.TbFieldPojo;
import com.wang.common.pojo.TbFieldsPojo;
import com.wang.java_Learning.IO.DefaultExcelUtils;

import java.util.*;

/**
 * 粗略比较新旧版文档字段的不同，如果要细化可以将string换成boolean[3],每一个位置代表一个状态。
 */
public class East5CompareTools {

    public Map<String, List<String>> compare(String filePath1, String filePath2, int sheetIx1, int sheetIx2){
        Map<String,List<String>> res = new HashMap<>();
        Map<String,Object> params1 = new HashMap<>();
        Map<String,Object> params2 = new HashMap<>();
        params1.put("filePath",filePath1);
        params1.put("sheetIx",sheetIx1);
        params1.put("type", HandleProcessEnum.TB_FIELDS.getCode());
        params2.put("filePath",filePath2);
        params2.put("sheetIx",sheetIx2);
        params2.put("type", HandleProcessEnum.TB_FIELDS.getCode());
        Object obj = new Object();
        Map<String, Object> file1 = new DefaultExcelUtils().execute(obj,params1);
        Map<String, Object> file2 = new DefaultExcelUtils().execute(obj,params2);
        if (file1.size()!=file2.size()) {
            System.out.println("两版本表数量不一致");
            return res;
        }
        for (Map.Entry<String, Object> entry1 : file1.entrySet()) {
            for (Map.Entry<String, Object> entry2 : file2.entrySet()) {
                if (entry1.getKey().equalsIgnoreCase(entry2.getKey())){
                    TbFieldsPojo pojo1 = (TbFieldsPojo)entry1.getValue();
                    TbFieldsPojo pojo2 = (TbFieldsPojo)entry2.getValue();
                    if (pojo1.getFields().size()!=pojo2.getFields().size()){
                        System.out.println("两个版本表"+entry1.getKey()+"字段数量不一致");
                    }
                    // 比较两个对象中的数值
                    res.put(entry1.getKey(),compareItem(pojo1.getFields(),pojo2.getFields()));
                }
            }
        }
        return res;

    }

    private List<String> compareItem(List<TbFieldPojo> item1,List<TbFieldPojo> item2){
        List<String> res = new ArrayList<>();
        boolean flag1;
        for (TbFieldPojo pojo1 : item1) {
            flag1 = false;
            for (TbFieldPojo pojo2 : item2) {
                if (pojo1.getFname().equalsIgnoreCase(pojo2.getFname())){
                    flag1 = true;
                    if (!pojo1.getType().equalsIgnoreCase(pojo2.getType()) || pojo1.isPkFlag() != pojo2.isPkFlag()){
                        flag1 = false;
                    }
                }
            }
            if (!flag1) res.add(pojo1.getFname());
        }
        for (TbFieldPojo pojo2 : item2) {
            flag1 = false;
            for (TbFieldPojo pojo1 : item1) {
                if (pojo2.getFname().equalsIgnoreCase(pojo1.getFname())){
                    flag1 = true;
                    if (!pojo2.getType().equalsIgnoreCase(pojo1.getType()) || pojo1.isPkFlag() != pojo2.isPkFlag() ){
                        flag1 = false;
                    }
                }
            }
            if (!flag1 && !res.contains(pojo2.getFname())) {
                res.add(pojo2.getFname());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new East5CompareTools().compare("D:\\work\\报送口径文档\\报送口径文档\\east5\\信托业监管数据标准化规范(2024)\\规范附件1：金融监管总局信托业监管数据标准化规范一览表.xlsx", "D:\\work\\报送口径文档\\报送口径文档\\east5\\2024.8监管数据规范化\\2024.8监管数据规范化\\附件1：金融监管总局信托业监管数据标准化规范（2024版）一览表.xlsx", 4, 4);
        TreeMap<String,List<String>> sortMap = new TreeMap();
        sortMap.putAll(map);
        Iterator<String> iterator = sortMap.keySet().iterator();
        while (iterator.hasNext()) {
           String key = iterator.next();
            System.out.println(key);
            for (String s : sortMap.get(key)) {
                System.out.println(s);
            }
            System.out.println("**************************");
        }
    }


}
