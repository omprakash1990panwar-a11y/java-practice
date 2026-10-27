package com.java8.L_thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMinMaxMethod {

        public static void main(String[] args) {
        {
            List<Integer> list = new ArrayList<Integer>();
            list.add(5);
            list.add(100);
            list.add(99);
            list.add(98);
            list.add(85);
            list.add(67);
            list.add(70);
            System.out.println(list);

            // Using comparator
            Integer min = list.stream().min((obj1, obj2) -> obj1.compareTo(obj2)).get();
            System.out.println("Minimun Number :" +min);

            // Using method Referance
            Integer max = list.stream().max(Integer::compareTo).get();
            System.out.println("Maximum Number :" +max);

            Integer minumum  = list.stream().sorted().collect(Collectors.toList()).stream().min(Integer::compareTo).get();
            System.out.println("Minimun Number by defult Sort :" +minumum);

        }
    }

    }

