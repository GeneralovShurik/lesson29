package com.company;

public class Cat {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Cat(String name, int age){
        this. name = name;
        this. age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



}
