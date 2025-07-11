package com.wang.java_Learning.designPattern.singleton;

/**
 * 懒汉式
 */
public class CompactCD {

    // 防止指令重排序;内存可见性
    private static volatile CompactCD instance;

    private CompactCD(){}

    public static CompactCD getInstance(){
        // 第一层判断在于如果已经创建了，就没必要再创建浪费资源。
        if (instance==null){
            // 应该锁当前类，保证对于操作这个类的每个线程，都需要抢锁
            synchronized(CompactCD.class){
                // 第二次判断在于该线程在等锁的时候，已经进行了第一次判断;
                // 当其他线程创建了对象，该线程获取到了锁，需要再判断一次。
                if(instance==null){
                    instance=new CompactCD();
                }
            }
        }
        return instance;
    }

}
