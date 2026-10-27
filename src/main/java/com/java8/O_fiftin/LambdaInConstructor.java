package com.java8.O_fiftin;

import java.util.Set;
import java.util.TreeSet;

public class LambdaInConstructor {

	public static void main(String[] args) {

		//	Lembda direct call in constructor for custom descending sorting.
		
		Set<Integer> treeSet = new TreeSet<Integer>((I,I2)->(I>I2)?-1:(I<I2)?1:0);
		treeSet.add(100);
		treeSet.add(4);
		treeSet.add(3);
		treeSet.add(500);
		treeSet.add(204);
		treeSet.add(101);
		System.out.println(treeSet);

	}

}
