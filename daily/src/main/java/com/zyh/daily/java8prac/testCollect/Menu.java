package com.zyh.daily.java8prac.testCollect;

/**
 * Created by zhaoyh on 2017/7/23.
 */
public class Menu {
    private String type;
    private String name;
    private Integer cal;

    public Menu() {
    }

    public Menu(String type, String name, Integer cal) {
        this.type = type;
        this.name = name;
        this.cal = cal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCal() {
        return cal;
    }

    public void setCal(Integer cal) {
        this.cal = cal;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                '}';
    }
}
