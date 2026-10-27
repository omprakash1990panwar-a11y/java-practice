package com.java8.E_six;

import java.util.function.Predicate;

public class SoftwareEngineerDegree {
    public static void main(String[] args) {

        SoftwareEngineer[] list = { new SoftwareEngineer("Deepak",60,false),
                                    new SoftwareEngineer("Omy",35,true),
                                    new SoftwareEngineer("Kalpesh",37,true),
                                    new SoftwareEngineer("Indra",40,false),
                                    new SoftwareEngineer("Rahul",60,true)
        };

        Predicate<SoftwareEngineer> allowed =  eng-> eng.age> 18 && eng.isHavingDegree;
        for(SoftwareEngineer eng: list) {
            if(allowed.test(eng)) {
                System.out.println(eng);
            }
        }
    }
}
