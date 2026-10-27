package com.java8.F_seven;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentGradeUsingFunction {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<Student>();
        populate(l);

        Function<Student,String> f = student -> {
            int marks = student.marks;
            if(marks>=80)
                return "A [Distinction]";
            else if (marks>=60) {
                return "B [First Division]";
            }
            else if (marks>=50) {
                return "C [Second Division]";
            }
            else if (marks>=40) {
                return "D [Third Division]";
            }
            else{
                return "Fail";
            }
        };

        Predicate<Student> p = s -> s.marks >= 50;

        for (Student s : l) {
            if (p.test(s)) {
                System.out.println("Student Name: " + s.name);
                System.out.println("Student Marks: " + s.marks);
                System.out.println("Student Grade: " + f.apply(s));
                System.out.println();
            }
        }
    }

    public static void populate(List<Student> l) {
        l.add(new Student("Sunny", 100));
        l.add(new Student("Bunny", 65));
        l.add(new Student("Chinny", 55));
        l.add(new Student("Vinny", 45));
        l.add(new Student("Pinny", 25));
    }


}
