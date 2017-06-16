package com.zyh.daily.mthreads.produceAndConsume;

import java.util.concurrent.ExecutorService;

/**
 * Created by zhaoyh on 2017/6/16.
 */
public class Test {
    public static void main(String[] args) {
        MyQue myQue=new MyQue(5);
        Thread p=new Thread(new Producer(myQue),"producer1");
        Thread p2=new Thread(new Producer(myQue),"producer2");
        Thread c=new Thread(new Consume(myQue),"consumer");
        p.start();
        p2.start();
        c.start();
    }
}
