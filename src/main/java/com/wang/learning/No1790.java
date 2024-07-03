package com.wang.learning;

public class No1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }

        if (s1.length()!=s2.length()){
            return false;
        }

        int count=0;
        int[] arr = new int[4];
        int index=0;
        for(int i=0;i<s1.length();i++){
            if (s1.charAt(i)!=s2.charAt(i)){
                if (count==2){
                    return false;
                }
                count++;
                arr[index++] = s1.charAt(i);
                arr[index++] = s2.charAt(i);
            }
        }
        if (count==0){
            return true;
        }
        if (count==2&&(arr[0]==arr[2]&&arr[1]==arr[3])){
            return true;
        }


        return false;
    }
}
