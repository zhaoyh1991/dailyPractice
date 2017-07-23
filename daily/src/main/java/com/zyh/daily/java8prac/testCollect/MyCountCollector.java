package com.zyh.daily.java8prac.testCollect;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by zhaoyh on 2017/7/23.
 */
public class MyCountCollector implements Collector<Menu,List<Menu>,Integer> {
    @Override
    public Supplier<List<Menu>> supplier() {
        return ()->new ArrayList<>();
    }

    @Override
    public BiConsumer<List<Menu>, Menu> accumulator() {
        return (list,menu)->list.add(menu);
    }

    @Override
    public BinaryOperator<List<Menu>> combiner() {
        return (list1,list2)->{
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Menu>, Integer> finisher() {
        return List::size;
    }

    @Override
    public Set<Characteristics> characteristics() {//这个也必须实现
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT));
    }
}
