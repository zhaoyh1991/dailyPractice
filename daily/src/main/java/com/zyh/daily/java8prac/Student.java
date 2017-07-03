package com.zyh.daily.java8prac;

/**
 * Created by zhaoyh on 2017/7/1.
 */
public class Student {
    private String name;
    private Integer age=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
