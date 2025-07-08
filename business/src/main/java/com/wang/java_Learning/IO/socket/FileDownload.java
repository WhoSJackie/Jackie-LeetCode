package com.wang.java_Learning.IO.socket;

import java.io.*;

public class FileDownload {

    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
        FileInputStream fileInputStream= null;
        File src=new File("D:\\Users\\junzhou.wang\\Desktop\\测试文件\\test.txt");
        try {
            fileInputStream = new FileInputStream(src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //读取文件内容方法
//        InputStreamReader reader=new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//        char[] b=new char[1024];
//        try{
//            int len=reader.read(b);
//            while(len!=-1){
//                String temp=new String(b,0,len);
//                sb.append(temp);
//                len=reader.read(b);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            try{
//                reader.close();
//                fileInputStream.close();
//            }catch(Exception e1){
//                e1.printStackTrace();
//            }
//        }
//        System.out.println(sb);

        //向指定文件中写入内容

        File file=new File("D:\\Users\\junzhou.wang\\Desktop\\测试文件\\testOut.txt");
        FileOutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(file,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] content=new byte[(int)src.length()];
        System.out.println("文件长度为："+src.length());
        int len=0;
        int index=0;
        String ap=String.valueOf(index);
        byte[] temp=ap.getBytes();
        while((len=fileInputStream.read(content))!=-1){
            System.out.println("读取文件...");
            outputStream.write(content);
            outputStream.write(temp);
            System.out.println("写入文件...");
        }
        outputStream.close();
        fileInputStream.close();

    }
}
