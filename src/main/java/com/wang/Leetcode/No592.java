package com.wang.Leetcode;

public class No592 {
    // 当前分子的值
    int denominator = 0;
    // 当前分母的值
    int numerator = 1;

    public String fractionAddition(String expression) {
        // 计算分数的值
        int len = expression.length();
        // 分子是否需要异号
        boolean flag = false;
        int i = 0;
        while (i < len) {
            char ch = expression.charAt(i);
            int inputDeno = 0;
            int inputNu = 0;
            // 考虑分子是符号还是数字
            if ((ch - '0') >= 0 && (ch - '0') <= 9) {
                // 考虑分子是10的情况
                if ((ch - '0') == 1 && i + 1 < len && (expression.charAt(i + 1) - '0') == 0) {
                    // 移动到分母
                    i = i + 3;
                    char c = expression.charAt(i);
                    inputDeno = 10;
                    inputNu = expression.charAt(i) - '0';
                    i++;
                } else {
                    inputDeno = ch - '0';
                    // 移动到分母
                    i = i + 2;
                    char c = expression.charAt(i);
                    // 分母如果是10
                    if ((c - '0') == 1 && i + 1 < len && (expression.charAt(i + 1) - '0') == 0) {
                        inputNu = 10;
                        i = i + 2;
                        // 分母不为10
                    } else {
                        inputNu = expression.charAt(i) - '0';
                        i++;
                    }
                }
                // 函数相加
                if (flag) {
                    inputDeno = -inputDeno;
                }
                fractionAdd(inputDeno, inputNu);
                // 如果是符号
            } else {
                if (expression.charAt(i) == '-') {
                    flag = true;
                } else {
                    flag = false;
                }
                i++;
            }
        }
        // 计算分数分子分母的最大公因数
        if (denominator==0){
            return "0/1";
        }
        int greatestCommFactor = findGreatestCommFactor(denominator, numerator);
        int a = denominator / greatestCommFactor;
        int b = numerator / greatestCommFactor;
        StringBuilder sb = new StringBuilder();
        sb.append(a).append("/").append(b);
        return sb.toString();
    }

    private int findGreatestCommFactor(int a, int b) {
        a=Math.abs(a);
        b=Math.abs(b);
        if (a == b) {
            return a;
        }
        int dividend = a;
        int divisor = b;
        if (a < b) {
            dividend = b;
            divisor = a;
        }
        int remain = dividend % divisor;
        while (remain != 0) {
            if (remain > divisor) {
                dividend = remain;
            } else{
                dividend = divisor;
                divisor = remain;
            }
            remain = dividend % divisor;
        }
        return divisor;
    }

    // 找到最小公倍数
    private int findMinComMutiple(int a, int b) {
        int common = findGreatestCommFactor(a, b);
        return a * (b/common);
    }

    // 分子分母相加
    private void fractionAdd(int credeno, int curnu) {
        // 找到最小公倍数
        if (curnu != numerator) {
            int tempMuti = findMinComMutiple(numerator, curnu);
            int afac = tempMuti / numerator;
            int bfac = tempMuti / curnu;
            // 分子相加
            denominator = denominator * afac + credeno * bfac;
            // 赋值分母
            numerator = tempMuti;
        } else {
            denominator += credeno;
        }
    }

    public static void main(String[] args) {
        System.out.println(new No592().fractionAddition("7/2+2/3-3/4"));
    }

}

