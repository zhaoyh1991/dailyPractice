package com.zyh.daily.generic;

/**
 * Created by zhaoyh on 2017/11/16.
 */
public class Student extends People {
    private String clazz;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "clazz='" + clazz + '\'' +
                "} " + super.toString();
    }
}
