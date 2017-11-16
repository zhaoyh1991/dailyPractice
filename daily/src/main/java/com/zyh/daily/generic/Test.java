package com.zyh.daily.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyh on 2017/11/16.
 */
public class Test{
    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        //这种写法是错误的泛型是不存在继承的关系的一个String的list并不是一个Object的list
        //List<Object> list2=list1;
        List<?> list2=new ArrayList<>();
        //这也是不对的因为除了null其他类型都不是?的子类型
        //list2.add("1");
        List<People> peopleList=new ArrayList<>();
        Student student=new Student();
        student.setClazz("一班");
        student.setAge(26);
        student.setName("zhaoyh");
        peopleList.add(student);//泛型可以添加子类型

        List<Student> stus=new ArrayList<>();
        stus.add(student);

        print(peopleList);
        print(stus);

        List<Object> objects=new ArrayList<>();
        //print(objects);

        //结论 extends用来读取数据因为你不知道具体是哪一种子类所以无法存但是你知道是什么类的子类所以可以读取
        //super只能用来存数据因为你不知道具体的超类所以读出来只能用object接收，但是你知道可以存什么


    }

    //ce
    public static void print(List<? extends  People> objs){
        for(People p:objs){
            System.out.println(p.toString());
        }
    }


}
