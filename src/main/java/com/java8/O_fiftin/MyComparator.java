package com.java8.O_fiftin;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

/*	@Override
	public int compare(Integer element1, Integer element2) {
		if (element1 > element2) {
			return -1;
		} else if (element1 < element2) {
			return +1;
		} else {
			return 0;
		}
	}
*/
	@Override
	public int compare(Integer element1, Integer element2) {
		return (element1>element2)?-1:(element1<element2)?+1:0;
	}
}



