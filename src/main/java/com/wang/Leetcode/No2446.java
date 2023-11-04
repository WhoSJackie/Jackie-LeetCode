package com.wang.Leetcode;

public class No2446 {

    public boolean haveConflict(String[] event1, String[] event2) {
        String st1 = event1[0];
        String se1 = event1[1];
        String st2 = event2[0];
        String se2 = event2[1];
        if (compTime(event1[1],event2[1])>0){
            st1 = event2[0];
            se1 = event2[1];
            st2 = event1[0];
            se2 = event1[1];
        }
        if (compTime(st2,st1)>=0&&compTime(st2,se1)<=0){
            return true;
        } else if (compTime(st2,st1)<0){
            return true;
        } else{
            return false;
        }
    }

    public Integer getHour(String s){
        return Integer.parseInt(s.substring(0,2));
    }

    public Integer getMinute(String s){
        return Integer.parseInt(s.substring(3,5));
    }

    // 比较两个时间的大小
    public int compTime(String s1,String s2){
        if (getHour(s1)<getHour(s2)){
            return -1;
        } else if (getHour(s1)>getHour(s2)){
            return 1;
        } else{
            return getMinute(s1).compareTo(getMinute(s2));
        }
    }

}
