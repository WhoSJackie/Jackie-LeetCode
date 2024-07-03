package com.wang.javaL.Genraic;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<People> a=new ArrayList<>();
        a.add(new People("jackie",1));

        List<Man> b=new ArrayList<>();
        b.add(new Man("maggie",20));

//        Test.processElments2(a);
        Test.processElmetns(a);
        Test.processElments1(b);


    }

    public static void processElmetns(List<?> a){
        for (Object o : a) {
            System.out.println(a);
        }

    }

    public static void processElments1(List<? extends People> a){
        for (People people : a) {
            System.out.println(people.getName());
        }
    }

    public static void processElments2(List<? super People> a){
        a.add(new People("jackie1",22));
    }


}
