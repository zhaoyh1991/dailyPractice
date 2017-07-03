package com.zyh.daily.proxy;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理器这里依照注解实现相应的方法(类型怎么转换之类的木有搞定)
 * Created by zhaoyh on 2017/7/3.
 */
public class SessionHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean haveQ=method.isAnnotationPresent(Query.class);
        if(haveQ){
            Query query= method.getAnnotation(Query.class);
            String sql=query.sql();
            System.out.println(sql);
            Parameter[] parameters=method.getParameters();
            Map<String,Object> paraargs=new HashMap<>();
            final int[] i = {0};//lambda 应用外部变量必须是实际上不可变的但是我们用引用类型可以避开这一限制
            Arrays.stream(parameters).forEach(parameter -> {
                boolean havepara=parameter.isAnnotationPresent(Param.class);
                if(havepara){
                    Param p=parameter.getAnnotation(Param.class);
                    String pv=p.value();
                    System.out.println(pv);
                    paraargs.put("pv",args[i[0]]);
                    i[0]++;
                }
            });
            System.out.println(paraargs);
            Arrays.stream(args).forEach((Object arg) ->{
                System.out.println(arg);
            });
        }
        return null;
    }
}
