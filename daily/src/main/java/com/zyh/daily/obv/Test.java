package com.zyh.daily.obv;

/**
 * Created by zhaoyh on 2017/11/8.
 */
public class Test {
    public static void main(String[] args) {
        //2个观察者观察被观察者的价格变化一旦变化就通知所有的观察者
        notify notify=new notify();
        //这是2个观察者
        look look1=new look();
        look look2=new look();
        notify.addObserver(look1);
        notify.addObserver(look2);

        notify.changePrice(100);
    }

}
