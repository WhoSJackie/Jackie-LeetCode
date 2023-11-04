package com.wang.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map = new HashMap<>();
        // 将矩阵开头为1的翻转
        // 将每一行拼成一个字符串存在hash表中，统计相同的字符串个数
        for (int i=0;i<matrix.length;i++){
            if (matrix[i][0]==1){
                for (int j=0;j<matrix[i].length;j++){
                    matrix[i][j]=matrix[i][j]==0?1:0;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int z = 0;z<matrix[i].length;z++){
                sb.append(matrix[i][z]);
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }

        int max = 0;
        for (String s : map.keySet()) {
            max = Math.max(max,map.get(s));
        }
        return max;
    }

}
