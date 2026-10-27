package com.java8.F_seven;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class SalaryIncrementUsingPredicateFuncation {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();
        populate(empList);
        System.out.println("Before Increment Salaries");
        System.out.println(empList);

        Predicate<Employee> p = localEmp -> localEmp.salary<3500;

        Function<Employee,Employee> f = localEmp->{
          localEmp.salary = localEmp.salary+2500;
          return localEmp;
        };

        System.out.println("After Increment Salaries");
        ArrayList<Employee> l2 = new ArrayList<Employee>();
        for(Employee emp : empList)
        {
            if(p.test(emp))
            {
                l2.add(f.apply(emp));
            }
        }

        System.out.println(l2);
    }

    public static void populate(ArrayList<Employee> emp) {
        emp.add(new Employee("Ramesh", 2500));
        emp.add(new Employee("Mahesh", 2000.00));
        emp.add(new Employee("Mukesh", 3600.00));
        emp.add(new Employee("Durga",4000.00));
        emp.add(new Employee("Kiran", 6000.00));
        emp.add(new Employee("Roshini", 1000.00));
        emp.add(new Employee("Kamala", 1500.00));
    }
}
