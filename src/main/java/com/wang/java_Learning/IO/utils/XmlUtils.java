package com.wang.java_Learning.IO.utils;

import cn.hutool.core.bean.BeanUtil;
import com.wang.java_Learning.IO.pojo.EtfPcfPojo;
import com.wang.java_Learning.utils.FieldUtils;
import com.wang.java_Learning.utils.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class XmlUtils<T> extends FileUtils<T>{

    private final static String[] commTagNames = {"FundInstrumentID","CreationRedemptionUnit","TradingDay","PreTradingDay",
            "NAVperCU","NAV","PreCashComponent","EstimatedCashComponent","MaxCashRatio","PublishIOPVFlag","CreationRedemptionSwitch","RecordNumber"};

    private  Map<String,Object> res  =new HashMap<>();

    private final static String[] childTagNames ={"",""};
    @Override
    Map<String, Object> execute(T t,Map<String,Object> params) {
        String filePath = params.get("filePath").toString();
        int id = 0;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document parse = builder.parse(filePath);
            int size = commTagNames.length;

            Class clazz = t.getClass();
            Object pojo = clazz.newInstance();
            String item = "";
            for (int i = 0; i < size; i++) {
                item = parse.getElementsByTagName(commTagNames[i]).item(0).getTextContent();
                if (!StringUtils.isEmpty(item)){
                    // 利用反射设置字段值
                    FieldUtils.setFieldValueByName(pojo,commTagNames[i],item);
                }
            }

            // 处理数组参数
            NodeList component = parse.getElementsByTagName("Component");
            for (int i = 0; i < component.getLength(); i++) {
                EtfPcfPojo customPojo = new EtfPcfPojo();
                BeanUtil.copyProperties(pojo,customPojo);
                Element node = (Element)component.item(i);
                // 处理子节点
                // 处理替换标志
                customPojo.setAllcashflag(node.getElementsByTagName("SubstitutionFlag").item(0).getTextContent());
                // 处理其他字段
                String discountRateRate = "";
                String creationPremiumRate = "";
                String substitutionCashAmount = "";
                NodeList list1 = node.getElementsByTagName("RedemptionDiscountRate");
                NodeList list2 = node.getElementsByTagName("CreationPremiumRate");
                NodeList list3 = node.getElementsByTagName("SubstitutionCashAmount");
                if (list1.getLength()>0){
                    discountRateRate = list1.item(0).getTextContent();
                }
                if (list2.getLength()>0){
                    creationPremiumRate = list2.item(0).getTextContent();
                }
                if (list3.getLength()>0){
                    substitutionCashAmount = list3.item(0).getTextContent();
                }
                if (!StringUtils.isEmpty(discountRateRate)){
                    customPojo.setAllcashdiscountrate(discountRateRate);
                }
                if (!StringUtils.isEmpty(creationPremiumRate)){
                    customPojo.setAllcashpremiumrate(creationPremiumRate);
                }
                if (!StringUtils.isEmpty(substitutionCashAmount)){
                    customPojo.setAllcashamount(substitutionCashAmount);
                }
                res.put(String.valueOf(id++),customPojo);
            }
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally{

        }
        return res;
    }

    @Override
    void postHandle(T t,Map<String,Object> params) {
        Class clazz = t.getClass();
        // 写入csv
        String fileOutPath = params.get("fileOutPath").toString();
        File file = new File(fileOutPath);
        BufferedWriter writer = null;
        FileWriter fWriter = null;
        try{
            if (!file.exists()){
                boolean newFile = file.createNewFile();
                if (!newFile){
                    throw new RuntimeException("创建文件失败!");
                }
            }
            else {
                boolean oldFile = file.delete();
                if (!oldFile){
                    throw new RuntimeException("删除文件失败");
                }
            }
            fWriter = new FileWriter(file);
            writer = new BufferedWriter(fWriter);
            // 写字段名
            StringBuilder sb  =new StringBuilder();
            sb.append("id,");
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                sb.append(field.getName()).append(",");
            }
            writer.write(sb.substring(0,sb.length()-1));
            writer.newLine();
            for (Map.Entry<String, Object> entry : res.entrySet()) {
                sb  =new StringBuilder();
                sb.append(entry.getKey()).append(",");
                EtfPcfPojo item = (EtfPcfPojo)entry.getValue();
                Class<? extends EtfPcfPojo> aClass = item.getClass();
                for (Field field : aClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    sb.append(field.get(item)==null?"":field.get(item)).append(",");
                }
                writer.write(sb.substring(0,sb.length()-1));
                writer.newLine();
            }
            System.out.println("导出csv文件成功!");
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                fWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    void setBusiParam(){
        params.put("filePath","C:\\Users\\jiami\\Desktop\\ssepcf_560800_20220704.xml");
        params.put("fileOutPath","C:\\Users\\jiami\\Desktop\\ssepcf.csv");
    }
    public static void main(String[] args) {
        EtfPcfPojo pojo = new EtfPcfPojo();
        FileUtils<EtfPcfPojo> utils = new XmlUtils<EtfPcfPojo>();
        utils.setBusiParam();
        utils.execute(pojo,utils.params);
        utils.postHandle(pojo,utils.params);
    }
}
