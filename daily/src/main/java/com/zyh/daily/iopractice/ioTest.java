package com.zyh.daily.iopractice;

import java.io.*;

/**
 * Created by zhaoyh on 2017/11/8.
 */
public class ioTest {
    public static void main(String[] args) throws IOException {
        //用输入流读取文件
        File file=new File("D:/README.MD");
        InputStream inputStream=new FileInputStream(file);
        byte[] buff=new byte[1024];
        int len=-1;
        while(-1!=(len=inputStream.read(buff))){
            System.out.print(new String(buff,0,len));
        }
        inputStream.close();
        //用reader读取
        Reader reader=new FileReader("D:/README.MD");
        BufferedReader bufferedReader=new BufferedReader(reader);
        String line=null;
        while(null!=(line=bufferedReader.readLine())){
            System.out.println(line);
        }
        //基本操作还有其他的转换流 序列化 等

    }
}
