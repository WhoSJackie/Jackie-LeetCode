package com.wang.Leetcode;

import java.util.*;

public class No690 {


    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        int res=0;
        Map<Integer,Employee> map = new HashMap<>();
        //建立邻接矩阵
        for (Employee employee : employees) {
            map.put(employee.id,employee);
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(id);
        while (!queue.isEmpty()){
            int eid = queue.pollFirst();
            res+=map.get(eid).importance;
            // 向队列塞入下属Id
            for (Integer subordinate : map.get(eid).subordinates) {
                queue.offerLast(subordinate);
            }
        }
        return res;
    }




}
