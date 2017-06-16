package com.zyh.daily.MyDistributeFileSystem;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 目标---实现一个最最简单的分布式存储的文件系统
 * 元文件信息保存方式待定（数据库存储/内存存储/写到本地。。。）
 * 文件分成固定的块然后每个存储到某些机器上（冗余备份机制待定）
 * 发现可用机器方式待定（心跳数据报方式?）
 * 需要实现一个文件存储的server来和客户端交互
 * Created by zhaoyh on 2017/6/16.
 */
public class FS {
    private long blockSize=1024*10;
    public void write(File fileToRead) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(fileToRead,"rb");
        FileChannel fileChannel=randomAccessFile.getChannel();
        long size=fileChannel.size();
        int blocknums= (int) Math.ceil(size*1.0/blockSize);
        ExecutorService service= Executors.newFixedThreadPool(blocknums);
        for(int i=0;i<blocknums;i++){//多线程写
            final int n=i;
            service.execute(new Runnable() {
                RandomAccessFile file=new RandomAccessFile(fileToRead,"rb");
                FileChannel channel=file.getChannel();
                @Override
                public void run() {
                    long start=n*blockSize+1;
                    ByteBuffer byteBuffer=ByteBuffer.allocate((int) blockSize);
                    try {
                        FileChannel part=channel.position(start);
                        int readn=part.read(byteBuffer);
                        while(readn!=-1){
                            //这里需要实现一个文件server和和一个客户端实现文件的读写（需要将每次的文件名和文件类容组合发送到服务端，服务端解析此次操作
                            //如果是读则读取返回给客户端如果是写则将内容写到指定的文件
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public void read(File filetoWrite) throws FileNotFoundException {
        OutputStream outputStream=new FileOutputStream(filetoWrite);
        FileInfo fileInfo=null;
        for(BlockInfo blockInfo:fileInfo.getBlockInfos()){

        }
    }
}
