package com.wang.learning;

import java.util.Arrays;

public class No748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 二维数组 第一维代表words里面每个字符串，第二维为对应字符串的属性 第一列为是否满足条件(-1为不满足条件)，第二维是长度
        int[][] res=new int[words.length][2];
        //字符数组
        int[] ch=new int[26];

        // 统计补全词
        for (int i = 0; i < licensePlate.length(); i++) {
            char temp=licensePlate.charAt(i);
            if (temp>='a'&&temp<='z'||(temp>='A'&&temp<='Z')){
                char lowerTemp=Character.toLowerCase(temp);
                ch[lowerTemp-'a']++;
            }
        }

        // 进行words单词匹配
        for (int x=0;x<words.length;x++) {
            //拷贝一份统计数组，每次循环之后需要还原
            int[] ch_temp=Arrays.copyOf(ch,ch.length);
            for (int i = 0; i < words[x].length(); i++) {
                char sh=words[x].charAt(i);
                if (sh>='a'&&sh<='z'){
                    ch_temp[sh-'a']--;
                }
            }

            for (int i = 0; i < ch_temp.length; i++) {
                if(ch_temp[i]>0){
                    res[x][0]=-1;
                    break;
                }
            }
            res[x][1]=words[x].length();
        }

        int minLength=Integer.MAX_VALUE;
        int index=-1;
        for (int i = 0; i < res.length; i++) {
            if(res[i][0]==0){
                if(res[i][1]<minLength){
                    index=i;
                    minLength=res[i][1];
                }
            }
        }

        return index!=-1?words[index]:null;

    }



    public static void main(String[] args) {
        char s='A';
        // 使用Character的方法
        System.out.println(Character.toLowerCase(s));

        // 使用+32的方法
        System.out.println((char)(s+32));


//        int[] n=new int[5];
//        n[0]=1;
//        n[1]=1;
//        n[2]=1;
//        int[] n_copy=null;
//        for (int i = 0; i < 4; i++) {
//            n_copy= Arrays.copyOf(n,n.length);
//            n_copy[i]--;
//        }
//
//        for (int i : n_copy) {
//            System.out.println(i);
//        }

        String cr="abc";

        String crCopy=new String(cr);
        crCopy+="a";
        System.out.println(crCopy);
        System.out.println(cr);


    }
}
