package com.java8.L_thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamForEachMethod {
    public static void main(String[] args) {
        {
            List<String> list = new ArrayList<String>();
            list.add("Pawan");
            list.add("Ravi Teja");
            list.add("Charan Jeevi");
            list.add("Venkath");
            list.add("Nagaurjun");
            list.add("Ravi");
            list.add("Karan");
            list.add("Akash");
            list.add("Babita");
            list.add("Zumman Ram");
            System.out.println(list);

            List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
           // System.out.println(sortedList);

            // With ForEach using Lambda
            sortedList.stream().forEach(obj -> System.out.println(obj));

            // With ForEach using Method Referance
            sortedList.stream().forEach(System.out::println);

            // With ForEach using Method Referance
            sortedList.forEach(System.out::println);

        }
    }
}
