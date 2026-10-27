package com.java8.E_six;

import java.util.function.Predicate;

public class PredicateNameStartWithK {

    public static void main(String[] args) {
        String[]names = {"Sunny","Kajal","Malika","Katriana","Kajal"};
        Predicate<String> p1 = s -> s.startsWith("K");

        for(String localK : names)
        {
           if (p1.test(localK)){
                System.out.println(localK);}
        }
    }
}
