package com.zyh.daily.rpc;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyh on 2017/8/28.
 */
public class Test {
    public static void main(String[] args) {
        new Thread(()->{
            ServerCenter serverCenter=new ServiceCenterImpl(9999);
            serverCenter.registerService(Hello.class,HelloImpl.class);
            serverCenter.start();
        }).start();

        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<10000;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int finalI = i;
            executorService.execute(()->{
                Hello hello=Client.getProxy(Hello.class,new InetSocketAddress("localhost",9999));
                String res= hello.hi("aaa"+ finalI);
                System.out.println(res);

            });
        }


    }
}
