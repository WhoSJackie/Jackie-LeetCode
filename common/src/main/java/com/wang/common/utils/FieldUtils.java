package com.wang.common.utils;

import java.lang.reflect.Field;

public class FieldUtils {
    public static <T> void setFieldValueByName(T t, String fieldName,String fieldValue) throws Exception {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            if (fieldName.equalsIgnoreCase(field.getName())){
                field.set(t,fieldValue);
                break;
            }
        }
    }



}
