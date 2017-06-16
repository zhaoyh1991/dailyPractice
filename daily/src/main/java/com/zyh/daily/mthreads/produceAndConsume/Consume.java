package com.zyh.daily.mthreads.produceAndConsume;

/**
 * Created by zhaoyh on 2017/6/16.
 */
public class Consume implements Runnable {
    private  MyQue myQue;

    public Consume(MyQue myQue) {
        this.myQue = myQue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
                myQue.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
