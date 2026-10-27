package com.java8.F_seven;

import java.util.function.Function;

public class BlankSpaceInString {
    public static void main(String[] args) {
        String str = "This is a blank string";
        Function<String, Integer> f = s -> s.length()
                - s.replace(" ", "").length() ;
        System.out.println(f.apply(str));
        }

}
