package com.java8.O_fiftin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmplyeeCustomObjectSortingLambda {
	
	int number;
	String name;
	@Override
	public String toString() {
		return "EmplyeeCustomObjectSortingLambda [number=" + number + ", name=" + name + "]";
	}
	public EmplyeeCustomObjectSortingLambda(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}


	public static void main(String args[] ) {
		
		List<EmplyeeCustomObjectSortingLambda> list = new ArrayList<EmplyeeCustomObjectSortingLambda>();
		list.add(new EmplyeeCustomObjectSortingLambda(1,"kamal"));
		list.add(new EmplyeeCustomObjectSortingLambda(2,"Raju"));
		list.add(new EmplyeeCustomObjectSortingLambda(3,"Deepak"));
		list.add(new EmplyeeCustomObjectSortingLambda(4,"Manish"));
		list.add(new EmplyeeCustomObjectSortingLambda(5,"Yogesh"));
		list.add(new EmplyeeCustomObjectSortingLambda(6,"Manakashi"));
		
		Collections.sort(list,(I1,I2)->(I1.number>I2.number)?-1:(I1.number<I2.number)?1:0);
		
		System.out.println(list);
	}
}
