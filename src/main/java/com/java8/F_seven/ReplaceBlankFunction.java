package com.java8.F_seven;

import java.util.function.Function;

public class ReplaceBlankFunction {
    public static void main(String[] args) {
        String str = "Durga Software Solutions Delhi";

        Function<String,String> f = s-> s.replace(" ","");

        System.out.println(f.apply(str));
    }
}
