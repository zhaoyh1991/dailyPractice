package com.zyh.daily.java8prac;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 构造器引用
 * Created by zhaoyh on 2017/7/3.
 */
public class TestMethodReference {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("zhao","yuan","hua");
        List<Student> students=names.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(students);
    }
}
