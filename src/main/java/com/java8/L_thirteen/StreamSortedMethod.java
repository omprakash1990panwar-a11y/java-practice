package com.java8.L_thirteen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortedMethod {

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
            System.out.println(sortedList);

          //  Using lambda Descending order
            List<String> customSortingColonOperatorMethodReff = list.stream().sorted(String::compareTo).collect(Collectors.toList());
            System.out.println(customSortingColonOperatorMethodReff);

            //  Using lambda Descending order
            List<String> customSorting = list.stream().sorted((obj1,obj2)->obj2.compareTo(obj1)).collect(Collectors.toList());
            System.out.println(customSorting);

            //  Using Comparator Revers Method
            List<String> customSortingCompRevers = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            System.out.println(customSortingCompRevers);
        }
    }

    }


