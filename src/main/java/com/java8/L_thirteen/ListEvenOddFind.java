package com.java8.L_thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListEvenOddFind {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= 50; i++) {
            list.add(i);
        }

//      With Java 1.7
//        List<Integer> list1 = new ArrayList<Integer>();
//        for( Integer item : list)
//        {
//                if(item%2==0)
//                {
//                    list1.add(item);
//                }
//        }
//        System.out.println(list1);



     //   list.forEach(System.out::println);



/*        list.stream().forEach(str-> System.out.println(str));

        list.forEach(System.out::println);*/



      //  list.stream().filter(arg -> arg%2==0).forEach(System.out::println);

        List<Integer> list2 = list.stream().filter(str-> !(str%2==0)).collect(Collectors.toList());


           System.out.println(list2);

    }
}
