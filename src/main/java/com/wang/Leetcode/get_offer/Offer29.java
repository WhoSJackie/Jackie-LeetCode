package com.wang.Leetcode.get_offer;

public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0) return new int[]{};
        int cnt = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int size = row*col;
        int[] arr = new int[size];
        boolean isRow = true;
        boolean isReverse = false;
        boolean[] rowVis = new boolean[row];
        boolean[] colVis = new boolean[col];
        int x=0;
        int y=0;
        while (cnt<size){
            if (isRow) {
                while (y>=0&&y<matrix[0].length&&cnt<size){
                    if (colVis[y]){
                        break;
                    }
                    if (!isReverse){
                        arr[cnt++] = matrix[x][y++];
                    } else{
                        arr[cnt++] = matrix[x][y--];
                    }
                }
                rowVis[x] = true;
                y = isReverse?y+1:y-1;
                x = isReverse?x-1:x+1;
                isRow = !isRow;
            } else{
                while (x>=0&&x<matrix.length&&cnt<size){
                    if (rowVis[x]){
                        break;
                    }
                    if (!isReverse){
                        arr[cnt++] = matrix[x++][y];
                    } else{
                        arr[cnt++] = matrix[x--][y];
                    }
                }
                colVis[y] = true;
                x = isReverse?x+1:x-1;
                y = isReverse?y+1:y-1;
                isRow = !isRow;
                isReverse = !isReverse;
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        int[][] testa = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] order = new Offer29().spiralOrder(testa);
        for (int i : order) {
            System.out.println(i);
        }
    }

}
