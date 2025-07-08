package com.wang.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class NIODemo {

    public  void bufferDemo() {
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("初始状态:");
        printState(buffer);

        System.out.println("写入字符后的状态:");
        buffer.put('a');
        buffer.put('b');
        printState(buffer);

        System.out.println("调用flip后的状态:");
        buffer.flip();
        printState(buffer);

        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

        System.out.println("buffer调用clear的状态:");
        buffer.clear();
        printState(buffer);

    }

    public void printState(CharBuffer buffer){
        System.out.print("capacity:"+buffer.capacity());
        System.out.print(",limit:"+buffer.limit());
        System.out.print(",position:"+buffer.position());
        System.out.println();
    }

    public void mmapDemo(){
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("C:\\Users\\jiami\\Desktop\\test.txt");
            FileChannel channel = stream.getChannel();
            byte[] buffer = new byte[(int)channel.size()];
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            ByteBuffer byteBuffer = map.get(buffer);
            System.out.println(new String(buffer,Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new NIODemo().mmapDemo();
    }


}
