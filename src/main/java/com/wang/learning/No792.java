package com.wang.learning;

import java.util.ArrayList;
import java.util.List;

public class No792 {

    public int numMatchingSubseq(String s, String[] words) {
        // 双指针+缓存
//        List<String> match = new ArrayList<>();
//        List<String> unmatch = new ArrayList<>();
//        int count=0;
//        int i;
//        int j;
//        for (String word:words){
//            if (match.contains(word)){
//                count++;
//                continue;
//            }
//            if (unmatch.contains(word)){
//                continue;
//            }
//            // 初始化双指针
//            i=0;
//            j=0;
//            while(i<s.length()&&j<word.length()){
//                if (s.charAt(i)==word.charAt(j)){
//                    i++;
//                    j++;
//                } else{
//                    i++;
//                }
//            }
//            if (j==word.length()){
//                count++;
//                match.add(word);
//            } else{
//                unmatch.add(word);
//            }
//        }
//        return count;


//        // 预处理+二分查找
//        int res=words.length;
//        List[] arr = new List[26];
//        for (int i = 0; i < 26; i++) {
//            arr[i] = new ArrayList<>();
//        }
//
//        // 预先收集s的各字符串位置，相同字符串用list收集各位置
//        for (int i = 0; i < s.length(); i++) {
//            arr[s.charAt(i)-'a'].add(i);
//        }
//
//        for (String word : words) {
//            if (word.length()>s.length()){
//                res--;
//                continue;
//            }
//            int target=-1;
//            for (int i=0;i<word.length();i++){
//                List<Integer> list = arr[word.charAt(i)-'a'];
//                if (list.isEmpty()){
//                    res--;
//                    break;
//                }
//                int index = midSearch(target,list);
//                if (index<=target){
//                    res--;
//                    break;
//                } else{
//                    target = index;
//                }
//            }
//        }
//        return res;
//    }
//
//    // 二分法查找第一个比target大的下标
//    private int midSearch(int target,List<Integer> list){
//        int l=0;
//        int r = list.size()-1;
//        int mid;
//        while(l<r){
//            mid = l+(r-l)/2;
//            if (list.get(mid)>target) r = mid;
//            else l = mid+1;
//        }
//        return list.get(r);
//    }

        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

    public static void main(String[] args) {
        String[] words = {"aab"};
        int count = new No792().numMatchingSubseq("abcd",words);
        System.out.println(count);
    }

}
