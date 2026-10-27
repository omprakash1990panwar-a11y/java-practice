package com.java8.D_five;

public class StaticMethodInsideInterfaceTest  implements StaticMethodInsideInterface {

    public static void main(String[] args) {

        StaticMethodInsideInterfaceTest t = new StaticMethodInsideInterfaceTest();

     //   m1(); compile time error
     //   t.m1(); compile time error
     // StaticMethodInsideInterface.m1();    compile time error

        StaticMethodInsideInterface.m1();
    }
}
