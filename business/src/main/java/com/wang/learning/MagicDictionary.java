package com.wang.learning;

public class MagicDictionary {
    private String[] dictionary;

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        int bag = 0;
        for (String s : dictionary) {
            // 排除长度不同的条件
            if (searchWord.length()!=s.length()){
                continue;
            }
            int count=0;
            int x1=0;
            int x2=0;
            for (int i = 0; i < s.length(); i++) {
                if (searchWord.charAt(i)!=s.charAt(i)){
                    count++;
                    if (count>1){
                        break;
                    }
                }
            }
            if (count<=1){
                return true;
            }
        }

        return false;
    }
}
