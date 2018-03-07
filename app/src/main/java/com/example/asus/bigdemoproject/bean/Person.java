package com.example.asus.bigdemoproject.bean;

/**
 * Created by ASUS on 2017/12/28.
 */

public class Person {
    int img;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "img=" + img +
                ", name='" + name + '\'' +
                '}';
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int img, String name) {
        this.img = img;
        this.name = name;
    }
}
