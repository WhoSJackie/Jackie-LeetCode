package com.wang.java_Learning.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OgnlTest {

    public static Object getOgnlValue(String expression,Object root) throws OgnlException {
        OgnlContext context = new OgnlContext(new DefaultMemberAccess(true),null,null,null);
        context.setRoot(root);
        return Ognl.getValue(expression,context,context.getRoot());
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("a", Arrays.asList("1","2"));
        try {
            Object ognlValue = OgnlTest.getOgnlValue("a==null", map);
            if (ognlValue instanceof Boolean){
                System.out.println((boolean)ognlValue);
            }
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }


}
