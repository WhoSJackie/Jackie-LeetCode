package com.wang.javaL.IO;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DBFUtils extends FileUtils {


    @Override
    List<String> execute(String filePath, int... a) {
        List<String> res = new ArrayList<>();
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
