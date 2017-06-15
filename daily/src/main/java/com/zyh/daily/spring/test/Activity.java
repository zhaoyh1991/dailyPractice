package com.zyh.daily.spring.test;

/**
 * Created by zhaoyh on 2017/6/14.
 */
public class Activity {
    private People host;//
    private String game="闹着玩的";
    public People getHost() {
        return host;
    }

    public void setHost(People host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "host=" + host +
                ", game='" + game + '\'' +
                '}';
    }
}
