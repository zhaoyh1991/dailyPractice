package com.zyh.daily.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * future的方式Aio
 * Created by zhaoyh on 2017/6/12.
 */
public class TestAio {
    public static void  main(String[] args){
        Path path= Paths.get("D:/README.md");
        AsynchronousFileChannel asynchronousFileChannel=null;
        try {
            asynchronousFileChannel=AsynchronousFileChannel.open(path);
            long size=asynchronousFileChannel.size();
            ByteBuffer byteBuffer=ByteBuffer.allocate((int) size);
            Future<Integer> nums=asynchronousFileChannel.read(byteBuffer,0);
            System.out.println("这里可以做其他的事情并不会被阻塞");
            if(!nums.isDone()){
                System.out.println("这里可以证明读取未完但是没有阻塞");
            }
            nums.get();//这里阻塞直到读取出来
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                byte b=byteBuffer.get();
                System.out.print((char)b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            if(asynchronousFileChannel!=null){
                try {
                    asynchronousFileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
