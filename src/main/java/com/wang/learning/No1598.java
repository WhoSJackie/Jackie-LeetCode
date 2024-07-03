package com.wang.learning;

import java.util.Deque;
import java.util.LinkedList;

public class No1598 {

    public int minOperations(String[] logs) {
        Deque<String> queue = new LinkedList<>();
        queue.push("main");
        // ./ ../ x/
        for (String log : logs) {
            switch (log) {
                case "../":
                    if (!queue.isEmpty()) {
                        if (!"main".equals(queue.peek())) {
                            queue.pop();
                        }
                    }
                    break;
                case "./":
                    break;
                default:
                    queue.push(log);
            }
        }

        return queue.size() - 1;
    }
}
