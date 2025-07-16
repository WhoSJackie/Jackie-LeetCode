package com.wang.java_Learning.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource{

    private final String path;

    private final File file;

    public FileSystemResource(File file){
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path){
        this.file = new File(path);
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return path;
    }
}
