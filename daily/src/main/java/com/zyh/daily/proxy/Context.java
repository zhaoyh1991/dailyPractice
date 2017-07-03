package com.zyh.daily.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by zhaoyh on 2017/7/3.
 */
public class Context {
    /**
     * 获取接口的代理类
     * @param t 接口类
     * @param <T> 接口类的实例
     * @return
     */
    public static <T extends Class> Object getSession(T t){
        return  Proxy.newProxyInstance(t.getClassLoader(), new Class[]{t},new SessionHandler());
    }
}
