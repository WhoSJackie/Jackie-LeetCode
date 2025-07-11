package com.wang.Leetcode;


import com.wang.common.ListNode;
import com.wang.common.TreeNode;
import com.wang.common.utils.ListNodeUtil;
import com.wang.common.utils.TreeNodeUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class EasySolution {

    private int i;

    public int inc(int m){
        return m+i;
    }

    public int tryCatch(){
        int i;
        try{
            i = 1;
            return i;
        } catch(Exception e){
            i = 2;
            return i;
        } finally{
            i = 3;
        }
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if (words.length==1) return Arrays.asList(words);
        List<String> list = new ArrayList<>();
        int i=0;
        int len = words.length;
        list.add(words[i++]);
        while (i<len){
            if (groups[i]!=groups[i-1]) list.add(words[i]);
            i++;
        }
        return list;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);
        int l = 0,r = 0;
        for (int i = 0; i < len; i++) {
            l = i+1;
            r = len-1;
            while (l<r){
                int temp = nums[i]+nums[l]+nums[r];
                if (temp>0)r--;
                else if (temp<0) l++;
                else {
                    resSet.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }
            }
        }
        return new ArrayList<>(resSet);
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int len = words.length;
        int[] dp = new int[len];
        int[] pre = new int[len];
        int maxIndex=0;
        Arrays.fill(dp,1);
        Arrays.fill(pre,-1);
        for (int i = 1; i < len; i++) {
            for (int j=0;j<i;j++){
                if (isValid(words[i],words[j]) && dp[i]<dp[j]+1 && groups[i]!=groups[j]){
                    dp[i] = dp[j]+1;
                    pre[i] = j;
                }
            }
            if (dp[maxIndex]<dp[i]) maxIndex = i;
        }
        String[] strs = new String[dp[maxIndex]];
        int index= dp[maxIndex]-1;
        for (int x = maxIndex; x >=0; ) {
            strs[index--] = words[x];
            x = pre[x];
        }
        return Arrays.asList(strs);
    }

    private boolean isValid(String word1,String word2){
        if (word1.length()!=word2.length()) return false;
        int cnt=0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i)!=word2.charAt(i)) cnt++;
            if (cnt>1) return false;
        }
        return cnt==1;
    }


    public int maxLength (int[] nums) {
        if (nums.length<3) return 0;
        int len = nums.length;
        int max=0,l = 0,r = 0;
        for (int i = 1; i < len; i++) {
            // 左边
            l = i;
            boolean flagl = false;
            while (l>0 && nums[l]>nums[l-1]){
                l--;
                flagl = true;
            }
            // 右边
            r = i;
            boolean flagr = false;
            while (r<len-1 && nums[r]>nums[r+1]){
                r++;
                flagr = true;
            }
            if (flagr && flagl) max = Math.max(max,r-l+1);
        }
        return max;
    }

    public int test(){
        int a = 0;
        try{
            a++;
            return a;
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            a++;
            System.out.println("finally");
        }
        return a;
    }

    private TreeNode pre;
    public void flatten(TreeNode root) {
        buildListNode(root);
    }
    private void buildListNode(TreeNode root){
        if (root==null) return;
        buildListNode(root.right);
        buildListNode(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i],i);
        }
        return buildTreeDetail(preorder,cache,0,inorder.length-1);
    }

    private  TreeNode buildTreeDetail(int[] preorder,Map<Integer,Integer> cache,int l,int r){
        if (l>r) return null;
        int root = preorder[index++];
        // 找到在中序数组中出现的位置
        Integer inIx = cache.get(root);
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTreeDetail(preorder,cache,l,inIx-1);
        rootNode.right = buildTreeDetail(preorder,cache,inIx+1,r);
        return rootNode;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建立邻接表
        LinkedList<Integer>[] edgeList = new LinkedList[numCourses];
        // 记录入度
        int[] edgeDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (edgeList[prerequisites[i][1]]==null) edgeList[prerequisites[i][1]] = new LinkedList<>();
            edgeList[prerequisites[i][1]].add(prerequisites[i][0]);
            edgeDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 初始化入度为0的点
        for (int i = 0; i < edgeDegree.length; i++) {
            if (edgeDegree[i]==0) queue.add(i);
        }

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if (edgeList[poll]==null) continue;
            // 消除相关依赖
            for (int i = 0; i < edgeList[poll].size(); i++) {
                edgeDegree[edgeList[poll].get(i)]--;
                if (edgeDegree[edgeList[poll].get(i)]==0) queue.offer(edgeList[poll].get(i));
            }
        }
        for (int i = 0; i < edgeDegree.length; i++) {
           if (edgeDegree[i]!=0) return false;
        }
        return true;
    }

    List<List<String>> res = new ArrayList<>();
    int[][] f;
    public List<List<String>> partition(String s) {
        f = new int[s.length()][s.length()];
        List<String> tempList = new ArrayList<>();
        dfs(s,0,0,tempList);
        return res;
    }

    private void dfs(String s,int l, int r,List<String> tempList){
        if (r==s.length()){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s,l,i)==1) tempList.add(s.substring(l,i+1));
            else continue;
            dfs(s,i+1,i+1,tempList);
            tempList.remove(tempList.size()-1);
        }
    }

    private int isPalindrome(String s,int l,int r){
        if (f[l][r]!=0) return f[l][r];
        if (l>=r) f[l][r] = 1;
        else if(s.charAt(l)==s.charAt(r)) f[l][r] = isPalindrome(s,l+1,r-1);
        else f[l][r] = -1;
        return f[l][r];
    }

    public String decodeString(String s) {
        return dfs(s,0)[0];
    }

    private String[] dfs(String s,int i){
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        while (i<s.length()){
            char ch = s.charAt(i);
            if (ch>='0' && ch<='9'){
                cnt = cnt*10+(ch-'0');
            } else if (ch=='['){
                String[] tmp = dfs(s,i+1);
                while (cnt>0){
                    sb.append(tmp[1]);
                    cnt--;
                }
                i = Integer.parseInt(tmp[0]);
            } else if (ch==']'){
                return new String[]{String.valueOf(i),sb.toString()};
            } else{
                sb.append(ch);
            }
            i++;
        }
        return new String[]{sb.toString()};
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        res[len-1] = 0;
        int[] ix = new int[len];
        ix[len-1] = len;
        for (int i = len-2; i >=0; i--) {
            int cur = temperatures[i];
            if (cur<temperatures[i+1]) {
                res[i] = 1;
                ix[i] = i+1;
            } else{
                int tmpIx = ix[i+1];
                while (tmpIx<len && temperatures[tmpIx]<=cur){
                    tmpIx = ix[tmpIx];
                }
                if (tmpIx<len){
                    res[i] = tmpIx-i;
                    ix[i] = tmpIx;
                } else{
                    res[i] = 0;
                    ix[i] = tmpIx;
                }
            }
        }
        return res;
    }

    ListNode a = null;
    public ListNode reverseList(ListNode head) {
        recursion(head);
        return a.next;
    }

    private ListNode recursion(ListNode head){
        if (head==null) {
            a = new ListNode(0);
            return a;
        }
        ListNode nextNode = recursion(head.next);
        nextNode.next = head;
        head.next = null;
        return head;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int ix = 2;
        res.add(new ArrayList<Integer>(){{add(1);}});
        while (ix<=numRows){
            List<Integer> curList = new ArrayList<>();
            List<Integer> last = res.get(ix - 2);
            for (int i = 0; i < ix; i++) {
                if (i == 0 || i == ix-1){
                    curList.add(1);
                    continue;
                }
                curList.add(last.get(i-1)+last.get(i));
            }
            res.add(curList);
            ix++;
        }
        return res;
    }

    public static void main(String[] args) {

    }


}
