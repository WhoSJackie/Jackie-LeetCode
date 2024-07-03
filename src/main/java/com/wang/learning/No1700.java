package com.wang.learning;

import java.util.LinkedList;
import java.util.Queue;

public class No1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        // 栈顶
        int index=0;
        // 计数器
        int count=0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
        }

        while(queue.size()!=0&&count<queue.size()){
            // 如果队列队首的和第一个三明治口味一样，出队
            if (queue.peek() ==sandwiches[index]){
                queue.poll();
                index++;
                count=0;
            }else{
                queue.offer(queue.poll());
                count++;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[] stu = {1,1,0,0};
        int[] sw = {0,1,0,1};
        System.out.println(new No1700().countStudents(stu, sw));
    }
}
