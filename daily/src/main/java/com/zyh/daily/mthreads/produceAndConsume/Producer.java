package com.zyh.daily.mthreads.produceAndConsume;

/**
 * Created by zhaoyh on 2017/6/16.
 */
public class Producer implements  Runnable{
    private MyQue myQue;

    public Producer(MyQue myQue) {
        this.myQue = myQue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
                myQue.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
