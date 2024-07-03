package com.wang.learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No575 {
    public int distributeCandies(int[] candyType) {
        int len=candyType.length;
        int len1=len/2;
        int index=0;
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        while((set.size()<len1)&&(index<len)){
            set.add(candyType[index]);
            index++;
        }
        return set.size();

    }

}
