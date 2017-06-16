package com.zyh.daily.mthreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyh on 2017/6/12.
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(1);
        CountDownLatch countDownLatch=new CountDownLatch(1);
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
        executorService.shutdown();
    }


}
