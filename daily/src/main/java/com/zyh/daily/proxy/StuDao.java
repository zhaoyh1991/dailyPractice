package com.zyh.daily.proxy;

import com.zyh.daily.java8prac.Student;

/**
 * Created by zhaoyh on 2017/7/3.
 */
public interface StuDao {
    @Query(sql="select * from student where name=:name")
    Student findStudentByName(@Param("name") String name);
}
