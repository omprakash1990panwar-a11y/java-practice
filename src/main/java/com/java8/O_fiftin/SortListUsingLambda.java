package com.java8.O_fiftin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListUsingLambda {

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(22);
		list.add(76);
		list.add(66);
		list.add(99);
		list.add(100);
		list.add(34);
		System.out.println("Before Sorting " + list);
		
		//Comparator Interface has a single compare method so we can call it using lambda expression
		Comparator<Integer> c = (I,I2)->{
			if (I > I2) {
				return -1;
			} else if (I< I2) {
				return +1;
			} else {
				
			}
			return 0;
		};	
	//	Collections.sort(list, (object1,object2)->(object1>object2)?-1:(object1<object2)?1:0);
	//	System.out.println("After Sorting " + list);
		
		Collections.sort(list, c); 
		System.out.println("After Sorting " + list);
	}

}
