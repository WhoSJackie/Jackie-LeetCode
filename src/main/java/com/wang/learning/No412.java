package com.wang.learning;

import java.util.ArrayList;
import java.util.List;

public class No412 {
    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i%3==0&&i%5==0){
                res.add("FizzBuzz");
            }
            else if(i%5!=0&&i%3!=0){
                res.add(String.valueOf(i));
            }

            else if(i%3!=0){
                res.add("Buzz");
            }
            else{
               res.add("Fizz");
            }
        }
        return res;
    }
}
