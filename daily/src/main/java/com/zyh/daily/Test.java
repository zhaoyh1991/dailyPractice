package com.zyh.daily;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaoyh on 2017/8/14.
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyMMdd");
        String today=dateFormat.format(new Date());
        System.out.println(today);

    }
}
