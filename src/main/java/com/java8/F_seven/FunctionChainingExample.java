package com.java8.F_seven;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionChainingExample {
    public static void main(String[] args) {
        Function<String,String> f1 = s-> s.toLowerCase();
        Function<String,String> f2 = s -> s.substring(0,5);

        System.out.println("Enter the user Name");
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();

        System.out.println("Enter Password");
        String pass = sc.nextLine();

        if(f1.andThen(f2).apply(user).equals("ompra") && pass.equals("Passcode"))
        {
            System.out.println("Valid User");
        }
        else
        {
            System.out.println("InValid User");
        }
    }
}
