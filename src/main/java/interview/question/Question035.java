package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question035 {
    public static void main(String[] args) {
        // Find all unique employee skills.
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", Arrays.asList("Java", "Spring Boot", "MySQL")),
                new Employee("Priya", Arrays.asList("Java", "Docker", "MySQL")),
                new Employee("Rahul", Arrays.asList("Java", "Kafka", "Spring Boot")),
                new Employee("Neha", Arrays.asList("Docker", "AWS", "Kafka"))
        );

        List<String> uniqueSkills = employees.stream()
                .flatMap(Skills -> Skills.getSkills().stream())
                .distinct()
                .toList();

        System.out.println("Q35 - Unique employee skills: " + uniqueSkills);
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
