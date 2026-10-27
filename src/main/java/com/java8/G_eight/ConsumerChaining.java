package com.java8.G_eight;

import java.util.function.Consumer;

public class ConsumerChaining {
    public static void main(String[] args) {
        Consumer<Movie> c1 = movie -> {
            System.out.println("Movie is " +movie.name+ "Ready to Release ");
        };

        Consumer<Movie> c2 = movie -> {
            System.out.println("Movie " +movie.name+ "is Just Release and it is :" + movie.result);
        };

        Consumer<Movie> c3 = movie -> {
            System.out.println("Movie " +movie.name+ "Information Storing in the Database\n");
        };

        Consumer<Movie> chainedConsumer = c1.andThen(c2).andThen(c3);

        Movie movie1= new Movie("Bhahubali","Prabash" , "Anushkha" ,"Hit" );

        chainedConsumer.accept(movie1);

        Movie movie2= new Movie("SpiderMan","PeterParker" , "MariGold" ,"Flop" );

        chainedConsumer.accept(movie2);
    }
}
