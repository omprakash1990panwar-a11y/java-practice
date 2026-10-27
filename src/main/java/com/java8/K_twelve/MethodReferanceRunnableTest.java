package com.java8.K_twelve;

public class MethodReferanceRunnableTest {

    public  void m2() {
        for(int i=1;i<=10;i++) {
            System.out.println("Child Thread "+i);
        }
    }

    public static void main(String[] args) {

        MethodReferanceRunnableTest mrt = new MethodReferanceRunnableTest();
        Runnable r = mrt::m2;
        Thread thread = new Thread(r);
        thread.start();

        for(int i=1;i<=10;i++) {
            System.out.println("Main Thread" + i);
        }
    }


}
