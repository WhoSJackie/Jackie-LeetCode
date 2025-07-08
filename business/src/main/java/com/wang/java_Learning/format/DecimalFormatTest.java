package com.wang.java_Learning.format;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatTest {

    public static void DF01(){
        DecimalFormat df = new DecimalFormat("#.0000");
        try {
            String format = df.format(df.parse("12.35698"));
            System.out.println(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DF01();
    }


}
