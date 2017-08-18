package com.zyh.daily.optional;

import com.zyh.daily.java8prac.Student;

import java.util.Optional;

/**
 * Created by zhaoyh on 2017/8/14.
 */
public class TestOptional {
    public static void main(String[] args) {
        //Student student=new Student();
        //student.setName("zyh");
        //student.setAge(25);
        Student student=null;
        Optional<Student> optional=Optional.ofNullable(student);
        Optional<String> opname=optional.map(Student::getName);
        String name=opname.orElse("unknow");
        System.out.println(name);
    }

}
