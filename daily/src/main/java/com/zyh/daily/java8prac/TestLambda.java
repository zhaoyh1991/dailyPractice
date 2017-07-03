package com.zyh.daily.java8prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
/**
 * Created by zhaoyh on 2017/7/1.
 */
public class TestLambda {
    public static <T>  List<T> filter(List<T> list,Predicate<T> condition){
        List<T> res=new ArrayList<T>();
        for(T t:list){
            if(condition.test(t)){
                res.add(t);
            }
        }
        return res;
    }
    public static <T> void map(List<T> list, Consumer<T> consumer){
        for(T t:list){
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
         List<Student> origin=new ArrayList<>();
         for(int i=0;i<10;i++){
             Student s=new Student();
             s.setAge(i);
             s.setName("name"+i);
             origin.add(s);
         }
         //这里用到了类型推导和lambda表达式
        //行为化参数的好处是可以改变行为带来更好的灵活性和扩展性
        List<Student> students=filter(origin,(stu)->stu.getAge()>5);
        System.out.println(students);
        map(origin,(stu)->stu.setAge(stu.getAge()+1));
        System.out.println(origin);

        origin.sort((s1,s2)->s2.getAge()-s1.getAge());
        System.out.println(origin);

        /**
         * 方法引用分三种情况
         * 1.类的静态方法
         * 2.类的实例方法
         * 3.实例的方法
         */
        List<String > strs= Arrays.asList("a","f","D","J","C");
        strs.sort(String::compareToIgnoreCase);//方法引用2
        System.out.println(strs);
        //复合谓词lambda表达式 negate ! and && or ||
        Predicate<Student> predicate=((student) -> student.getAge()>5);
        List<Student> studentList=filter(origin, predicate.and((student)->student.getName().equals("name6")));
        System.out.println(studentList);

    }

}
