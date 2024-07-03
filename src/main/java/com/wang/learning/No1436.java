package com.wang.learning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class No1436 {
    //法一
    public String destCity(List<List<String>> paths) {
        String res="";
        HashMap<String,Integer> map0=new HashMap<>();
        for (List<String> path : paths) {
            if(map0.containsKey(path.get(0))){
                Integer num=map0.get(path.get(0))+1;
                map0.put(path.get(0),num);
            }
            else{
                map0.put(path.get(0),1);
            }

            if(map0.containsKey(path.get(1))){
                Integer num=map0.get(path.get(1))+1;
                map0.put(path.get(1),num);
            }
            else{
                map0.put(path.get(1),1);
            }
        }

        for (String s : map0.keySet()) {
            if(map0.get(s)==1){
                if (isDestination(paths,s)){
                    res=s;
                    break;
                }
            }
        }

        return res;
    }

    public boolean isDestination(List<List<String>> paths,String s){
        for (List<String> path : paths) {
            if(path.contains(s)){
                if(path.get(1).equals(s)){
                    return true;
                }
            }
        }

        return false;
    }

    //法二
    public String destCity1(List<List<String>> paths){
        String res="";
        HashSet<String> set=new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        for (List<String> list : paths) {
            if(!set.contains(list.get(1))){
                return list.get(1);
            }
        }

        return "";
    }
}
