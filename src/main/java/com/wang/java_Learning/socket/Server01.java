package com.wang.java_Learning.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8001);
            while(true){
                Socket socket  = server.accept();
                InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(reader);
                String content;
                while( (content = br.readLine())!=null&&!"".equals(content)){
                    System.out.println(content);
                }
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("HTTP/1.1 200 OK");
                printWriter.println("Content-Type:text/html;charset=utf-8");
                String body = "hello,nio1";
                printWriter.println("Content-Length:" + body.getBytes().length);
                printWriter.println("******************");
                printWriter.println(body);
                printWriter.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
