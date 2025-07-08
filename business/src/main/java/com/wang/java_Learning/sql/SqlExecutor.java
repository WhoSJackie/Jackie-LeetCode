package com.wang.java_Learning.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SqlExecutor {

    public void executeSql(){

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            // Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://10.210.6.33:5432/dida","postgres","postgres");
            System.out.println(connection.getMetaData().getDatabaseProductName());
            ps = connection.prepareStatement("select count(1) from job_exec_log where task_id=?");
            ps.setString(1,"20240321170304734384");
            rs = ps.executeQuery();
            int num=0;
            while (rs.next()){
                num = rs.getInt(1);
                System.out.println(num);
            }
            ps=null;
            rs=null;
            ps = connection.prepareStatement("select * from job_exec_log");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("exec_status"));
            }
        } catch (Exception e){
            e.printStackTrace();
             throw new RuntimeException(e);
        } finally {
            try{
                rs.close();
                ps.close();
                connection.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SqlExecutor().executeSql();
//        Map<String,String> map = new HashMap<>();
//        map.put("key","1");
//        System.out.println(map.get("key"));
//        map.remove("key");
//        System.out.println(map.get("key"));

    }


}
