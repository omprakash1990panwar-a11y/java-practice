package com.java8.K_twelve;

public class MethodReferanceTest {

    public static void main(String[] args) {

        FunctionalInterfaceMethodReferance i = MethodReferanceTest::m2;
        i.m1();
    }

    public static void m2() {
        System.out.println("Method Referance Test");

    }
}
