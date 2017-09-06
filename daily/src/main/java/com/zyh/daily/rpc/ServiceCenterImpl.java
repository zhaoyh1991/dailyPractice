package com.zyh.daily.rpc;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyh on 2017/8/28.
 */
public class ServiceCenterImpl implements ServerCenter {
    private volatile boolean running=false;
    private HashMap<String,Class> services=new HashMap<>();
    private ExecutorService executors= Executors.newCachedThreadPool();
    private int port;

    public ServiceCenterImpl(int port) {
        this.port = port;
    }

    @Override
    public void start() {
        running=true;
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(port);
            while (running){
                Socket socket = serverSocket.accept();
                executors.execute(new ServiceTask(socket));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            executors.shutdown();
        }
    }

    @Override
    public void stop() {
        running=false;
        executors.shutdown();
    }

    @Override
    public void registerService(Class service, Class serviceImpl) {
        services.put(service.getName(),serviceImpl);
    }

    private class ServiceTask implements Runnable {
        private Socket socket;
        public ServiceTask(Socket socket) {
            this.socket=socket;
        }
        @Override
        public void run() {
            ObjectInputStream objectInputStream=null;
            ObjectOutputStream objectOutputStream=null;
            try {
                InputStream inputStream = socket.getInputStream();
                objectInputStream=new ObjectInputStream(inputStream);
                String serviceName=objectInputStream.readUTF();
                String methodName=objectInputStream.readUTF();
                Class[] parameterTypes= (Class[]) objectInputStream.readObject();
                Object[] parameter= (Object[]) objectInputStream.readObject();
                Class service = services.get(serviceName);
                if(service==null){
                    throw new ClassNotFoundException();
                }
                Method method = service.getMethod(methodName, parameterTypes);
                Object result=method.invoke(service.newInstance(),parameter);
                OutputStream outputStream=socket.getOutputStream();
                objectOutputStream=new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(result);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }finally {
                if(objectInputStream!=null){
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(objectOutputStream!=null){
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
