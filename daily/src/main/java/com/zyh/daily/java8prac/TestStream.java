package com.zyh.daily.java8prac;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * stream
 * Created by zhaoyh on 2017/7/2.
 */
public class TestStream {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        Random random=new Random();
        for(int i=0;i<100;i++){
            Student student=new Student();
            student.setAge(random.nextInt(30));
            student.setName("name"+i);
            students.add(student);

        }
        List<Student> students1=students.stream().filter(student -> student.getAge()<20)
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());
        System.out.println(students1);

        Consumer<String> consumer=(String s)-> System.out.println(s);
        consumer.accept("aaa");

       Map a= students.stream().collect(Collectors.groupingBy(student->{
            int age=student.getAge();
            if(age<10){
                return "child";
            }else if(age<20){
                return "young";
            }else {
                return "old";
            }
        }));
        System.out.println(a);


    }
}
