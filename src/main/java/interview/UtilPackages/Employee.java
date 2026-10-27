
package interview.UtilPackages;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Employee {

    private String name;
    private double salary;
    private List<String> skills;
    private String skill;
    private int id;
    private String department;
    private LocalDate date;
    private String email;
    private String jobTitle;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    // Constructor for Day07StreamPractice
    public Employee(int id, String name, String department,
                    double salary, LocalDate date) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.date = date;
    }

    public Employee(String name, double salary, List<String> skills,
                    int id, String department) {
        this.name = name;
        this.salary = salary;
        this.skills = skills;
        this.id = id;
        this.department = department;
    }

    public Employee(String name, String department, int salary, String email) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public Employee(String name, String department, String skill, double salary)
    {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skill=skill;
    }
}
