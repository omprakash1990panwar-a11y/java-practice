package com.java8.L_thirteen;

public class Student{

    private String name;

    private float score;
    

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }

    // Getters
    public String getName() { return name; }

    public float getScore() { return score; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
