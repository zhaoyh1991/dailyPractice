package com.zyh.daily.obv;

import java.util.Observable;

/**
 * 被观察者继承
 * Created by zhaoyh on 2017/8/10.
 */
public class notify extends Observable {
    private int price;

    //价格改变了通知所有的观察者
    public void changePrice(int price){
        this.price=price;

        //使用Java util 提供的观察者模式需要先设置状态已经改变然后再通知观察者
        setChanged();
        notifyObservers(price);
    }

}
