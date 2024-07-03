package com.wang.learning;

import java.util.Arrays;

public class No881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len=people.length;
        int count=0;
        int temp=limit;
        int i=0;
        int j=len-1;
        while(i<=j){
            if(people[i]+people[j]>limit){
                j--;
            }
            else{
                i++;
                j--;

            }
            count++;
        }


        return count;
    }

    public static void main(String[] args) {
        int[] people={5,1,4,2};
        No881 n=new No881();
        System.out.println(n.numRescueBoats(people, 6));
    }
}
