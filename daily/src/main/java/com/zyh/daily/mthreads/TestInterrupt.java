package com.zyh.daily.mthreads;

/**
 * Created by zhaoyh on 2017/11/11.
 */
public class TestInterrupt {
    public static void main(String[] args) {
        //线程只能自己检查中断状态或者sleep wait 等会检查中断状态的方法
        //这里使用了lambda表达式代替匿名类Runnale
        //和下面的表达是一样的
       /* Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });*/


        Thread thread=new Thread(()->{
            /*try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                System.out.println("被中断");
            }*/
            for(int i=0;i<1000;i++){
                if(!Thread.currentThread().isInterrupted()){
                    System.out.println("继续执行，终止sleep");
                }else{
                    return;
                }
            }
        });
        thread.start();

        //在其他线程中中断一个线程
        new Thread(()->{
            thread.interrupt();
        }).start();

        //主线程可以中断其他线程
        //thread.interrupt();
    }

}
