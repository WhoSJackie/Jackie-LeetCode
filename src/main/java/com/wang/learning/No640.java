package com.wang.learning;

public class No640 {

    public String solveEquation(String equation) {
        // 左右两边对于x的参数与常数分开存储
        int[] listx = new int[2];
        int[] listc = new int[2];

        String[] strs = equation.split("=");
        int flag = -1;
        for (String str : strs) {
            flag++;
            int index=0;
            while(index<str.length()){
                char s = str.charAt(index);
                if (s>='0'&&s<='9'||s=='+'||s=='-'){
                    index++;
                    int num=0;
                    boolean f = false;
                    if (s>='0'&&s<='9'){
                        num = s-'0';
                        f=true;
                    }
                    while(index<str.length()&&str.charAt(index)>='0'&&str.charAt(index)<='9'){
                        num = 10*num+(str.charAt(index)-'0');
                        f = true;
                        index++;
                    }
                    if (!f){
                        num=1;
                    }
                    if (s=='-'){
                        num=-num;
                    }
                    if (index<str.length()){
                        if (str.charAt(index)=='x'){
                            listx[flag]+=num;
                            index++;
                        } else{
                            listc[flag]+=num;
                        }
                    } else{
                        listc[flag]+=num;
                    }
                } else{
                    listx[flag]++;
                    index++;
                }
            }
        }

        // 求解方程
        // 左边x系数
        int l = listx[0]-listx[1];
        // 右边常数
        int r = listc[1]-listc[0];

        if (l==r&&l==0){
            return "Infinite solutions";
        }
        if (l!=r&&l==0){
            return "No solution";
        }

        return String.valueOf("x="+(r/l));
    }

    public static void main(String[] args) {
        System.out.println(new No640().solveEquation("x+5-3+x=6+x-2"));
    }
}
