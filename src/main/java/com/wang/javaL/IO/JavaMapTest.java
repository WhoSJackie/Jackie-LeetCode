package com.wang.javaL.IO;


import com.linuxense.javadbf.DBFReader;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JavaMapTest {

    private static DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入dbf文件路径:");
        String filePath = scanner.nextLine();
    }

    public static void readTxt(){
        File file =null;
        FileReader reader = null;
        try{
            String filePath = "Y://D_pan/datatest/山西信托_金证交易/YYYYMMDD/ZQXX_YYYYMMDD.DBF";
            filePath = "D://YYYYMMDD.txt";
            String str = formatter.format(LocalDate.now());
            System.out.println(str);
            filePath = filePath.replace("YYYYMMDD",str);
            System.out.println(filePath);
            file = new File(filePath);
            // File parent = file.getParentFile();

            // 文件不存在但是父目录存在时，获取父目录下的文件
//            if(!file.exists() && parent.exists()){
//                File[] fileArray = parent.listFiles();
//                for (File file1 : fileArray) {
//                    System.out.println(file1.getName());
//                }
//            }
            boolean succ = false;
            if (file.exists()){
                System.out.println("Exist!");
            } else{
                succ = file.mkdir();
            }
            if (!succ) throw new RuntimeException("无法读取或者创建文件!");
            reader = new FileReader(file);
            char[] buffer = new char[1024];
            while (reader.read(buffer)!=-1){
                System.out.println(new String(buffer));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
