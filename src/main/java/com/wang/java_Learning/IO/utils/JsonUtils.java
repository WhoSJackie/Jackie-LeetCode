package com.wang.java_Learning.IO.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils<T> extends FileUtils<T>{

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    Map<String, Object> execute(T t,Map<String,Object> params) {
        String srcFilePath = params.get("srcFilePath").toString();
        String tarFilePath = params.get("tarFilePath").toString();
        addJsonNode(srcFilePath,tarFilePath);
        return null;
    }
    private void addJsonNode(String srcFilePath,String tarFilePath){
        try{
            File file  = new File(srcFilePath);
            if (!file.exists()){
                throw new RuntimeException("文件不存在!");
            }
            JsonNode jsonNode = mapper.readTree(file);
            // 获取每个表
            ArrayNode childNode = jsonNode.withArray("entities");
            for (int i = 0; i < childNode.size(); i++) {
                // 获取每个表的字段数据
                ArrayNode fieldNode = childNode.get(i).withArray("fields");
                for (int j = 0; j < fieldNode.size(); j++) {
                    JsonNode writeNode = fieldNode.get(j);
                    if (writeNode.get("attr1") == null || !"1".equals(writeNode.get("attr1").toString())){
                        ((ObjectNode)writeNode).put("attr1","1");
                    }
                }
            }
            File newFile = new File(tarFilePath);
            if (newFile.exists()){
                boolean delete = newFile.delete();
                if (!delete){
                    throw new RuntimeException("删除文件失败,请尝试手动操作");
                }
            }
            boolean fileSucc = newFile.createNewFile();
            if (!fileSucc){
                throw new RuntimeException("创建文件失败,请尝试手动创建");
            }
            mapper.writeValue(newFile,jsonNode);
            System.out.println("文件写入成功!");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void setBusiParam(){
        params.put("srcFilePath","C:\\Users\\jiami\\Desktop\\MACBS.pdma.json");
        params.put("tarFilePath","C:\\Users\\jiami\\Desktop\\MACBS(增加内存字段版).pdma.json");
    }
    public static void main(String[] args) {
        FileUtils<Object> utils = new JsonUtils<>();
        utils.setBusiParam();
        utils.execute(new Object(),utils.params);
    }

}
