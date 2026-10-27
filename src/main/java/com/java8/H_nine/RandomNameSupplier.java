package com.java8.H_nine;

import java.util.function.Supplier;

public class RandomNameSupplier {

    public static void main(String[] args) {
        Supplier<String> nameSupplier = () -> {

            String[] s1 = {"Sunny","Bunny","Chinny","Pinny"};
            int x = (int)(Math.random()*4);
            return s1[x];
    };

    System.out.println(nameSupplier.get());}
}
