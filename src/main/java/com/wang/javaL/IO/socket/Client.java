package com.wang.javaL.IO.socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {


    public void startSend() {
        Socket socket=null;
        OutputStream out=null;
        InputStream inputStream=null;
        InputStreamReader read=null;

        try{
            socket=new Socket("127.0.0.1",80);

            //客户端发送信息
            out = socket.getOutputStream();
//        PrintWriter print=new PrintWriter(out);
//        print.write("hello");
//        print.flush();
//        print.close();
            System.out.println("客户端运行中...,请输入数据...");
            Scanner scanner=new Scanner(System.in);
            String a=null;
            while(!(a=scanner.nextLine()).equals("bye")){
                out.write(a.getBytes());
                out.flush();
            }
            out.write(a.getBytes());
            out.flush();

            //客户端接收信息
            System.out.println("客户端正在接收数据...");
            inputStream=socket.getInputStream();
            read=new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            String info=null;
            int num=0;
            int len;
            char[] chars=new char[1024];
            len=read.read(chars);
            while(!(info=new String(chars,0,len)).equals("bye")){
                System.out.printf("[%d]服务器:[%s]",num,info);
                System.out.println();
                chars=new char[1024];
                len=read.read(chars);
                num++;
            }
            info=new String(chars,0,len);
            System.out.printf("[%d]服务器:[%s]",num,info);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                //关闭资源
                read.close();
                inputStream.close();
                out.close();
                socket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Client sendMsg=new Client();
        sendMsg.startSend();
    }
}
