package com.wang.learning;

import java.util.*;

public class No735 {

    public int[] asteroidCollision1(int[] asteroids) {
        int len = asteroids.length;
        boolean flag = true;
        int x;
        int y;
        while(flag){
            x=0;
            y=1;
            flag=false;
            while(y<len&&x<y){
               while (x<len&&x<y&&asteroids[x]==0){
                   x++;
               }
                if (x==y){
                    y++;
                }
               while (y<len&&asteroids[y]==0){
                   y++;
               }
               if (y>=len||x>=y){
                   break;
               }
               // x,y位置的值异号
               if (asteroids[x]>0&&asteroids[y]<0){
                  // 两种值一样大
                  if (Math.abs(asteroids[x])==Math.abs(asteroids[y])){
                      asteroids[x]=0;
                      asteroids[y]=0;
                  } else if(Math.abs(asteroids[x])>Math.abs(asteroids[y])){
                      // x值大于y
                      asteroids[y]=0;
                  }else{
                      // y值大于x
                      asteroids[x]=0;
                  }
                  flag=true;
               }
                x++;
                y++;
            }
        }
        List<Integer> res = new ArrayList<>();
        // 统计不为零的个数
        for (int i:asteroids) {
            if (i!=0){
                res.add(i);
            }
        }
        int[] solution = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            solution[i] = res.get(i);
        }
        return solution;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue = new LinkedList<>();
        boolean isAlive;
        for (int asteroid : asteroids) {
            isAlive = true;
                while (!queue.isEmpty()&&queue.peek()>0&&asteroid<0){
                    if (queue.peek()<-asteroid){
                        queue.pop();
                    } else if(queue.peek()==-asteroid){
                        isAlive = false;
                        queue.pop();
                        break;
                    } else{
                        isAlive = false;
                        break;
                    }
                }
            if (isAlive){
                queue.push(asteroid);
            }

        }
        int[] res = new int[queue.size()];
        int i= queue.size()-1;
        while (!queue.isEmpty()) {
            res[i--] = queue.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new No735().asteroidCollision(new int[]{-2,1,1,-1});
        for (int re : res) {
            System.out.println(re);
        }
    }
}
