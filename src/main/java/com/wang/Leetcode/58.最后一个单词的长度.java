///*
// * @lc app=leetcode.cn id=58 lang=java
// *
// * [58] 最后一个单词的长度
// */
//
//// @lc code=start
//class Solution {
//    public int lengthOfLastWord(String s) {
//        char[] chs = s.toCharArray();
//        int len = chs.length;
//        int cnt = 0;
//        for (int i=len-1;i>=0;i--){
//            if (i==len-1 && chs[i]==' '){
//                while (i>=0 && chs[i]==' ') i--;
//            }
//            if (i<0) return cnt;
//            if (chs[i]==' ') return cnt;
//            cnt++;
//        }
//        return cnt;
//    }
//}
//// @lc code=end
//
