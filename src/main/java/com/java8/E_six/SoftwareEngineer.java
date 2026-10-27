package com.java8.E_six;

public class SoftwareEngineer {
    String name;
    int age;
    boolean isHavingDegree;

    public SoftwareEngineer(String name, int age, boolean isHavingDegree) {
        this.name = name;
        this.age = age;
        this.isHavingDegree = isHavingDegree;
    }

    @Override
    public String toString() {
        return "SoftwareEngineer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", isHavingDegree=" + isHavingDegree +
                '}';
    }
}
