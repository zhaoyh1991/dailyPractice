package com.zyh.daily.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by zhaoyh on 2017/8/28.
 */
public class Client {
    public static  <T> T  getProxy(Class service, InetSocketAddress address){
        return  (T)Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket=new Socket();
                socket.connect(address);
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(service.getName());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(args);
                ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                Object res=objectInputStream.readObject();
                socket.close();
                return res;
            }
        });
    }

}
