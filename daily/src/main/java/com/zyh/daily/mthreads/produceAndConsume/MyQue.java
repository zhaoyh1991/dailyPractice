package com.zyh.daily.mthreads.produceAndConsume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * this is a simple queue model of producer&consumer use condition to replace the usage of wait() and signal()
 *  tips 1.the condition should be in lock
 *  2.lock is more flexible than synchronized
 * Created by zhaoyh on 2017/6/16.
 */
public class MyQue {
    private int capacity;//capacity of quene
    private int have;//the item numbers we have
    Lock lock=new ReentrantLock();
    Condition fullCondition=lock.newCondition();
    Condition emptyCondition2=lock.newCondition();
    public MyQue(int capacity) {
        this.capacity = capacity;
    }
    public void produce() throws InterruptedException {
        lock.lock();
        if(have==capacity){
            System.out.println("size if full，wait for weak up tp produce");
            fullCondition.await();
        }else{
            have++;
            String tname=Thread.currentThread().getName();
            System.out.println(tname+"produce one，now still have "+have);
        }
        emptyCondition2.signalAll();
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        lock.lock();
        if(have==0){
            System.out.println("size if zero，wait for produce to produce one");
            emptyCondition2.await();
        }else{
            have--;
            String tname=Thread.currentThread().getName();
            System.out.println(tname+" consume one，now still have"+have);
        }
        fullCondition.signalAll();
        lock.unlock();
    }

}
