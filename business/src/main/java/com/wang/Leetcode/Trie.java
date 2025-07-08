package com.wang.Leetcode;

class Trie {

    private Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        if (word==null||word.length()<=0){
            return;
        }
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch-'a';
            if (node.children[index]==null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie res = searchPrefix(word);
        return res!=null&&res.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie res = searchPrefix(prefix);
        return res!=null;
    }

    private Trie searchPrefix(String prefix){
        if (prefix==null||prefix.length()<=0){
            return null;
        }
        Trie start = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch-'a';
            if (start.children[index]==null){
                return null;
            }
            start = start.children[index];
        }
        return start;
    }


//    public static void main(String[] args) {
//        String s = "a b c";
//        String[] str = s.split(" ");
//        for (int i = 0; i < str.length; i++) {
//            System.out.println(str[i]);
//        }
//    }
}
