package com.java8.A_one;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LambdaTreeSet {

	public static void main(String[] args) {
		
		Comparator<Integer> c = (I,I2)->{
			if (I > I2) {
				return -1;
			} else if (I< I2) {
				return 1;
			} else {

			}
			return 0;
		};
	//	Implemented Lambda call in constructor
	//	Set<Integer> treeSet = new TreeSet<Integer>(c);
	//	Lembda direct call in constructor
		Set<Integer> treeSet = new TreeSet<Integer>((object1,object2)->(object1>object2)?-1:(object1<object2)?1:0);
		treeSet.add(100);
		treeSet.add(4);
		treeSet.add(3);
		treeSet.add(500);
		treeSet.add(204);
		treeSet.add(101);
		System.out.println(treeSet);
	}
}
