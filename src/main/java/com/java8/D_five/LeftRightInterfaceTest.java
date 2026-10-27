package com.java8.D_five;

public class LeftRightInterfaceTest implements InterfaceLeft, InterfaceRight {


    // m1 method is overridden
    public void m1()
    {
      //   System.out.println("m1 method is overridden ");
      //   InterfaceLeft.super.m1();
         InterfaceRight.super.m1();
    }

    public static void main(String[] args) {

        LeftRightInterfaceTest test = new LeftRightInterfaceTest();
        test.m1();
    }
}
