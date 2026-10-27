package com.java8.E_six;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEmptyStringAndNull {
    public static void main(String[] args) {
        String names[]={"Durga",null,"Ravi","Shiva",null};
        Predicate<String> p= (String s) -> s!=null && s.length()!=0;
        List<String> list = new ArrayList<String>();
        for(String name : names) {
            if(p.test(name)) {
                list.add(name);
            }
        }
        System.out.println("List of Valid String");
        System.out.println(list);
    }
}
