package com.wang.java_Learning.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeRes {

    private int year;

    private int month;

    private int date;

    private int hour;

    private int minute;

    private int seconds;

}
