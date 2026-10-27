package com.java8.E_six;

import java.util.function.Predicate;

public class PredicateJoiningTest {

    public static void main(String[] args) {

    int []intArray = {0,5,10,15,20,25,30};

    Predicate<Integer> p1 = i-> i>10;
    Predicate<Integer> p2 = i ->  i% 2 == 0;

    System.out.println("The Numbers greater then 10 are");
    m1(p1,intArray);

    System.out.println("The Even Number Are :");
    m1(p2,intArray);

    System.out.println("The Numbers are not greater then 10 :");
    m1(p1.negate(),intArray);

    System.out.println("The Number Greater than 10 and Even Number Are :");
    m1(p1.and(p2),intArray);

    System.out.println("The Number Greater than 10 and Even Number Are :");
    m1(p2.or(p2),intArray);

    }


    public static void m1(Predicate<Integer> p, int[] intArray)
    {
        for(int local : intArray)
        {
            if(p.test(local))
            {
                System.out.println(local);
            }
        }
    }

}
