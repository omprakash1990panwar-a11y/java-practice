package com.java8.O_fiftin;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LambdaTreeSet {

	public static void main(String[] args) {
		
		
//		Custom Descending Sorting  using Lambda method
		
		Comparator<Integer> c = (I,I2)->{
			if (I > I2) {
				return -1;
			} else if (I< I2) {
				return 1;
			} else {
				
			}
			return 0;
		};	

		Set<Integer> treeSet = new TreeSet<Integer>(c);
		treeSet.add(100);
		treeSet.add(4);
		treeSet.add(3);
		treeSet.add(500);
		treeSet.add(204);
		treeSet.add(101);
		System.out.println(treeSet);
	}
}
