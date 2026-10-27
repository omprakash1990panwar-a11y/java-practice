package com.java8.loadData;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadData {

    public  Map<String, Map<String, List<String>>> populate() {

        Map<String, Map<String, List<String>>> countryStateCity =
                new HashMap<>();

        Map<String, List<String>> states = new HashMap<>();

        states.put("Rajasthan", Arrays.asList(
                "Jaipur",
                "Jodhpur",
                "Udaipur",
                "Kota"
        ));

        states.put("Maharashtra", Arrays.asList(
                "Mumbai",
                "Pune",
                "Nagpur",
                "Nashik"
        ));

        states.put("Gujarat", Arrays.asList(
                "Ahmedabad",
                "Surat",
                "Vadodara",
                "Rajkot"
        ));

        states.put("Karnataka", Arrays.asList(
                "Bengaluru",
                "Mysuru",
                "Mangaluru",
                "Hubballi"
        ));

        countryStateCity.put("India", states);

        return countryStateCity;
    }



}