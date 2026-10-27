package com.java8.E_six;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class PredicateTestTwoCheckString {
    public static void main(String[] args) {

            Predicate<Collection> predi = (collections) -> collections.isEmpty();
     ///    Predicate<List<String>> predi = Collection::isEmpty;
            ArrayList<String> list = new ArrayList<String>();
            list.add("a");
            System.out.println(predi.test(list));  //false

        ArrayList<String> list2 = new ArrayList<String>();
        System.out.println(predi.test(list2)); //true

    }

}
