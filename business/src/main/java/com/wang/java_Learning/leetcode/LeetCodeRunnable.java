package com.wang.java_Learning.leetcode;

import com.wang.common.resp.LeetCodeFutureRes;
import com.wang.common.resp.LeetCodeResp;
import com.wang.common.utils.JsonUtil;
import com.wang.common.utils.LeetCodeUtil;
import okhttp3.Call;
import okhttp3.Response;

import java.util.concurrent.Callable;

public class LeetCodeRunnable implements Callable<LeetCodeFutureRes> {

    private String id;

    public LeetCodeRunnable(String id){
        this.id = id;
    }


    @Override
    public LeetCodeFutureRes call() throws Exception {
        LeetCodeFutureRes res = new LeetCodeFutureRes();
        LeetCodeResp leetCodeResp = null;
        try{
            Call call = LeetCodeUtil.getLeetcodeProblems(id);
            final Response response = call.execute();
            leetCodeResp = JsonUtil.parseJson(response.body().string(), LeetCodeResp.class);
            res.setLeetCodeResp(leetCodeResp);
            res.setId(id);
            return res;
        } catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
