package com.wang.javaL.IO.socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {



    public void startReceive()  {
        ServerSocket serveFactory=null;
        Socket server=null;
        InputStream inputStream=null;
        InputStreamReader read=null;
        OutputStream output=null;
        try{
            serveFactory=new ServerSocket(80);
            server=serveFactory.accept();
            System.out.println("服务器运行中...，接收数据中...");
            inputStream = server.getInputStream();
            read=new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            char[] chars=new char[1024];
            String info=null;
            int num=0;
            int len;
            len=read.read(chars);
            while(!(info=new String(chars,0,len)).equals("bye")){
                System.out.printf("[%d]客户端:[%s]",num,info);
                System.out.println();
                num++;
                chars=new char[1024];
                len=read.read(chars);
            }
            info=new String(chars,0,len);
            System.out.printf("[%d]客户端:[%s]",num,info);
            System.out.println();

//            BufferedReader br=new BufferedReader(read);
//            while(!(info=br.readLine()).equals("bye")){
//                System.out.printf("[%d]客户端:[%s]",num,info);
//                System.out.println();
//                num++;
//            }
//            System.out.printf("[%d]客户端:[%s]",num,info);

            output=server.getOutputStream();
            System.out.println("服务器请应答：");
            Scanner scanner=new Scanner(System.in);
            String msg=null;
            while(!(msg=scanner.nextLine()).equals("bye")){
                output.write(msg.getBytes());
                output.flush();
            }
            output.write(msg.getBytes());
            output.flush();


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                //关闭资源
                output.close();
                read.close();
                inputStream.close();
                server.close();
                serveFactory.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Server receiveMsg=new Server();
        receiveMsg.startReceive();
    }
}
