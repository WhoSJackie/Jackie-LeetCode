package com.wang.java_Learning.cmd;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CmdUtil {

    public void runCmd(String command){
        Process process=null;
        try{
            process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("GBK"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String buffer = "";
            while ((buffer = reader.readLine())!=null){
                System.out.println(buffer);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new CmdUtil().runCmd("C:\\Users\\jiami\\Desktop\\demo1.bat");
    }


}
