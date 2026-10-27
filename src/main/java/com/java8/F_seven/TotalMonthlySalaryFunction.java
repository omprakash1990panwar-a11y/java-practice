package com.java8.F_seven;

import java.util.ArrayList;
import java.util.function.Function;

public class TotalMonthlySalaryFunction {
    public static void main(String[] args) {
        ArrayList<Employee> l = new ArrayList<Employee>();
        populate(l);
        System.out.println(l);

       Function<ArrayList<Employee>, Double> f  = empList ->{
           double total=0;
           for(Employee emp : empList)
           {
               total = total + emp.salary;
           }
           return total;
       };

        System.out.println("The total salary of this month: " + f.apply(l));
    }

    public static void populate(ArrayList<Employee> l) {
        l.add(new Employee("Sunny", 1000));
        l.add(new Employee("Bunny", 2000));
        l.add(new Employee("Chinny", 3000));
        l.add(new Employee("Pinny", 4000));
        l.add(new Employee("Vinny", 5000));
    }
}
