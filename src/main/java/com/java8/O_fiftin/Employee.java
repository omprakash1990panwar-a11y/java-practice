package com.java8.O_fiftin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee {
	int number;
	String name;
	@Override
	public String toString() {
		return "EmplyeeCustomObjectSortingLambda [number=" + number + ", name=" + name + "]";
	}
	public Employee(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}


	public static void main(String args[] ) {
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"kamal"));
		list.add(new Employee(2,"Raju"));
		list.add(new Employee(3,"Deepak"));
		list.add(new Employee(4,"Manish"));
		list.add(new Employee(5,"Yogesh"));
		list.add(new Employee(6,"Manakashi"));
		
		Collections.sort(list,(I1,I2)->(I1.number>I2.number)?-1:(I1.number<I2.number)?1:0);
		
		System.out.println(list);
	}

}
