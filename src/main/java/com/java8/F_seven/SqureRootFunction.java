package com.java8.F_seven;

import java.util.function.Function;

public class SqureRootFunction {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x * x;
        System.out.println(f.apply(5));
        System.out.println(f.apply(10));
    }
}
