package com.zyh.daily.mthreads;

/**
 * 所谓单例模式，核心思想是在多线程调用下也只能产生一个对象
 * 1.要将构造器设为私有，这样就无法直接new出对象
 * 2.二次检查多线程环境下一次判断可能多个线程同时满足条件所以要在获得锁之后再次判断
 * 3.要是用类锁而不是this对象锁因为this是属于每个实例的
 * Created by zhaoyh on 2017/11/3.
 */
public class Single {
    private static Single single=null;

    private  Single() {
    }
    public static Single getInstance(){
        if(single==null){
            synchronized (Single.class){
                if(single==null){
                    single=new Single();
                }
            }
        }
        return single;
    }
}
