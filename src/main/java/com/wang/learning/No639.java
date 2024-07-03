package com.wang.learning;

public class No639 {
    static final int MOD = 1000000007;
    public  int numDecodings1(String s) {
        char[] array=s.toCharArray();
        int len=s.length();
        //代表该下标位置之前(包含该下标)的数字能够有多少种编码模式
        long[] res=new long[len+1];

        //初始化第一个位置
        res[0]=1;

        for (int i = 1; i <= len; i++) {
            //判断当前位置的数量和前一位置的继承性,并且根据前一位置的字符，判断增量
            char x=array[i-1];
            res[i]=(res[i-1]*check1digit(x))%MOD;
            if(i>1){
                char y=array[i-2];
                res[i]=(res[i]+res[i-2]*check2digits(y,x))%MOD;
            }

        }

        return (int)res[len];

    }




    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }


}
