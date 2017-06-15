package com.zyh.daily.spring.test;

/**
 * Created by zhaoyh on 2017/6/14.
 */
public class People{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}
