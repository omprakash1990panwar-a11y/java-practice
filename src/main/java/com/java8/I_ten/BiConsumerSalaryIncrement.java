package com.java8.I_ten;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class BiConsumerSalaryIncrement {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        populate(employees);
        BiConsumer<Employee,Double> biCon = (emp,incr)->{
            emp.salary += incr;
        };

        for(Employee e:employees)
        {
            biCon.accept(e,5000.0);
        }

        for(Employee e:employees)
        {
            System.out.println("Employe Name : = "+e.empName);
            System.out.println("Employe Salary : = "+e.salary);
        }
    }

    public static void populate(ArrayList<Employee> empList) {

        empList.add(new Employee(1,"Ramesh",1500,5000));
        empList.add(new Employee(2,"Ramesh",1500,17000));
        empList.add(new Employee(3,"Ramesh",1500,25000));
        empList.add(new Employee(4,"Ramesh",1500,50000));
    }
}
