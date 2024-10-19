package com.wang.javaL.IO.utils;

import java.util.List;
import java.util.Map;

public abstract class FileUtils {
    void preHandle(){}

   abstract Map<String,Object> execute(String filePath, int...a);

    void postHandle(){}

}
