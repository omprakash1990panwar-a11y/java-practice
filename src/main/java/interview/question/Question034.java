package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question034 {
    public static void main(String[] args) {
        // Flatten employee skill lists. Duplicate skills are retained.
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", Arrays.asList("Java", "Spring Boot")),
                new Employee("Priya", Arrays.asList("MySQL", "Docker")),
                new Employee("Rahul", Arrays.asList("Java", "Kafka"))
        );

        List<String> skills = employees.stream()
                .flatMap(employee -> employee.getSkills().stream())
                .toList();

        System.out.println("Q34 - All employee skills: " + skills);
    }

    static class Employee {
        private final String name;
        private final List<String> skills;

        Employee(String name, List<String> skills) {
            this.name = name;
            this.skills = skills;
        }

        public String getName() {
            return name;
        }

        public List<String> getSkills() {
            return skills;
        }
    }
}
