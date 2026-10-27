package com.java8.L_thirteen;

import com.java8.loadData.LoadData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static void main(String[] args) {

        List<List<String>> listOfList = new ArrayList<>();


        Predicate<String> predicate = s -> s.contains("Panwar");

        listOfList.add(Arrays.asList("Omp_Panwar", "Prakash_Panwar", "Ramesh", "Pawaan"));
        listOfList.add(Arrays.asList("Anita", "Rajshree", "Ashwin", "Debesh"));
        listOfList.add(Arrays.asList("Kamal_Singh", "Praveena_Khanna", "Anup_Gupta", "Shanumgam_Veket"));
        listOfList.add(Arrays.asList("Anita_Panwar", "Rajshree_Chouhan", "Ashwin_Singh", "Debesh_Kumar"));


        /*********************************     List of List Java 1.7 Old Approach  ****************************/

        List<List<String>> listOfList3 = new ArrayList<List<String>>();
        for (List<String> list : listOfList) {
            List<String> newList = new ArrayList<String>();
            for (String string : list) {
                newList.add(string.replace("_", "*"));
            }
            listOfList3.add(newList);
        }
        System.out.println("List of List with java 1.7 " + listOfList);
        System.out.println();
        /** ###################################################################################################**/


        /*********************************     List of List Java 1.8 New Approach  ****************************/
        listOfList = new ArrayList<>(listOfList.stream()
                .map(list -> {
                    return list.stream()
                            .map(string -> {
                                return string.replace("_", "*");
                            })
                            .collect(Collectors.toList());
                })
                .collect(Collectors.toList()));

        System.out.println("List of List with java 1.8 " + listOfList);

        /*********************************     List of List Java 1.8 New Approach  ****************************/


        LoadData loadData = new LoadData();
        loadData.populate().entrySet()
                .stream()
                .map(countryMapObj -> {
                    // Country
                    System.out.println("Country : " + countryMapObj.getKey());
                    countryMapObj.getValue()
                            .entrySet()
                            .stream()
                            .map(stateMapObj -> {
                                // State
                                System.out.println("State   : " + stateMapObj.getKey());
                                stateMapObj.getValue()
                                        .stream()
                                        .map(city -> {
                                            // City
                                            System.out.println("City    : " + city);
                                            return city.toUpperCase();
                                        })
                                        .toList();
                                return stateMapObj;
                            })
                            .toList();
                    return countryMapObj;
                })
                .toList();


        /*********************************     List of List Java 1.8 New Approach  ****************************/

        /*********************************     List of List Java 1.7 New Approach  ****************************/

        LoadData loadData2 = new LoadData();
        Map<String, Map<String, List<String>>> countryMap2 = loadData2.populate();

        for (Map.Entry<String, Map<String, List<String>>> countryEntry : countryMap2.entrySet()) {
            // Country
            System.out.println("Country : " + countryEntry.getKey());
            Map<String, List<String>> stateMap = countryEntry.getValue();
            for (Map.Entry<String, List<String>> stateEntry: stateMap.entrySet()) {
                // State
                System.out.println("State   : " + stateEntry.getKey());
                List<String> cities = stateEntry.getValue();
                for (String city : cities) {
                    // City
                    System.out.println("City    : " + city);
                    String upperCaseCity =city.toUpperCase();
                    System.out.println("Upper   : " + upperCaseCity);
                }
            }
        }
    }



}
