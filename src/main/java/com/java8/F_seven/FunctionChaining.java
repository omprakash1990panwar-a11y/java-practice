package com.java8.F_seven;

import java.util.function.Function;

public class FunctionChaining {
    public static void main(String[] args) {
        Function<String,String> f1 = s-> s.toUpperCase();
        Function<String,String> f2 = s-> s.substring(0,9);
        System.out.println(f1.apply("aishwaryaAbhi"));
        System.out.println(f2.apply("aishwaryaAbhi"));

        System.out.println("The Result of f1.andThen(f2) : "+f1.andThen(f2).apply("aishwaryaAbhi"));
        System.out.println("The Result of f1.compose(f2) : "+f1.compose(f2).apply("aishwaryaAbhi"));
    }
}
