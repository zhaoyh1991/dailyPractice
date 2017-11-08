package com.zyh.daily.design;

import java.util.List;

/**
 * Created by zhaoyh on 2017/10/22.
 */
public class TestA {
    public static void main(String[] args) {
        A a=new A1();
        List<String> strings=a.choose((s)->s.startsWith("A"));
        System.out.println(strings);
    }

}
