package com.zyh.daily.mthreads;


import java.util.concurrent.*;

/**
 * Created by zhaoyh on 2017/11/15.
 */
public class TestCompleteFuture {
    public static void main(String[] args) {

        long start1=System.currentTimeMillis();
        ExecutorService executorService= Executors.newCachedThreadPool();
        CompletionService<Long> completionService= new  ExecutorCompletionService(executorService);
        long wantsum = 100000000L;//十亿级别才有明显优势
        int threadnum=4;///在这里设置4是最好的可能是因为这是一个计算密集型任务
        long each=wantsum/threadnum;
        for(int i=1;i<=threadnum;i++){
            int finalI = i;
            completionService.submit(()->{
                long start=each*(finalI -1)+1;
                //long end=Math.min(each*finalI,wantsum);
                long end=each*finalI;
                long sum=0;
                for(long j=start;j<=end;j++){
                    sum+=j;
                }
                return sum;
            });
        }
        long  total=0;
        for(int k=1;k<=threadnum;k++){
            try {
                total+=completionService.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        long end1=System.currentTimeMillis();
        System.out.println("使用多线程的方式计算"+wantsum+"的和"+total+"耗时"+(end1-start1));
        long start2=System.currentTimeMillis();
        long total2=0;
        for(int j=1;j<=wantsum;j++){
            total2+=j;
        }
        long end2=System.currentTimeMillis();
        System.out.println("使用for的方式计算"+wantsum+"的和"+total2+"耗时"+(end2-start2));

        /**
         * 在这里在计算不到十亿级别的时候多线程不具有明显速度优势
         * 因为多线程版本有更多的线程切换和其他对象生成等时间成本
         * 并且此处并不是越多线程越快此处几乎4个线程是最合适的因为这里并没有什么io成本都是cpu运算所以接近计算机核数是最合适的
         *
         * io密集型任务多线程有优势
         * 任务足够多才有优势
         * 需要测试方案才能证明
         *
         *
         * ps这只是一个例子说明可以分割的任务顺序执行vs并行执行 要是算加法的话最快的方式是高斯的方式。。。。。。。
         *
         * 这里是对CompletionService的练习
         */

    }

}
