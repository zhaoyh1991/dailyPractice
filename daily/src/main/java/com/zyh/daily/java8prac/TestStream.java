package com.zyh.daily.java8prac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
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
        }
        List<Student> students1=students.stream().filter(student -> student.getAge()<20)
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());
        System.out.println(students1);

    }
}
