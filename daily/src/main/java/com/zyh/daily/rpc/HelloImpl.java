package com.zyh.daily.rpc;

/**
 * Created by zhaoyh on 2017/8/28.
 */
public class HelloImpl implements Hello {
    @Override
    public String hi(String name) {
        return "hi "+name;
    }
}
