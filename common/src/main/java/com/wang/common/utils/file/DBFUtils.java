package com.wang.common.utils.file;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.wang.common.utils.FieldUtils;
import com.wang.common.pojo.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class DBFUtils<T> extends FileUtils<T> {

    private List<T> res = new ArrayList<>();

    public Map<String,Object> execute(T t, Map<String, Object> params) {
        Class clazz = t.getClass();
        String filePath = params.get("filePath").toString();
        Map<String,Object> temp = new HashMap<>();
        DBFReader reader = null;
        try (InputStream stream = new FileInputStream(filePath)){
            reader = new DBFReader(stream);
            reader.setCharactersetName("GBK");
            int count = reader.getFieldCount();
            Object[] value = null;
            int cnt=0;
            while ((value = reader.nextRecord())!=null){
                T pojo = (T)clazz.newInstance();
                for (int i = 0; i < count; i++) {
                    DBFField field = reader.getField(i);
                    FieldUtils.setFieldValueByName(pojo, field.getName().toLowerCase(Locale.ROOT),String.valueOf(value[i]).trim());
                }
                // 设置id
                FieldUtils.setFieldValueByName(pojo, "id",String.valueOf(cnt++));
                res.add(pojo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }

    public void postHandle(T t,Map<String,Object> params) {
        Class clazz = t.getClass();
        String fileOutPath = params.get("fileOutPath").toString();
        // 写入csv
        File file = new File(fileOutPath);
        BufferedWriter writer = null;
        OutputStreamWriter outputStreamWriter = null;
        OutputStream stream = null;
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
            stream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(stream);
            writer = new BufferedWriter(outputStreamWriter);
            // 写字段名
            StringBuilder sb  =new StringBuilder();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                sb.append(field.getName().toString().trim()).append(",");
            }
            writer.write(sb.substring(0,sb.length()-1));
            writer.newLine();
            for (T item: res) {
                sb  =new StringBuilder();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    sb.append(field.get(item)==null?"":field.get(item).toString().trim()).append(",");
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
                outputStreamWriter.close();
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public Object getRes(){
        return this.res;
    }

    @Override
    public void setBusiParam() {
        this.params.put("filePath","C:\\Users\\jiami\\Desktop\\dbf转csv\\bc90410.dbf");
        this.params.put("fileOutPath","C:\\Users\\jiami\\Desktop\\dbf转csv\\bc90410.csv");
    }

    public static void main(String[] args) {
        FileUtils<Shbc9Pojo> utils = new DBFUtils<>();
        System.out.println("开始设置参数");
        utils.setBusiParam();
        System.out.println("开始处理dbf...");
        Shbc9Pojo pojo = new Shbc9Pojo();
        utils.execute(pojo,utils.params);
        for (Object re : (List)(utils.getRes())) {
            System.out.println(re);
        }
        System.out.println("开始导出csv...");
        utils.postHandle(pojo,utils.params);
    }

}
