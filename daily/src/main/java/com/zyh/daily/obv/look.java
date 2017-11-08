package com.zyh.daily.obv;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者需要实现接口
 * Created by zhaoyh on 2017/8/10.
 */
public class look implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("price change "+arg);
    }
}
