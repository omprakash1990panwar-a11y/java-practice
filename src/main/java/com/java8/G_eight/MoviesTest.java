package com.java8.G_eight;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MoviesTest{
public static void main(String[] args) {


    ArrayList<Movie> l = new ArrayList<Movie>();
    populate(l);

    Consumer<Movie> c = m -> {
        System.out.println("Movie Name: " + m.name);
        System.out.print(" Hero: " + m.hero);
        System.out.print("  Heroine: " + m.heroine);
        System.out.println();
    };

    for (Movie m : l) {
        c.accept(m);
    }
}

public static void populate(ArrayList<Movie> l) {
    l.add(new Movie("Bahubali", "Prabhas", "Anushka",null));
    l.add(new Movie("Rayees", "Sharukh", "Sunny",null));
    l.add(new Movie("Dangal", "Ameer", "Ritu",null));
    l.add(new Movie("Sultan", "Salman", "Anushka",null));
}
}
