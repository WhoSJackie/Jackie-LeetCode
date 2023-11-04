package com.wang.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class No2103 {

    // 法1 set数组
//    public int countPoints(String rings) {
//        // 1.设置数组
//        Set[] set = new HashSet[10];
//        // 2.统计RGB
//        for (int i = 0; i < rings.length(); i++) {
//            // 偶数统计RGB
//            if ((i+1)%2!=0){
//                if (set[rings.charAt(i+1)-'0']==null){
//                    set[rings.charAt(i+1)-'0'] = new HashSet<Character>();
//                }
//                set[rings.charAt(i+1)-'0'].add(rings.charAt(i));
//            }
//        }
//        int cnt=0;
//        // 3.计数
//        for (Set set1 : set) {
//            if (set1!=null&&set1.size()>=3){
//                cnt++;
//            }
//        }
//        return cnt;
//    }

    // 法二 二维数组
    public int countPoints(String rings) {
        int[][] mat = new int[10][3];
        char[] chs = rings.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            // 偶数统计RGB
            if ((i+1)%2!=0){
                mat[chs[i+1]-'0'][transColorCode(chs[i])] = 1;
            }
        }

        // 统计
        boolean flag = true;
        int cnt=0;
        for (int i = 0; i < mat.length; i++) {
            flag = true;
            a:{
                for (int j = 0;  j< mat[0].length; j++) {
                    if (mat[i][j]!=1){
                        flag=false;
                        break a;
                    }
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }


    public int transColorCode(char ch){
        if (ch=='R') return 0;
        else if (ch=='G') return 1;
        else return 2;
    }

    public static void main(String[] args) {
        System.out.println(new No2103().countPoints("G3R3R7B7R5B1G8G4B3G6"));
    }

}
