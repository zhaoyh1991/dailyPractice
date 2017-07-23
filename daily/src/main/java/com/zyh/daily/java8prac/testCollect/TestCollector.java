package com.zyh.daily.java8prac.testCollect;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Created by zhaoyh on 2017/7/23.
 */
public class TestCollector {
    public static void main(String[] args) {
        List<Menu> menus=new ArrayList<>();
        Menu menu1=new Menu("met","chicken",111);
        menus.add(menu1);
        Menu menu2=new Menu("met","poke",222);
        menus.add(menu2);
        Menu menu3=new Menu("met","fish",100);
        menus.add(menu3);
        Menu menu4=new Menu("veg","cabbage",10);
        menus.add(menu4);
        Menu menu5=new Menu("veg","potato",20);
        menus.add(menu5);
        //collect to set
        Set<Menu> set= menus.stream().collect(toSet());
        System.out.println(set);
        //group by
        Map<String,List<Menu>> typem= menus.stream().collect(groupingBy(Menu::getType));
        System.out.println(typem);
        //part by
        Map<Boolean,List<Menu>> partM= menus.stream().collect(partitioningBy(m->m.getCal()>100));
        System.out.println(partM);
        //my self collector
        Integer totalnum= menus.parallelStream().collect(new MyCountCollector());
        System.out.println("一共有"+totalnum+"个元素");
        //down stream
        Map<String, Long> ds= menus.stream().collect(groupingBy(
                (Menu m)->{
                    if(m.getCal()>200){
                        return  "high";
                    }else{
                        return "comm";
                    }
                },counting()
        ));
        System.out.println(ds);

    }
}
