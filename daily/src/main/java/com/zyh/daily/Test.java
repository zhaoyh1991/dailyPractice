package com.zyh.daily;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.*;

/**
 * Created by zhaoyh on 2017/8/14.
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyMMdd");
        String today=dateFormat.format(new Date());
        System.out.println(today);

        BinaryOperator<Integer> f=(x,y)->x+y;
        int a=f.apply(1,2);
        IntBinaryOperator c=(x,y)->x+y;

        test(1,b->b%2==0);
        test(5,d->d>4);

    }
    public static void test(int a,Predicate<Integer> predicate){
        if(predicate.test(a)){
            System.out.println(a+" sssss");
        }
    }



}
