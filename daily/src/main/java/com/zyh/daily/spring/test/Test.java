package com.zyh.daily.spring.test;

import com.zyh.daily.spring.MyAppContext;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhaoyh on 2017/6/14.
 */
public class Test {
    public static  void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        MyAppContext appContext=new MyAppContext(Config.class);
        Activity activity= (Activity) appContext.getBean("activity");
        System.out.println(activity);
    }
}
