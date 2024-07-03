package com.wang.learning;

import java.util.ArrayList;
import java.util.List;

public class No345 {
    public String reverseVowels(String s) {
        if(s==null||s.length()<=0){
            return s;
        }
        int len=s.length();
        int i=0;
        int j=len-1;
        char[] array=s.toCharArray();
        List<Character> alpha=new ArrayList<>();
        alpha.add('a');
        alpha.add('e');
        alpha.add('i');
        alpha.add('o');
        alpha.add('u');
        alpha.add('A');
        alpha.add('E');
        alpha.add('I');
        alpha.add('O');
        alpha.add('U');
        while(i<j){
            while(!(alpha.contains(array[i]))){
                i++;
            }
            while(!(alpha.contains(array[j]))){
                j--;
            }
            char temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        No345 n=new No345();
        System.out.println(n.reverseVowels("hello"));
    }
}
