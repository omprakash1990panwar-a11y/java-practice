package com.java8.A_one;

public class LambdaTestClass {

	public static void main(String[] args) {
	
		LambdaTest reff = (a,b)->  {
		System.out.println("method called");
		return a+b;
		};
		System.out.println(reff.sumOfTwo(10, 20));
		System.out.println(reff.sumOfTwo(105, 201));
	}
}
