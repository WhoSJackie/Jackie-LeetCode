///*
// * @lc app=leetcode.cn id=14 lang=java
// *
// * [14] 最长公共前缀
// */
//
//// @lc code=start
//class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        StringBuilder sb = new StringBuilder();
//        int cnt = 0;
//        while (true){
//            char ch = '\u0000';
//            for (String str:strs){
//                if (cnt<str.length()){
//                    if (ch=='\u0000') ch = str.charAt(cnt);
//                    if (ch!=str.charAt(cnt)) return sb.toString();
//                }
//                else{
//                   return sb.toString();
//                }
//            }
//            sb.append(ch);
//            cnt++;
//        }
//    }
//}
//// @lc code=end
//
