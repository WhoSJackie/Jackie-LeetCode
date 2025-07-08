package com.wang.java_Learning.script;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @date 2025/1/21
 */
public class FindMgrNotInUse {
    private static List<String> cacheList = new ArrayList<String>();
    private static List<String> memdbList = new ArrayList<String>();
    private static List<String> phydbList = new ArrayList<String>();
    public static void main(String[] args) {
//        args= new String[]{"D:\\company_project\\FS2.5\\macbs-base"};
        if(args.length == 0)
        {
            System.out.println("请输入项目路径");
            return;
        }
        String filepaths = "\\library\\macbs\\dao";
        // 获取需要查询的文件名称
        traverseFiles(args[0]+filepaths+"\\tables_cache_mgr",cacheList);
        traverseFiles(args[0]+filepaths+"\\tables_memdb_mgr",memdbList);
        traverseFiles(args[0]+filepaths+"\\tables_phydb_mgr",phydbList);

        //遍历目录
        String findPath = args[0]+"\\lbm\\macbs";
        // 获取文件夹对象
        File folder = new File(findPath);
        // 检查文件夹是否存在且为目录
        if (folder.exists() && folder.isDirectory()) {
            // 获取文件夹中的所有文件和文件夹（包括子文件夹中的文件）
//            File[] fileList = folder.listFiles();
//            if (fileList != null) { // 确保fileList不为null，即文件夹不为空
//                for (File file : fileList) {
//                    if (file.isFile()) { // 确保是文件而不是目录
//                        searchInFile(file);
//                    } else if (file.isDirectory()) { // 如果是目录，则递归搜索
//                        searchInDirectory(file);
//                    }
//                }
//            }
            searchInDirectory(folder);
        } else {
            System.out.println("指定的路径不是一个有效的目录");
        }
        // 写入文件
        try {
            // 创建FileWriter对象，指定文件路径和是否追加内容
            FileWriter writer = new FileWriter("output.txt", true); // true表示追加内容
            PrintWriter printWriter = new PrintWriter(writer);

            // 写入内容
            printWriter.println("tables_cache_mgr目录下未使用的文件");
            for (String cache : cacheList)
            {
                printWriter.println(cache);
            }
            printWriter.println("\n\n");
            printWriter.println("tables_memdb_mgr目录下未使用的文件");
            for (String memdb : memdbList)
            {
                printWriter.println(memdb);
            }
            printWriter.println("\n\n");
            printWriter.println("tables_phydb_mgr目录下未使用的文件");
            for (String phydb : phydbList)
            {
                printWriter.println(phydb);
            }
            // 关闭PrintWriter和FileWriter
            printWriter.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void traverseFiles(String path,List<String> list) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    list.add(file.getName());
                }
            }
        }
    }
//    public static void traverseMemdbFiles(String path) {
//        File folder = new File(path);
//        File[] files = folder.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                if (!file.isDirectory()) {
//                    memdbList.add(file.getName());
//                }
//            }
//        }
//    }
//    public static void traversePhydbFiles(String path) {
//        File folder = new File(path);
//        File[] files = folder.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                if (!file.isDirectory()) {
//                    phydbList.add(file.getName());
//                }
//            }
//        }
//    }
    private static void searchInFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line ;
            while ((line = reader.readLine()) != null ) {
                if (line.contains("_mgr.h") && line.contains("#include"))
                {
                    boolean isExists = false;
                    for(String cache:cacheList)
                    {
                        if(line.contains(cache))
                        {
                            isExists = true;
                            cacheList.remove(cache);
                            System.out.println("找到匹配的行在文件: " + file.getAbsolutePath());
                            System.out.println("行内容: " + line);
                            break;
                        }
                    }
                    if (!isExists)
                    {
                        for(String memdb:memdbList)
                        {
                            if(line.contains(memdb))
                            {
                                isExists = true;
                                memdbList.remove(memdb);
                                System.out.println("找到匹配的行在文件: " + file.getAbsolutePath());
                                System.out.println("行内容: " + line);
                                break;
                            }
                        }
                    }
                    if (!isExists)
                    {
                        for(String phydb:phydbList)
                        {
                            if(line.contains(phydb))
                            {
                                isExists = true;
                                phydbList.remove(phydb);
                                System.out.println("找到匹配的行在文件: " + file.getAbsolutePath());
                                System.out.println("行内容: " + line);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) { // 确保是文件而不是目录
                    searchInFile(file);
                } else if (file.isDirectory()) { // 如果是目录，则递归搜索
                    searchInDirectory(file);
                }
            }
        }
    }
}
