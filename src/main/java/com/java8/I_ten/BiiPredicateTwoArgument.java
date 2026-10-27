package com.java8.I_ten;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class BiiPredicateTwoArgument {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        BiFunction<String,Integer,Student> biFun =  (name, roll) -> new Student(name, roll);
        list.add(biFun.apply("Rajkumar", 1));
        list.add(biFun.apply("Omy", 2));
        list.add(biFun.apply("Ramesh", 3));

        for(Student stu: list)
        {
            System.out.println(stu);
        }
    }


}
