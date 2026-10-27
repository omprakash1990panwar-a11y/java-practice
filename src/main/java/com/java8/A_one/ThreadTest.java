package com.java8.A_one;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Running child thread No." + i);
			}
		};
		Thread threadreff = new Thread(r);
		threadreff.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Running Main thread No." + i);
		}
		
		Thread threadreff2 = new Thread( () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Running child2 thread No." + i);
			}
		});
		threadreff2.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Running Main2 thread No." + i);
		}
	}
}
