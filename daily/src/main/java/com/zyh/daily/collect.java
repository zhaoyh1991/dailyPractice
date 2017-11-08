package com.zyh.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于集合类的相关操作
 * Created by zhaoyh on 2017/11/8.
 */
public class collect {
    public static void main(String[] args) {
        List<String> lists=new ArrayList<>();
        //列表的添加
        lists.add("a");
        lists.add("b");
        //增强for循环遍历
        for(String s:lists){
            System.out.println(s);
        }
        //普通遍历
        int len=lists.size();
        for(int i=0;i<len;i++){
            System.out.println(lists.get(i));
        }
        //java 8 lambda
        //java8 的stream方式遍历 forEach接收一个Consumer的lambda
        lists.stream().forEach(s-> System.out.println(s));

    }

}
