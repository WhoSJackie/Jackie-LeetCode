package com.wang.javaL.IO;

import com.wang.javaL.util.StringUtils;

import java.io.*;
import java.util.*;

public class InputHandle {

    // 生成需要的校验表达语句
    public static String handleText(String target,String fieldName,Map<String,String> refMap){
        StringBuilder sb = new StringBuilder();
        // 前置条件
        sb.append("【期初日期:%QCRQ%,期末日期:%QMRQ%,公司代码:%GSDM%,风险准备金类型:%FXZBJLX%】");

        // 置换target
        String[] strs = target.split("=");
        if (strs.length!=2){
            throw new RuntimeException("target格式有误!");
        }
        // 分隔加减号各子项
        char[] elStrs = strs[1].toCharArray();
        List<String> elements = new ArrayList<>();
        // 指针
        int index=0;
        StringBuilder sb1 = new StringBuilder();
        while (index<elStrs.length){
            // 需要处理第一个数字
            if (index==0 || elStrs[index]=='-' || elStrs[index]=='+'){
                // 找到+-号开始匹配
                sb1.setLength(0);
                sb1.append(elStrs[index++]);
                while ((index<elStrs.length) && (elStrs[index]!='-' && elStrs[index]!='+')){
                    sb1.append(elStrs[index++]);
                }
            }
            elements.add(sb1.toString().trim());
        }

        // 拼接成需要的文本
        // 拼接总项
        sb.append(handleElement(refMap,strs[0],fieldName)).append(" 不等于 ");
        for (String element : elements) {
            if (element.charAt(0)=='+'){
                sb.append(" + ").append(handleElement(refMap,element.substring(1),fieldName));
            } else if(element.charAt(0)=='-'){
                sb.append(" - ").append(handleElement(refMap,element.substring(1),fieldName));
            } else{
                sb.append(handleElement(refMap,element,fieldName));
            }
        }
        return sb.toString().trim();
    }

    // 读取txt文件，得到list
    public static List<String> handleTxtFile(String filePath)  {
        FileInputStream fis = null;
        InputStreamReader is = null;
        BufferedReader reader = null;
        List<String> sb = new ArrayList<>();
        try {
             fis = new FileInputStream(filePath);
             is = new InputStreamReader(fis);
             reader = new BufferedReader(is);
             String str;
             while ((str = reader.readLine())!=null){
                sb.add(str);
             }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                is.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb;
    }

    // 对每一个元素进行包装
    private static String handleElement(Map<String,String> refMap, String el,String fieldName){
        StringBuilder sb = new StringBuilder();
        if (refMap.containsKey(el)){
            sb.append("{").append(fieldName).append("}").append("(").append(el+"-"+refMap.get(el)).append(")");
        }
        return sb.toString();
    }

    // 将字典list转换成Map
    public static Map<String,String> transListToMap(List<String> strList,String seperator){
        Map<String,String> map = new HashMap<>();
        for (String s : strList) {
            if (StringUtils.isEmpty(s.trim())) continue;
            String[] split = s.trim().split(seperator);
            if (split.length!=2) continue;
            map.put(split[0],split[1]);
        }
        return map;
    }


    public static void main(String[] args) {
        List<String> textList = handleTxtFile("C:\\Users\\jiami\\Desktop\\dict.txt");
        Map<String, String> refMap = transListToMap(textList, "-");
        String inputMsg = "";
        System.out.println("请输入校验表达式:");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()){
            inputMsg = sc.nextLine();
        }
        System.out.println(handleText(inputMsg, "本期金额", refMap));
    }



}
