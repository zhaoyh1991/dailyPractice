package com.zyh.daily.test;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * Created by zhaoyh on 2017/11/2.
 */
public class TestThread {
    public static void main(String[] args) {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long size= mem.getFreePhysicalMemorySize();

        Thread t=new Thread(()->{
        });
        t.start();
        long size2= mem.getFreePhysicalMemorySize();
        System.out.println((size-size2)/1024/1024);
    }

}
