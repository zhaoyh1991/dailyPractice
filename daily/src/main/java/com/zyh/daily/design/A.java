package com.zyh.daily.design;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * 举例说明一种设计的方式抽象类给出骨架方法子类给出具体实现
 * Created by zhaoyh on 2017/10/22.
 */
public abstract class A {
    public List<String> choose(Predicate<String> predicate){
        List<String> list=getList();
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    protected abstract List<String> getList();


}
