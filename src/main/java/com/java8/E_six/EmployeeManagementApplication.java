package com.java8.E_six;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeManagementApplication {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("John Doe", "Engineer", 61000.00, "Jaipur"));
        list.add(new Employee("Martin Doe", "Designer", 55000.00, "Kota"));
        list.add(new Employee("Samantha Doe", "Engineer", 45000.00, "Bangalore"));
        list.add(new Employee("Jane Smith", "Manager", 85000.00, "Gurgram"));
        list.add(new Employee("Sam Wilson", "Designer", 68000.00, "Delhi"));
        list.add(new Employee("Emily Davis", "Engineer", 90000.00, "Noida"));
        list.add(new Employee("Mark Johnson", "Scientist", 95000.00, "Bangalore"));

        System.out.println("Engineer Information :");
        Predicate<Employee> p1 = emp -> emp.designation.equals("Engineer");
        display(p1,list);


        System.out.println("Bangalore Employee Information :");
        Predicate<Employee> p2 = emp -> emp.city.equals("Bangalore");
        display(p2,list);


        System.out.println("Employee Salary Less then 50000.00 Information :");
        Predicate<Employee> p3 = emp -> emp.salary<60000.00;
        display(p3,list);


        System.out.println("\nEngineer Salary Less than 90000 Eligible for Hike :");
        display(p3.and(p1),list);

        System.out.println("\nAll Employee Who are Not Engineer ");
        display(p1.negate(),list);

        System.out.println("\nAll Employee Who are Engineer Or from Banglore ");
        display(p1.or(p2),list);


        Predicate<Employee> isCEO=Predicate.isEqual(new Employee("Durga","CEO",30000,"Hyderabad"));
        Employee e1=new Employee("Durga","CEO",30000,"Hyderabad");
        Employee e2=new Employee("Sunny","Manager",20000,"Hyderabad");
        System.out.println(isCEO.test(e1));//true
        System.out.println(isCEO.test(e2));//false

    }

    public static void display(Predicate<Employee> p, List<Employee> list) {

        for(Employee employee : list) {
            if(p.test(employee)) {
                System.out.println(employee);
            }
        }
    }


}
