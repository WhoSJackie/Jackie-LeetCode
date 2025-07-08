package com.wang.java_Learning.leetcode;

import com.wang.common.resp.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.concurrent.*;

public class LeetCodeClient {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);

    public  void queryProblemSetById(List<String> ids){
        if (CollectionUtils.isEmpty(ids)) {
            System.out.println("题号为空!");
            return;
        }
        List<String> easyProblemList = new ArrayList<>();
        List<String> mediumProblemList = new ArrayList<>();
        List<String> hardProblemList = new ArrayList<>();
        long s = System.currentTimeMillis();
        List<Future<LeetCodeFutureRes>> resList = new ArrayList<>();
        try{
            // 多线程提交任务
            // todo:后续可以修改成分成几个list来处理
            for (String id : ids) {
                Future<LeetCodeFutureRes> future = executorService.submit(new LeetCodeRunnable(id.trim()));
                resList.add(future);
            }
            // 获取结果
            for (Future<LeetCodeFutureRes> future : resList) {
                getSingleResp(future,easyProblemList,mediumProblemList,hardProblemList);
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println("耗时："+((System.currentTimeMillis()-s)/1000)+"s");
        printList(easyProblemList,"easy");
        printList(mediumProblemList,"medium");
        printList(hardProblemList,"hard");
    }

    private void getSingleResp(Future<LeetCodeFutureRes> future,List<String> easyProblemList,List<String> mediumProblemList,List<String> hardProblemList) throws InterruptedException, ExecutionException {
        // 获取结果
        // 运行结束之前不断循环
        while (!future.isDone()) {
        }
        LeetCodeFutureRes LeetCodeFutureRes = future.get();
        handleLeetCodeResp(LeetCodeFutureRes.getLeetCodeResp(),LeetCodeFutureRes.getId(),easyProblemList,mediumProblemList,hardProblemList);
    }

    private void handleLeetCodeResp(LeetCodeResp resp, String id, List<String> easyProblemList,List<String> mediumProblemList,List<String> hardProblemList){
        if (resp!=null){
            LeetCodeData data = resp.getData();
            ProblemsetQuestionListResp questionList = data.getProblemsetQuestionList();

            Optional<Questions> first = questionList.getQuestions().stream().filter(i -> {
                return (id.equals(i.getFrontendQuestionId()));
            }).findFirst();
            if (!first.isPresent()){
                System.out.println("id为"+id+"的题号未找到!");
                System.out.println("\n");
                return;
            }
            Questions question = first.get();
            String questionId = question.getFrontendQuestionId();
            String diffculty = question.getDifficulty();
            switch(diffculty){
                case "EASY": easyProblemList.add(questionId);
                             break;
                case "MEDIUM":mediumProblemList.add(questionId);
                              break;
                case "HARD": hardProblemList.add(questionId);
                             break;
                default:break;
            }
        }
    }


    private void printList(List<String> list,String listName){
        System.out.println("***********开始打印"+listName+"队列，一共"+list.size()+"题**********");
        StringBuffer sb = new StringBuffer();
        if (!CollectionUtils.isEmpty(list)){
            for (String s : list) {
                sb.append(s).append("、");
            }
            System.out.println(sb.substring(0,sb.length()-1));
        } else{
            System.out.println("题目为空！");
        }
        System.out.println();
        System.out.println("***********结束打印"+listName+"队列**********");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入题号(以*结束):");
        StringBuilder idListSb = new StringBuilder();
        while (scanner.hasNextLine()){
            String cur = scanner.nextLine();
            if (cur.equals("*")) break;
            idListSb.append(cur);
        }
        String[] strIds =  idListSb.toString().replace("\n","").split("、");
        List<String> idList = Arrays.asList(strIds);
        System.out.println("输入题数:"+idList.size());
        new LeetCodeClient().queryProblemSetById(idList);

    }

}
