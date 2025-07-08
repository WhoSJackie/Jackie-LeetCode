package com.wang.java_Learning.sql;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {

    public static Connection getGaussConn(String url,String user,String pwd) throws Exception {
        // Class.forName("com.huawei.opengauss.jdbc.Driver");
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, user, pwd);
        return connection;
    }

    public static <T> List<T> getObjList(T t, ResultSet rs) throws Exception {
        List<T> res = new ArrayList<>();
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (rs!=null){
            while (rs.next()){
                t = (T)clazz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true);
                    if (String.class.getName().equals(field.getType().getName())){
                        field.set(t,rs.getString(field.getName()));
                    } else if (Integer.class.getName().equals(field.getType().getName())){
                        field.set(t,rs.getInt(field.getName()));
                    }
                }
                res.add(t);
            }
        }
        return res;
    }

}
