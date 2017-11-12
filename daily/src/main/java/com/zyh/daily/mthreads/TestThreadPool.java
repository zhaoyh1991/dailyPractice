package com.zyh.daily.mthreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyh on 2017/6/12.
 */
public class TestThreadPool {
    public static void main(String[] args) {
        //这里演示的是固定大小的线程池还有其他的如可变大小的，可定时的等等
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        //这里演示了栅栏的用法设定大小后如果还没有被countdown到0则会一直被await阻塞等待
        CountDownLatch countDownLatch=new CountDownLatch(1);
        //给线程池传入的对象应该是实现了runnable的类这里是一个匿名类
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                countDownLatch.countDown();

            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭线程池
        executorService.shutdown();
    }


}
