package com.zyh.daily.java8prac.testForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by zhaoyh on 2017/7/23.
 */
public class CalSum extends RecursiveTask<Long> {
    private long[]  nums;
    private int start;
    private int end;
    public static final int THREAD_HOLD=1_000;

    public CalSum(long[] nums) {
        this(nums,0,nums.length);
    }

    public CalSum(long[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int len=end-start;
        if (len<=THREAD_HOLD){
            return calseq(nums,start,end);
        }
        CalSum left=new CalSum(nums,start,start+len/2);
        left.fork();//利用另外一个线程执行这个任务
        CalSum right=new CalSum(nums,start+len/2,end);
        Long rres=right.compute();//同步执行这个任务
        Long lres=left.join();//读取第一个任务的结果如果没有完成则等待
        return rres+lres;//合并结果返回
    }

    private long calseq(long[] nums, int start, int end) {
        long sum=0;
        for (int i=start;i<end;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
