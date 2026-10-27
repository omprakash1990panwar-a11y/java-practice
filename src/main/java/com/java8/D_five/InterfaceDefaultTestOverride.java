package com.java8.D_five;


// Default Method inside an Interface Example With  Override

public class InterfaceDefaultTestOverride implements DefaultMethodInterfacee {

    public void m1()
    {
        System.out.println("defaultMethod Interfacee m1() Method overridden");
    }


    public static void main(String[] args) {

        InterfaceDefaultTestOverride obj = new InterfaceDefaultTestOverride();
        obj.m1();
    }
}
