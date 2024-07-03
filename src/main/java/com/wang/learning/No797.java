package com.wang.learning;

import java.util.ArrayList;
import java.util.List;

public class No797 {
    private List<List<Integer>> res=new ArrayList<>();
    int row=0;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        row=graph.length;
        boolean[] flag=new boolean[row];
        List<Integer> path=new ArrayList<>();
        path.add(0);
        solution(graph,flag,path,0);
        return res;
    }

    public void solution(int[][] graph,boolean[] flag,List<Integer> path,int i){
        if(i==row-1){
            res.add(new ArrayList<>(path));
            return;
        }

        int size=graph[i].length;

        for (int j = 0; j < size; j++) {
            int spot=graph[i][j];
            if(flag[spot]){
                continue;
            }
            path.add(spot);
            flag[spot]=true;
            solution(graph,flag,path,spot);
            flag[spot]=false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        No797 n=new No797();
        int[][] graph={{1,2},{3},{3},{}};
        n.allPathsSourceTarget(graph);
        System.out.println(n.res);
    }
}
