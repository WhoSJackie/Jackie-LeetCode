package com.wang.Leetcode;


import java.util.Arrays;
import java.util.List;

public class No648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        InnerTrie innerTrie = new InnerTrie();
        // 向前缀树中插入需要匹配的字符
        for (String s : dictionary) {
            insert(innerTrie,s);
        }

        StringBuilder sb = new StringBuilder();
        String[] res = sentence.split(" ");
        for (String re:res) {
            String temp = searchPrefix(re,innerTrie);
           if (temp!=null){
               sb.append(temp);
           } else{
               sb.append(re);
           }
           sb.append(" ");
        }

        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }

    class InnerTrie{

        private InnerTrie[] children;
        private boolean isEnd;

        public InnerTrie(){
            children = new InnerTrie[26];
            isEnd = false;
        }
    }

    public void insert(InnerTrie trie,String str){
        if (str==null||str.length()<=0){
            return;
        }

        InnerTrie node = trie;
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            int index = s-'a';
            if(node.children[index]==null){
                node.children[index] = new InnerTrie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public String searchPrefix(String str,InnerTrie trie){
        if (str==null||str.length()<=0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        InnerTrie node = trie;
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            int index = s-'a';
            if (node.isEnd){
                return sb.toString();
            }
            sb.append(s);
            if(node.children[index]==null){
                return null;
            }
            node = node.children[index];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No648().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}
