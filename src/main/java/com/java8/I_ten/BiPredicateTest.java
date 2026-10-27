package com.java8.I_ten;

import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main(String[] args) {

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a+b)%2 == 0;
        System.out.println(biPredicate.test(15, 20));
    }
}
