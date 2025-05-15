package com.wang.java_Learning.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorUtils {


    public static void main(String[] args) {
        List<TmpObject> objList = new ArrayList<>();
        objList.add(new TmpObject("a","1"));
        objList.add(new TmpObject("b","2"));
        objList.add(new TmpObject("a","3"));
        Map<String,List<TmpObject>> obj = objList.stream().collect(Collectors.groupingBy(TmpObject::getName));
        for (Map.Entry<String, List<TmpObject>> entry : obj.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


}

class TmpObject{


    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TmpObject(String name, String value){
        this.name = name;
        this.value = value;
    }
}
