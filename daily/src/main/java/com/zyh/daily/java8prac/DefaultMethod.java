package com.zyh.daily.java8prac;

/**
 * Created by zhaoyh on 2017/7/3.
 */
public interface DefaultMethod {
    /**
     * 默认方法
     */
    default  void hello(){
        System.out.println("hello");
    }

}
