package com.wang.java_Learning.IO;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class IOPractice {

    public void fileInputTest(String pathname) throws IOException {
        File file=new File(pathname);
        System.out.println(file.exists());
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        long l1 = System.currentTimeMillis();
//        byte[] temp=new byte[1024];
        StringBuffer sb1=new StringBuffer();
        int a=0;
        while(((a=inputStreamReader.read())!=-1)){
            sb1.append((char)a);
            a=fileInputStream.read();
        }
        System.out.println(sb1.toString());
        long l2=System.currentTimeMillis();
        System.out.println("1024byte数组花费的时间："+(l2-l1));
        fileInputStream.close();

        FileInputStream fileInputStream1=new FileInputStream(file);
        InputStreamReader reader1 = new InputStreamReader(fileInputStream1);
        BufferedReader reader = new BufferedReader(reader1);

//        byte[] temp2=new byte[2048];
        StringBuffer sb2=new StringBuffer();
        long l3 = System.currentTimeMillis();
        String str;
        while ((str = reader.readLine())!=null){
            sb2.append(str).append("\n");
        }
        System.out.println(sb2.toString());
        long l4=System.currentTimeMillis();
        System.out.println("2048byte数组花费的时间："+(l4-l3));

        fileInputStream1.close();

    }


    public void  fileOutputTest(String pathname,String value,boolean existRecreate) throws IOException {
        File file1=new File(pathname);
        boolean flag=false;
        if(!file1.exists()){
            flag=file1.createNewFile();
        } else{
            if (existRecreate){
                System.out.println("文件已经存在,删除重建!");
                boolean deleteFlag = file1.delete();
                if (deleteFlag){
                   boolean createFlag = file1.createNewFile();
                   if (!createFlag){
                       System.out.println("重建失败");
                       return;
                   }
                } else{
                    System.out.println("删除失败，请手动创建或者重试!");
                    return;
                }
            } else{
                System.out.println("文件已经存在!");
                return;
            }
        }

        try (FileWriter fileWriter=new FileWriter(file1);BufferedWriter writer = new BufferedWriter(fileWriter)){
            writer.write(value);
            writer.flush();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("写入完成!");
    }



    public void testSocket(){
        InetAddress address= null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(address);
    }

    public void countLongText(String url){
        if (url==null||url.length()==0){
            return ;
        }
        File file = new File(url);
        if (!file.exists()){
            return ;
        }
        FileInputStream fileInputStream=null;
        InputStreamReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
             fileInputStream = new FileInputStream(file);
            reader = new InputStreamReader(fileInputStream,StandardCharsets.UTF_8);
            int a = 0;
            while ((a=reader.read())!=-1){
                sb.append((char)a);
//                a= reader.read();
            }
            String temp = sb.toString();
            String[] str = temp.split(",");
            // 统计字符串中;的个数
            int oldlen = temp.length();
            String newStr = temp.replace(";","");
            int newlen = oldlen-newStr.length();
            System.out.println(";的个数"+newlen);
            System.out.println("job总数"+(str.length+newlen));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // new IOPractice().fileInputTest("C:\\Users\\jiami\\Desktop\\场外债券使用的表.txt");
    }

}
