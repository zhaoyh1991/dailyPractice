package com.zyh.daily.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * 简单的nio文件读取操作&通道
 * Created by zhaoyh on 2017/6/12.
 */
public class TestBuffer {
    public static  void main(String[] args){
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile("D:/README.md","r");
            FileChannel fileChannel=randomAccessFile.getChannel();
            ByteBuffer buffer= ByteBuffer.allocate(100);
            int nums=fileChannel.read(buffer);
            while(nums!=-1){
                buffer.flip();//模式转换调整三个指针的位置
                while(buffer.hasRemaining()){//循环读取直到读完
                    System.out.print((char) buffer.get());
                }
                buffer.clear();//清除缓冲区
                nums=fileChannel.read(buffer);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
