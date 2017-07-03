package com.zyh.daily.algr;

import java.util.Random;

/**
 * 蒙特卡洛方法计算pi
 * 因为落在四分之一圆的点的概率大致等于π/4
 *
 * Created by zhaoyh on 2017/7/3.
 */
public class CalPi {
    public static void main(String[] args) {
        Random random=new Random();
        int total=1000,inCircle=0;
        for(int i=0;i<total;i++){
            float x=random.nextFloat();
            float y=random.nextFloat();
            if(Math.pow(x,2)+Math.pow(y,2)<=1){
                inCircle+=1;
            }
        }
        double pi= 4*(inCircle*1.0/total);
        System.out.println(pi);
    }

}
