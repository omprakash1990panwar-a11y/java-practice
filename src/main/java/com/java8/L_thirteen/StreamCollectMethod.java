package com.java8.L_thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Pawan");
        list.add("Ravi Teja");
        list.add("Charan Jeevi");
        list.add("Venkath");
        list.add("Nagaurjun");
        System.out.println(list);

        List<String> list2 = list.stream().filter(obj-> obj.length()> 7).collect(Collectors.toList());
        // This is collect method called on filter                      .collect(Collectors.toList());
        System.out.println(list2);
    }
}
