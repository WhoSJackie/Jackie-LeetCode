package com.wang.learning;

public class No789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] player={0,0};
        int distance=manhautunDistance(player,target);
        for (int[] ghost : ghosts) {
            if(distance>=manhautunDistance(ghost,target)){
                return false;
            }
        }
        return true;
    }

    public int manhautunDistance(int[] x,int[] y){
        return Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
    }
}
