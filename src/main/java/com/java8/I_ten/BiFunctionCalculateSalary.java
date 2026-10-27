package com.java8.I_ten;

import java.util.function.BiFunction;

public class BiFunctionCalculateSalary {

    public static void main(String[] args) {

        BiFunction<Employee, TimeSheet, Double> biFunction = (emp, time) -> emp.dailyWages * time.days;

        Employee emp = new Employee(1,"Deepak",1500,0);
        TimeSheet time = new TimeSheet(101,30);

        System.out.println(biFunction.apply(emp, time));
    }

}
