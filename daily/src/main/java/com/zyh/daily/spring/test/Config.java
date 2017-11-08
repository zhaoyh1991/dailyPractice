package com.zyh.daily.spring.test;

import com.zyh.daily.spring.MyBean;

/**
 *
 * 这里在模拟配置文件
 * Created by zhaoyh on 2017/6/14.
 */
public class Config {
    @MyBean(name="people")
    public People getPeople(){
        People people=new People();
        people.setName("zhaoyuanhua");
        return people;
    }

    @MyBean(name="activity")
    public Activity another(@MyBean(name="people") People people){
        Activity activity=new Activity();
        activity.setHost(people);
        return activity;
    }

}
