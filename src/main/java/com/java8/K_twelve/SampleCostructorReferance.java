package com.java8.K_twelve;

public class SampleCostructorReferance {

    private String name;
    private String id;

    public SampleCostructorReferance() {
        System.out.println("Default constructor called");
    }

    public SampleCostructorReferance(String name, String id) {
        this.name = name;
        this.id = id;
        System.out.println("Parameterized constructor called with Name: " + name + " and ID: " + id);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}
