package com.wang.java_Learning.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    // reuse the object mapper to save memory footprint
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final ObjectMapper indentMapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        indentMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public static <T> T readValue(File src, Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public static <T> T readValue(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }

    public static <T> T readValue(Reader src, Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public static <T> T readValue(InputStream src, Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public static <T> T readValue(byte[] src, Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public static Map<String, String> readValueAsMap(String content) throws IOException {
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };
        return mapper.readValue(content, typeRef);
    }

    public static Map<String, Object> readValueAsMapObject(String content) throws IOException {
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
        };
        return mapper.readValue(content, typeRef);
    }

    public static <T> List<T> readValueAsList(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, TypeFactory.defaultInstance().constructCollectionType(List.class, valueType));
    }

    public static <T> T[] readValueAsArray(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, TypeFactory.defaultInstance().constructArrayType(valueType));
    }

    public static void writeValueIndent(OutputStream out, Object value) throws IOException {
        indentMapper.writeValue(out, value);
    }

    public static void writeValue(OutputStream out, Object value) throws IOException {
        mapper.writeValue(out, value);
    }

    public static String writeValueAsString(Object value) throws JsonProcessingException {
        return mapper.writeValueAsString(value);
    }

    public static byte[] writeValueAsBytes(Object value) throws JsonProcessingException {
        return mapper.writeValueAsBytes(value);
    }

    public static String writeValueAsIndentString(Object value) throws JsonProcessingException {
        return indentMapper.writeValueAsString(value);
    }

    public static <T> T readValuesFromTypeReference(String str, TypeReference<T> typeClass) throws IOException {
        return mapper.readValue(str, typeClass);

    }

    public static String toJsonString(Object value) {
        try {
            return writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("toJsonString failed, object: " + value, e);
        }
    }

    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("parseJson failed, json: " + json + ", class: " + clazz.getName(), e);
        }
    }

    public static <T> List<T> parseJsonList(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(List.class, clazz));
        } catch (IOException e) {
            throw new IllegalArgumentException("parseJsonList failed, json: " + json + ", class: " + clazz.getName(), e);
        }
    }

    public static Map<String, String> parseJsonAsMap(String json) {
        try {
            return readValueAsMap(json);
        } catch (IOException e) {
            throw new IllegalArgumentException("parseJsonMap failed, json: " + json + ", class: " + Map.class, e);
        }
    }

    public static Map<String, Object> parseJsonObjectAsMap(String json) {
        try {
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            return mapper.readValue(json, typeRef);
        } catch (IOException e) {
            throw new IllegalArgumentException("parseJsonObjectAsMap failed, json: " + json + ", class: " + Map.class, e);
        }
    }

    public static <T> Map<String, T> parseJsonObjectAsMapByClass(String json) {
        try {
            TypeReference<HashMap<String, T>> typeRef = new TypeReference<HashMap<String, T>>() {
            };
            return mapper.readValue(json, typeRef);
        } catch (IOException e) {
            throw new IllegalArgumentException("parseJsonObjectAsMap failed, json: " + json + ", class: " + Map.class, e);
        }
    }


    public static JsonNode toJsonNode(String json) {
        try {
            return mapper.readTree(json);
        } catch (IOException e) {
            throw new RuntimeException("toJsonNode failed, json: " + json, e);
        }
    }

    public static JsonNode toJsonNode(Object object) {
        try {
            return mapper.readTree(toJsonString(object));
        } catch (IOException e) {
            throw new RuntimeException("toJsonNode failed, object: " + object, e);
        }
    }


    public static <T> String obj2StringEliminateNull(T obj){
        if (obj == null){
            return null;
        }
        if (obj instanceof String){
            return (String)obj;
        }
        try{
            String jsonString = JsonUtil.toJsonString(obj);
            Map<String,String> jsonMap = JsonUtil.readValueAsMap(jsonString);
            for (String key:jsonMap.keySet()){
                if (jsonMap.get(key) == null){
                    jsonMap.remove(key);
                }
            }
            return JsonUtil.toJsonString(jsonMap);
        }catch (Exception e){
            throw new RuntimeException("toJsonNode failed, object: " + obj, e);
        }
    }
}
