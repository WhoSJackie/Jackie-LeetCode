package com.wang.javaL.IO.utils;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DBFUtils extends FileUtils {


    @Override
    Map<String,Object> execute(String filePath, int... a) {
        Map<String,Object> res = new HashMap<>();
        DBFReader reader = null;
        try (InputStream stream = new FileInputStream(filePath)){
            reader = new DBFReader(stream);
            int count = reader.getFieldCount();
            for (int i = 0; i < count; i++) {
                DBFField field = reader.getField(i);
                System.out.println(field.getName());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        FileUtils utils = new DBFUtils();
        utils.execute("C:\\Users\\jiami\\Desktop\\JYDSXX_20240809.DBF");
    }
}
