package com.java8.F_seven;

import java.util.function.Function;

public class IdenitityMethod {
    public static void main(String[] args) {

        Function<String,String> f1 = Function.identity();

        String s2 = f1.apply("hello");

        System.out.println(s2);
    }
}
