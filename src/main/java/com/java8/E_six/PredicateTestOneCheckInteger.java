package com.java8.E_six;

import java.util.function.Predicate;

public class PredicateTestOneCheckInteger {
    public static void main(String[] args) {

        Predicate<Integer> p=  i-> i>10;
        System.out.println(p.test(5));
        System.out.println(p.test(16));

    }
}
