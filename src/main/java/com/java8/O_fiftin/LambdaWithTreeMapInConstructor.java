package com.java8.O_fiftin;

import java.util.Map;
import java.util.TreeMap;

public class LambdaWithTreeMapInConstructor {

	public static void main(String[] args) {
		
		// Custom Sorting Lambda passing in TreeMapcConstructor
		
		Map<Integer,String> map = new TreeMap<Integer, String>((I1,I2)->(I1>I2)?-1:(I1<I2)?1:0);
		map.put(1, "HP");
		map.put(2, "Dell");
		map.put(3, "Samsung");
		map.put(4, "Asus");
		map.put(5, "Accer");
		System.out.println(map);

	}

}
