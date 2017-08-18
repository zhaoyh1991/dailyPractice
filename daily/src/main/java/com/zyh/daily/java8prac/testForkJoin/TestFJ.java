package com.zyh.daily.java8prac.testForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 *
 * 尝试forkjoin
 * Created by zhaoyh on 2017/7/23.
 */
public class TestFJ {
    public static void main(String[] args) {
        long n=1000000;//规模会影响效率这里只有百万级别的时候不如普通版本
        speedTest(TestFJ::cal,n);
        speedTest(TestFJ::cal2,n);
    }

    /**
     * lambda 的行为参数化了这里的代码更加的通用了我们不必在用策略模式写一大堆的代码了哈哈哈
     * @param function 一个接收数组返回long的函数
     * @param n 数字
     */
    public static void speedTest(Function<long[],Long> function,long n){
        long[] nums= LongStream.rangeClosed(0,n).toArray();
        long cost=Long.MAX_VALUE;
        for(int i=0;i<10;i++){
            long start=System.nanoTime();
            long res=function.apply(nums);
            //System.out.println(res);
            long end=System.nanoTime();
            long thistimecost=end-start;
            if(thistimecost<cost){
                cost=thistimecost;
            }
        }
        System.out.println("this function cost "+cost+" nano");
    }
    public static Long cal(long[] nums){
        ForkJoinTask<Long> task=new CalSum(nums);
        return new ForkJoinPool().invoke(task);
    }

    public static Long cal2(long[] nums){
        int length=nums.length;
        long sum=0;
        for(int i=0;i<length;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
