package com.zyh.daily.proxy;

/**
 * Created by zhaoyh on 2017/7/3.
 */
public class Test {
    public static void main(String[] args) {
       StuDao stuDao= (StuDao) Context.getSession(StuDao.class);
       stuDao.findStudentByName("zhaoyuanhua");
    }
}
