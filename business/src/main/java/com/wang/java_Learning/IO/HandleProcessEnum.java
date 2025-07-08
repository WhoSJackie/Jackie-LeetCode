package com.wang.java_Learning.IO;

import com.wang.java_Learning.IO.processor.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HandleProcessEnum {

    CREATE_TB(0,new CreateRpTableProcessor()),
    TB_FIELDS(1,new GetTableFieldsProcessor()),
    BUILD_RISK(2,new BuildRiskFieldsProcessor()),
    TIMETABLE(3,new TimeTableProcessor());

    private int code;
    private HandleProcessor processor;

    public static HandleProcessEnum getByCode(int code){
        for (HandleProcessEnum value : HandleProcessEnum.values()) {
            if (value.code==code) return value;
        }
        return null;
    }

    public  HandleProcessor getProcessor(){
        return processor;
    }

    public int getCode(){
        return code;
    }


}
