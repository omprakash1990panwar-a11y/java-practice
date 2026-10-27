package com.java8.L_thirteen;

import java.util.ArrayList;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;


public class ParallelStreamDemo {
    public static void main(String[] args) throws InterruptedException {

        String filePath = "C:\\Users\\Hp\\Downloads\\indian_student_records.csv";


        List<Student> students = readStudentsFromCSV(filePath);
        //Using Steam sequentially
        students.stream().filter(stu -> stu.getScore() > 0 ).forEach(System.out::println);



     //   Using Parallel Stream
        students.parallelStream().filter(stu -> stu.getScore() > 0 ).forEach(System.out::println);

        students.stream().parallel().filter(stu -> stu.getScore() > 0 ).forEach(System.out::println);
    }


    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                float score = Float.parseFloat(values[1]);
                students.add(new Student(name, score));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    Function<String,List<Student>> studentList =  filePath -> {
        List<Student> students = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                float score = Float.parseFloat(values[1]);
                students.add(new Student(name, score));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    };

}


