package com.java8.O_fiftin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		
		// Custom Descending Sorting using Comparator Interface
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(22);
		list.add(76);
		list.add(66);
		list.add(99);
		list.add(100);
		list.add(34);
		System.out.println("Before Sorting " + list);
		Collections.sort(list);
		System.out.println("After defult Sorting " + list);
		Collections.sort(list,new MyComparator());
		System.out.println("After Custome Sorting " + list);
		
	}

}
