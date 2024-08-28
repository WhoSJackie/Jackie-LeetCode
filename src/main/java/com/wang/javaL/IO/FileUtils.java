package com.wang.javaL.IO;

import java.util.List;

public abstract class FileUtils {
    void preHandle(){}

   abstract List<String> execute(String filePath,int...a);

    void postHandle(){}

}
