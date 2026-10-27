package com.java8.O_fiftin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeImpLambda {

	public static void main(String[] args) {
		
		Comparator<Employee> c = (emp, emp2)->{
			if (emp.number > emp2.number) {
				return -1;
			} else if (emp.number < emp.number) {
				return 1;
			} else {
				
			}
			return 0;
		};	

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"kamal"));
		list.add(new Employee(2,"Raju"));
		list.add(new Employee(3,"Deepak"));
		list.add(new Employee(4,"Manish"));
		list.add(new Employee(5,"Yogesh"));
		list.add(new Employee(6,"Manakashi"));
		
		Collections.sort(list,c);
		
		System.out.println(list);
	}

}
