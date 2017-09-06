package com.zyh.daily.rpc;

/**
 * Created by zhaoyh on 2017/8/28.
 */
public interface ServerCenter {
    //启动服务
    void start();
    //停止服务
    void stop();
    /**
     * 注册服务
     * @param service 服务接口
     * @param serviceImpl 服务实现类
     */
    void registerService(Class service,Class serviceImpl);
}
