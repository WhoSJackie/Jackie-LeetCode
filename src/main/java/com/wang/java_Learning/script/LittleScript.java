package com.wang.java_Learning.script;

import com.wang.java_Learning.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class LittleScript {

    /**
     * 获取pid
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        Process pidProcess = null;
        if (osName.contains("windows")){
            pidProcess = Runtime.getRuntime().exec("wmic process where name='java.exe' get processid");
        }else{
            pidProcess = Runtime.getRuntime().exec("ps -o pid= -p $$");
        }
        BufferedReader reader = null;
        if (pidProcess != null){
            reader = new BufferedReader(new InputStreamReader(pidProcess.getInputStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine())!=null){
            if (StringUtils.isEmpty(line.trim())) continue;
            sb.append(line).append("\n");
        }
        System.out.println(sb);
        reader.close();
    }

}
