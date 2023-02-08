package com.wang.java_Learning.socket;

import java.io.*;
import java.net.Socket;

public class Client01 {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8001);
            // 获取输出流，向服务器发送请求信息
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("username:admin;password:123");
            pw.flush();
            socket.shutdownOutput();

            // 接收服务器的响应信息
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            String content;
            while( (content = br.readLine())!=null&&!"".equals(content)){
                System.out.println(content);
            }
            socket.shutdownInput();
            br.close();
            reader.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
