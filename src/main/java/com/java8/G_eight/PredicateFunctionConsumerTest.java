package com.java8.G_eight;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFunctionConsumerTest {

    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<Student>();
        populate(studentsList);

        Predicate<Student> p = s-> s.marks>=55;

        Function<Student, String> fun = s-> {
            if(s.marks>=80) {
                return "A [Dictinction]";
            }
            else if(s.marks>=60) {
                return "B [First Division]";
            }
            else if(s.marks>=50) {
                return "C [Second Division] ";
            }
            else if(s.marks>=36) {
                return "D [Third Division]";
            }
            else
            {
                return "Faild";
            }
        };

        Consumer<Student> con = stu -> {
            System.out.println("Studen Name : " + stu.name);
            System.out.println("Studen Marks : " + stu.marks);
            System.out.println("Studen Grade: : " + fun.apply(stu));
        };

    for(Student local :studentsList )
    {
        if(p.test(local))
        {
            con.accept(local);
        }

    }
    }

    public static void populate(List<Student> stuList)
    {
        stuList.add(new Student("Sunny", 100));
        stuList.add(new Student("Bunny", 65));
        stuList.add(new Student("Chinny", 55));
        stuList.add(new Student("Vinny", 45));
        stuList.add(new Student("Pinny", 25));

    }
}
