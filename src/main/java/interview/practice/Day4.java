package interview.practice;

import interview.UtilPackages.*;

import java.util.*;
import java.util.stream.Collectors;

public class Day4 {

    public static void main(String[] args) {

        // =====================================================
        // Question 031: Flatten a List of Lists into one List
        // =====================================================

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        // Step 1: Convert the outer list into a stream.
        // Step 2: flatMap(List::stream) flattens all inner lists.
        // Step 3: toList() collects all integers into one list.
        List<Integer> result = nestedList.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Q31 - Flattened nested list: " + result);


        // =====================================================
        // Question 032: Flatten a List of Sets into one List
        // =====================================================

        List<Set<String>> sets = Arrays.asList(
                new LinkedHashSet<>(Arrays.asList(
                        "Ramesh", "Mukesh", "Madhav")),
                new LinkedHashSet<>(Arrays.asList(
                        "Ram Singh", "Rohit Raj")),
                new LinkedHashSet<>(Arrays.asList(
                        "Uday Panwar", "Gaurav"))
        );

        // Convert each set into a stream and flatten all sets.
        // LinkedHashSet preserves insertion order within each set.
        List<String> flatList = sets.stream()
                .flatMap(set -> set.stream())
                .toList();

        System.out.println("Q32 - Flattened sets: " + flatList);


        // =====================================================
        // Question 033: Extract all words from sentences
        // =====================================================

        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Spring Boot is popular",
                "Streams simplify coding",
                "Streams simplify coding",
                "Streams simplify coding"
        );

        // Split each sentence using whitespace.
        // flatMap() combines the resulting word arrays into one stream.
        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(
                        sentence.split("\\s+")))
                .toList();

        System.out.println("Q33 - All words: " + words);

        // distinct() removes duplicate words.
        // The first occurrence of each word is retained.
        words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(
                        sentence.split("\\s+")))
                .distinct()
                .toList();

        System.out.println("Q33 - Unique words: " + words);


        // =====================================================
        // Question 034: Flatten employee skill lists
        // =====================================================

        List<Employee> employees = Arrays.asList(
                new Employee("Amit",
                        Arrays.asList("Java", "Spring Boot")),
                new Employee("Priya",
                        Arrays.asList("MySQL", "Docker")),
                new Employee("Rahul",
                        Arrays.asList("Java", "Kafka"))
        );

        // Extract each employee's skills and flatten them
        // into one list. Duplicate skills are retained.
        List<String> skills = employees.stream()
                .flatMap(employee -> employee.getSkills().stream())
                .toList();

        System.out.println("Q34 - All employee skills: " + skills);


        // =====================================================
        // Question 035: Find all unique employee skills
        // =====================================================

        List<Employee> employeesWithSkills = Arrays.asList(
                new Employee("Amit",
                        Arrays.asList("Java", "Spring Boot", "MySQL")),
                new Employee("Priya",
                        Arrays.asList("Java", "Docker", "MySQL")),
                new Employee("Rahul",
                        Arrays.asList("Java", "Kafka", "Spring Boot")),
                new Employee("Neha",
                        Arrays.asList("Docker", "AWS", "Kafka"))
        );

        // Flatten every employee's skills and remove duplicates.
        List<String> uniqueSkills = employeesWithSkills.stream()
                .flatMap(employee -> employee.getSkills().stream())
                .distinct()
                .toList();

        System.out.println("Q35 - Unique employee skills: "
                + uniqueSkills);


        // =====================================================
        // Question 036: Flatten nested Integer arrays
        // =====================================================

        Integer[][] arraysObj = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8}
        };

        // Approach 1: Use a lambda to convert each inner array
        // into a stream, then flatten the streams.
        List<Integer> combinedList = Arrays.stream(arraysObj)
                .flatMap(eachArray -> Arrays.stream(eachArray))
                .toList();

        System.out.println("Q36 - Flattened array (lambda): "
                + combinedList);

        // Approach 2: Use the Arrays::stream method reference.
        combinedList = Arrays.stream(arraysObj)
                .flatMap(Arrays::stream)
                .toList();

        System.out.println("Q36 - Flattened array (method reference): "
                + combinedList);


        // =====================================================
        // Question 037: Convert strings into character streams
        // =====================================================

        List<String> characterWords = Arrays.asList("Java", "Code");

        // chars() produces an IntStream containing character codes.
        // boxed() converts primitive int values into Integer objects.
        List<Integer> characterCodes = characterWords.stream()
                .flatMapToInt(String::chars)
                .boxed()
                .toList();

        System.out.println("Q37 - Character codes: " + characterCodes);

        // mapToObj() converts each character code into a Character.
        List<Character> charList = characterWords.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .toList();

        System.out.println("Q37 - Character list: " + charList);


        // =====================================================
        // Question 038: Flatten line items from multiple orders
        // =====================================================

        List<Order> ordersWithItems = Arrays.asList(
                new Order(101,
                        Arrays.asList(new Product(1, "Laptop")),
                        Arrays.asList(new LineItem("Laptop", 1),
                                        new LineItem("Mouse", 2)
                        )
                ),
                new Order(102,
                        Arrays.asList(new Product(2, "Keyboard")),
                        Arrays.asList(
                                new LineItem("Keyboard", 1),
                                new LineItem("Monitor", 2)
                        )
                ),
                new Order(103,
                        Arrays.asList(new Product(3, "Headphones")),
                        Arrays.asList(
                                new LineItem("Headphones", 1)
                        )
                )
        );

// Flatten all order line items into one list.
        List<LineItem> allItems = ordersWithItems.stream()
                .flatMap(order -> order.getLineItems().stream())
                .toList();

        System.out.println("Q38 - All order line items: " + allItems);

        System.out.println("Q38 - All order line items: " + allItems);


        // =====================================================
        // Question 039: Find unique product IDs and names
        // =====================================================

        List<ProductOrder> productOrders = Arrays.asList(
                new ProductOrder(101, Arrays.asList(
                        new Product(1, "Laptop"),
                        new Product(2, "Mouse")
                )),
                new ProductOrder(102, Arrays.asList(
                        new Product(2, "Mouse"),
                        new Product(3, "Keyboard")
                )),
                new ProductOrder(103, Arrays.asList(
                        new Product(1, "Laptop"),
                        new Product(4, "Monitor")
                ))
        );

        // Extract product IDs from every order.
        // distinct() removes duplicate IDs across all orders.
        List<Integer> uniqueProductIds = productOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getProductId)
                .distinct()
                .toList();

        System.out.println("Q39 - Unique product IDs: "
                + uniqueProductIds);

        // Extract product names from every order.
        // distinct() removes repeated product names globally.
        List<String> uniqueProductNames = productOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getProductName)
                .distinct()
                .toList();

        System.out.println("Q39 - Unique product names: "
                + uniqueProductNames);


        // =====================================================
        // Question 040: Convert strings to uppercase/lowercase
        // =====================================================

        List<String> names = Arrays.asList(
                "amit", "priya", "rahul"
        );

        // Approach 1: Convert every name to uppercase using a lambda.
        names = names.stream()
                .map(name -> name.toUpperCase())
                .toList();

        System.out.println("Q40 - Uppercase (lambda): " + names);

        // Approach 2: Convert every name to lowercase.
        // Collect using Collectors.toList().
        names = names.stream()
                .map(name -> name.toLowerCase())
                .collect(Collectors.toList());

        System.out.println("Q40 - Lowercase (Collectors): " + names);

        // Approach 3: Convert every name to uppercase using a
        // method reference instead of a lambda expression.
        names = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Q40 - Uppercase (method reference): "
                + names);

        // Additional flatMap example from Question 040:
        // Flatten a nested list of integers into a single list.
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> numberCombinedList = numbers.stream()
                .flatMap(number -> number.stream())
                .toList();

        System.out.println("Q40 - Flattened integer list: "
                + numberCombinedList);
    }
}
