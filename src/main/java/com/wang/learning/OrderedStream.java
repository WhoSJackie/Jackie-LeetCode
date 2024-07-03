package com.wang.learning;

import java.util.*;

public class OrderedStream {

    int ptr;
    String[] strs;

    public OrderedStream(int n) {
        strs = new String[n];
        ptr=1;
    }

    public List<String> insert(int idKey, String value) {
        strs[idKey-1] = value;
        if (ptr!=idKey){
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        while(ptr<=strs.length&&strs[ptr-1]!=null){
            res.add(strs[ptr-1]);
            ptr++;
        }
        return res;
    }
}
