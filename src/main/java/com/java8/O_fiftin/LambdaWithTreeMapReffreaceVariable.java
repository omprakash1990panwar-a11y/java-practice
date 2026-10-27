package com.java8.O_fiftin;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LambdaWithTreeMapReffreaceVariable {

	public static void main(String[] args) {

		// Custom Sorting by Pass Comparator object in Constructor
		
		Comparator<Integer> c = (I1, I2) -> {
			if (I1 > I2) {
				return -1;
			} else if (I1 < I2) {
				return 1;
			} else {
				return 0;
			}

		};
		
		Map<Integer,String> map = new TreeMap<Integer, String>(c);
		map.put(1, "HP");
		map.put(2, "Dell");
		map.put(3, "Samsung");
		map.put(4, "Asus");
		map.put(5, "Accer");
		System.out.println(map);
	}

}
