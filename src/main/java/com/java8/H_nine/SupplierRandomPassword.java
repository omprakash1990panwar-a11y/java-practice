package com.java8.H_nine;

import java.util.function.Supplier;

public class SupplierRandomPassword {

    public static void main(String[] args) {
        Supplier<String> sup = () -> {

            String symbols ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$@";
            Supplier<Integer> d = () -> (int)(Math.random()*10);
            Supplier<Character> c=()-> symbols.charAt((int)(Math.random()*39));
            StringBuilder pwd = new StringBuilder();
            for(int i = 1; i<=8; i++)
            {
                if(i%2==0)
                {
                    pwd.append(d.get());
                }
                else
                {
                    pwd.append(c.get());
                }

            }
            return pwd.toString();
        };

        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());
    }
}
