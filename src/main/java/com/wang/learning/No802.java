package com.wang.learning;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int total=graph.length;
        List<Integer> res=new ArrayList<>();
        int[] color=new int[total];
        for (int i = 0; i < total; i++) {
            if(isSafe(graph,color,i)){
                res.add(i);
            }
        }
        return res;
    }

    public boolean isSafe(int[][] graph,int[] color,int i){
        if(color[i]>0){
            return color[i]==2;
        }
        color[i]=1;
        for (int i1 : graph[i]) {
            if(!isSafe(graph,color,i1)){
                return false;
            }
        }
        color[i]=2;
        return true;
    }

}
