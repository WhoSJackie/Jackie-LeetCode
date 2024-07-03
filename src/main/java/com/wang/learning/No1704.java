package com.wang.learning;

import java.util.HashSet;
import java.util.Set;

public class No1704 {

    public boolean halvesAreAlike(String s) {
        // 初始化元音字母
        Set<Character> set = new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int index1=0;
        int i=0;
        int j=s.length()-1;
        int count1=0;
        int count2=0;
        while(index1<(s.length()/2)){
            if (set.contains(s.charAt(index1))) count1++;
            if (set.contains(s.charAt(s.length()-index1-1))) count2++;
            index1++;
        }
        return count1==count2;
    }

    private boolean checkVowel(char s){
        if ((s =='A')|| (s=='E')|| (s=='I')|| (s=='O')|| (s=='U')|| (s=='a')|| (s=='e')|| (s=='i')|| (s=='o')|| (s=='u')){
            return true;
        }
        return false;
    }

}
