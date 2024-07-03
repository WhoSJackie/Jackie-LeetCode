package com.wang.javaL.math;


import java.util.Random;

public class CircleCaculator {

    public double getPiValue(){
        long circleNum=0;
        long squareNum=0;
        long count=0;
        while (count<1000000){
            double randomx=Math.random();
            double randomy=Math.random();
            double circleArea=randomx*randomx+randomy*randomy;
            if (circleArea<=1.0){
                circleNum++;
            }else {
                squareNum++;
            }
            count++;
        }

        // 通过计算落在圆里的点和整体比值，计算pi
        return (circleNum*1.0/(circleNum+squareNum))*4;

    }

  public static void main(String[] args) {
    CircleCaculator circleCaculator=new CircleCaculator();
//    System.out.println(circleCaculator.getPiValue());

      Random rand=new Random();
    System.out.println(rand.nextInt(10));
  }
}
