package com.wang.javaL.regex;


import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    private static final String PATTERN = ":[^\\s]+";

    private static final String INFO_PATTERN = "%.+?%";


    public static void matchRegex (String pa,String str){
        Pattern pattern = Pattern.compile(pa);
//        String sql = "select t.jgbh,t.bgnd,PKG_PUB.f_get_dict(t.bgqj,76201) BGQJ,t.qcrq,t.qmrq,t.gsdm,PKG_PUB.f_get_dict(t.xmbh,76349) XMBH  from rp_cisp_B3043 t where t.batchno = :batchno <int>   and t.jgbh is null";
        Matcher matcher = pattern.matcher(str);
        Set<String> param = new HashSet<>();
        while (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
            param.add(group);
        }
    }

    public static String regexHandle(String rawSql){
        String rex ="<[^\\s]+?>";
        return rawSql.replaceAll(rex,"");
    }

    public static void regexHandle2(String rawSql){
        String regex =":[^\\s]+";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(rawSql);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }


    public static void main(String[] args) {
        // matchRegex
//        String str = "【机构编号：%jgbh%,报告年度：%bgnd%,报告期间：%bgqj%,期初日期：%qcrq%,期末日期：%qmrq%,公司代码：%gsdm%,项目编号：%xmbh%】机构编号不为空\n";
//        matchRegex(INFO_PATTERN,str);

        // regexHandle
//        String str1 = "select nvl(t.cny,0)  as elementvalue\n" +
//                "  from rp_zgcp_p0001 t\n" +
//                " where t.rowno = '100000'\n" +
//                "   and t.batchno = :batchno <int>";
//        // System.out.println(regexHandle(str1));
//
//        // regexHandle2
//        regexHandle2(str1);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
    }

}
