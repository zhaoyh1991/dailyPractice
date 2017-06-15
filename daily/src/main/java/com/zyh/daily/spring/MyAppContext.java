package com.zyh.daily.spring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * 模拟依赖注入的容器
 * Created by zhaoyh on 2017/6/14.
 */
public class MyAppContext {
    private Class configClass;
    private HashMap<String,Object> container=new HashMap<>();
    public MyAppContext(Class configClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        this.configClass = configClass;
        //获取方法
        Method[] allMethods= configClass.getMethods();
        Object target=configClass.newInstance();
        for(Method method:allMethods){
            boolean isBean=method.isAnnotationPresent(MyBean.class);
            if(isBean){
                MyBean myBean=method.getAnnotation(MyBean.class);
                String id=myBean.name();
                Parameter[] parameters= method.getParameters();
                List args=new ArrayList();
                for(Parameter para:parameters){
                    MyBean pAnn=para.getAnnotation(MyBean.class);
                    String pname=pAnn.name();
                    Object o=container.get(pname);
                    args.add(o);
                }
                if(args.size()>0){
                    Object re=method.invoke(target,args.toArray());
                    container.put(id,re);
                }else{
                    Object re=method.invoke(target);
                    container.put(id,re);
                }

            }
        }

    }
    public Object getBean(String name){
        return container.get(name);
    }
}
