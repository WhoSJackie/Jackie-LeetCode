package com.wang.Leetcode;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class No049 {


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> indexMap = new HashMap<>();
        StringBuilder ix = null;
        List<Integer> ixNum = null;
        for (String s : strs) {
            ix=new StringBuilder();
            ixNum = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int tmp = s.charAt(i)-'a';
                ixNum.add(tmp);
            }
            Collections.sort(ixNum);
            for (Integer integer : ixNum) {
                ix.append(integer).append("-");
            }
            if (indexMap.containsKey(ix.toString())){
                indexMap.get(ix.toString()).add(s);
            } else{
                indexMap.put(ix.toString(),new ArrayList<String>(){{add(s);}});
            }
        }
        for (Map.Entry<String, List<String>> entry : indexMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            // s 相同的字符串分到同一组
            m.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(m.values());
    }

    public static void main(String[] args) {
       String[] r = new String[]{};
       List<List<String>> list = new No049().groupAnagrams(r);
        for (List<String> stringList : list) {
            if (stringList.size()>1){
                for (String s : stringList) {
                    System.out.println(s);
                }
                System.out.println("-------------------");
            }
        }
    }

}
