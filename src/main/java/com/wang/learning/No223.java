package com.wang.learning;

public class No223 {
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area=Math.abs(ay2-ay1)*Math.abs(ax2-ax1)+Math.abs(by2-by1)*Math.abs(bx2-bx1);
        //判断是否有覆盖
        if(bx1>=ax2||by1>=ay2||bx2<=ax1||by2<=ay1){
            return area;
        }

        int x1= Math.max(ax1, bx1);
        int y1= Math.max(ay1, by1);
        int x2= Math.min(ax2, bx2);
        int y2= Math.min(ay2, by2);
        return area-Math.abs(x1-x2)*Math.abs(y1-y2);

    }

    public static void main(String[] args) {
        System.out.println(computeArea(-2286, -2, 2, 2, -2, -2, 2, 2));
    }
}
