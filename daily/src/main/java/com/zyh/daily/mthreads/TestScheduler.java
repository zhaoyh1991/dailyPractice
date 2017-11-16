package com.zyh.daily.mthreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyh on 2017/11/16.
 */
public class TestScheduler {
    public static void main(String[] args) {
        //定时执行任务
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("hello");
        },10,10, TimeUnit.SECONDS);
    }
}
