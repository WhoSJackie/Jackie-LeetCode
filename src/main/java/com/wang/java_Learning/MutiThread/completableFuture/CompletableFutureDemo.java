package com.wang.java_Learning.MutiThread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static int a = 0;
    public static int b = 0;
    public static String res ="";
    public void demo() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> completableFuturea = CompletableFuture.runAsync(()->{
            a = 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> completableFutureb = CompletableFuture.runAsync(()->{
            b = 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // allof 并行执行多个任务
        CompletableFuture<Void> completed = CompletableFuture.allOf(completableFuturea, completableFutureb);
        completed.thenRunAsync(()->{
            a = a+b;
        });
        Thread.sleep(3000);
        System.out.println(a);

        // thenCombine编排任务
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            return "World";
        });
        CompletableFuture<String> objectCompletableFuture = hello.thenCombine(world, (a, b) -> {
            return a+b;
        }).whenComplete((result,ex)->{
            res = result;
        });
        System.out.println("res->"+res);
        System.out.println(objectCompletableFuture.get());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new CompletableFutureDemo().demo();
    }

}
