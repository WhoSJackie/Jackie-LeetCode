package com.wang.Leetcode.MerchantsBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> self = new ArrayList<>();
        self.add(0);
        self.add(1);
        self.add(8);
        List<Integer> other = new ArrayList<>();
        other.add(2);
        other.add(5);
        other.add(6);
        other.add(9);
        int cnt = 0;

        for (int i=0;i<=N;i++){
            int x = i;
            boolean flagS = false;
            boolean flagO = false;
            boolean invalid = false;
            // 拆分每一位
            while (x!=0){
                int ramainder = x%10;
                if (other.contains(ramainder)) flagO = true;
                if (!self.contains(ramainder)&&!other.contains(ramainder)) {
                    invalid = true;
                    break;
                }
                x = x/10;
            }
            if (!invalid&&flagO) cnt++;
        }

        System.out.println(cnt);

    }

}
