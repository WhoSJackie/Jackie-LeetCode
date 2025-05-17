package com.wang.java_Learning.utils;

import com.wang.common.vo.Filters;
import com.wang.common.vo.LeetCodeRequestVo;
import com.wang.common.vo.Variables;
import okhttp3.*;

public class LeetCodeUtil {

    public static Call getLeetcodeProblems(String searchKeyWords){
        String url = "https://leetcode.cn/graphql/";
        OkHttpClient client = new OkHttpClient();
        LeetCodeRequestVo leetCodeVo = new LeetCodeRequestVo();
        leetCodeVo.setOperationName("problemsetQuestionList");
        leetCodeVo.setQuery("\n    query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {\n  problemsetQuestionList(\n    categorySlug: $categorySlug\n    limit: $limit\n    skip: $skip\n    filters: $filters\n  ) {\n    hasMore\n    total\n    questions {\n      acRate\n      difficulty\n      freqBar\n      frontendQuestionId\n      isFavor\n      paidOnly\n      solutionNum\n      status\n      title\n      titleCn\n      titleSlug\n      topicTags {\n        name\n        nameTranslated\n        id\n        slug\n      }\n      extra {\n        hasVideoSolution\n        topCompanyTags {\n          imgUrl\n          slug\n          numSubscribed\n        }\n      }\n    }\n  }\n}\n    "
        );
        Variables variables = new Variables();
        variables.setCategorySlug("all-code-essentials");
        variables.setLimit(50);
        variables.setSkip(0);
        Filters filters = new Filters();
        filters.setSearchKeywords(searchKeyWords);
        variables.setFilters(filters);
        leetCodeVo.setVariables(variables);
        String jsonBody = JsonUtil.toJsonString(leetCodeVo);
//        System.out.println(jsonBody);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(jsonBody,mediaType);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = client.newCall(request);
        // 这里单开一个线程获取响应结果
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    final Response response = call.execute();
//                    System.out.println("response result:");
////                    System.out.println(response.body().string());
//                    LeetCodeResp leetCodeResp = JsonUtil.parseJson(response.body().string(), LeetCodeResp.class);
//                    System.out.println(leetCodeResp);
//                } catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        // 调用异步方法使用
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                System.out.println("response failture!");
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                System.out.println("response result:");
//                System.out.println(response.body().string());
//            }
//        });
        return call;
    }

    public static void main(String[] args) {
        getLeetcodeProblems("1");
    }

}
