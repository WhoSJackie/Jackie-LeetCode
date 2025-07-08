package com.wang.Leetcode;

import java.util.*;

public class LRUCache extends LinkedHashMap<Integer,Integer>{

    int cap = 0;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        cap = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size()>cap;
    }
}
