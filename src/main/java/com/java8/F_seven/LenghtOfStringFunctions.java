package com.java8.F_seven;

import java.util.function.Function;

public class LenghtOfStringFunctions {

    public static void main(String[] args) {
        Function<String,Integer> f = s -> s.length();
        System.out.println(f.apply("Omy"));
        System.out.println(f.apply("Durga"));
        System.out.println(f.apply("Kalpesh"));
    }
}
