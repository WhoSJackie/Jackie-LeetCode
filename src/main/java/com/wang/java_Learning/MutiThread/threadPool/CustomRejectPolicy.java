package com.wang.java_Learning.MutiThread.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 自定义拒绝策略
        BlockingQueue<Runnable> queue = executor.getQueue();
        queue.poll();
        executor.execute(r);
    }
}
