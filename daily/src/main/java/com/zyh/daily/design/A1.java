package com.zyh.daily.design;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 这种模式的好处是可以将具体的实现解耦出去这里就是将具体获得列表的方式分离出去以后扩展就不用修改A类
 * 只需要新增继承的类就可以扩展出不同的获取数据的方式。
 * Created by zhaoyh on 2017/10/22.
 */
public class A1 extends A {
    @Override
    protected List<String> getList() {
        List<String> lists=new ArrayList<>();
        lists.add("a");
        lists.add("A");
        return lists;
    }
}
