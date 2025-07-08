package com.wang.java_Learning.mathexpression;

import com.mpobjects.bdparsii.eval.Expression;
import com.mpobjects.bdparsii.eval.Parser;
import com.mpobjects.bdparsii.eval.Scope;
import com.mpobjects.bdparsii.eval.Variable;
import com.mpobjects.bdparsii.tokenizer.ParseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathParser {

    public static void parseExpr(String expr, Map<String,Integer> params){
        Scope scope = new Scope();
        for (String s : params.keySet()) {
            Variable var = scope.getVariable(s);
            var.setValue(params.get(s));
        }
        Expression expre = null;
        try {
            expre = Parser.parse(expr,scope);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(expre.evaluate());
    }


    public static void main(String[] args) {
//        Map<String,Integer> map = new HashMap<String,Integer>(){{
//            put("a",12);
//            put("b",10);
//        }};
//        parseExpr("a*5+b*4=100",map);

        System.out.println("J(T+1)".substring(1).contains("(T+1)"));
    }

}
