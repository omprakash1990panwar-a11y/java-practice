package interview.practice;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day6 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Amit",
                "Neha", "Rahul", "Amit", "Neha"
        );

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000, Arrays.asList("Java", "Spring Boot"), 101, "IT"),
                new Employee("Priya", 60000, Arrays.asList("Recruitment", "Communication"), 102, "HR"),
                new Employee("Rahul", 55000, Arrays.asList("Java", "Microservices"), 103, "IT"),
                new Employee("Neha", 70000, Arrays.asList("Accounting", "Excel"), 104, "Finance"),
                new Employee("Amit", 65000, Arrays.asList("Sales", "Negotiation"), 105, "Sales")
        );

        // 051. Collect stream elements into a List
        List<String> collectedList = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());

        System.out.println("051. Collect into List:\n" + collectedList);

        // 052. Collect unique elements into a Set
        Set<String> uniqueNames = names.stream()
                .collect(Collectors.toSet());

        System.out.println("\n052. Collect unique elements into Set:\n" + uniqueNames);

        // 053. Convert a List into a Map using toMap() with character count in each name
        List<String> simpleNames = Arrays.asList(
                "Amit", "Priya", "Rahul",
                "Amit", "Priya", "Rahul",
                "Ompraksh", "Karan"
        );

        Map<String, Integer> nameLengthMap = simpleNames.stream().distinct()
                .collect(Collectors.toMap(Function.identity(),String::length));

        System.out.println("\n053. List to Map:\n" + nameLengthMap);

        // 054. Handle duplicate keys while collecting a Map
        Map<String, Integer> duplicateKeyMap = names.stream().distinct()
                .collect(Collectors.toMap(Function.identity(),String::length));

        System.out.println("\n054. Handle duplicate keys:\n" + duplicateKeyMap);

        // 055. Create a Map of Employee ID to Employee
        Map<Integer, Employee> employeeIdMap = employees.stream()
                .collect(Collectors.toMap(Employee::getId,Function.identity()));

        System.out.println("\n055. Employee ID to Employee:\n" + employeeIdMap);

        // 056. Create a Map of Employee Name to Salary
        // If names repeat, keep the last encountered salary.
        Map<String, Double> employeeSalaryMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName,Employee::getSalary,(oldSalary, newSalary) -> newSalary));

        System.out.println("\n056. Employee Name to Salary:\n" + employeeSalaryMap);

        // 057. Convert a Stream into an Array using toArray()
        String[] namesArray = names.stream()
                .filter(name -> name.startsWith("A"))
                .toArray(String[]::new);

        System.out.println("\n057. Stream to Array:\n" + Arrays.toString(namesArray));

        // 058. Join strings using Collectors.joining()
        String joinedNames = names.stream()
                .distinct()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("\n058. Joining Strings:\n" + joinedNames);

        // 059. Create an unmodifiable collection using Java 8
        List<String> mutableList = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());

        List<String> unmodifiableList = Collections.unmodifiableList(
                new ArrayList<>(mutableList)
        );

        System.out.println("\n059. Unmodifiable List:\n" + unmodifiableList);

        // Throws UnsupportedOperationException:
        // unmodifiableList.add("Karan");

        // 060. Compare collect() and reduce()
        List<Integer> collectedNumbers = numbers.stream()
                .filter(n -> n > 20)
                .collect(Collectors.toList());

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(
                "\n060. Compare collect() and reduce():" +
                        "\ncollect() result: " + collectedNumbers +
                        "\nreduce() result (sum): " + sum
        );
    }
}