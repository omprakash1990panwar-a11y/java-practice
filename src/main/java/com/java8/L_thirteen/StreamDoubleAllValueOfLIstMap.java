package com.java8.L_thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDoubleAllValueOfLIstMap {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);


//        ArrayList<Integer> list2 = new ArrayList<>();
//        for(Integer i : list)
//        {
//            list2.add(i*2);
//        }
//        System.out.println(list2);

        List<Integer> list3 = list.stream().map(obj->obj*2).collect(Collectors.toList());
        System.out.println(list3);
    }

}
