package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question125 {

    /**
     * Merge duplicate keys with toMap()
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 125: Merge duplicate keys with toMap()");

        // List of strings
        List<String> products = Arrays.asList(
                "Apple", "Banana", "Apple", "Orange",
                "Banana", "Apple"
        );

        // Group products by their value (i.e., collect into a map)
        // and merge duplicate keys
        Map<String, Integer> productCount = products.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        product -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ));

        System.out.println("Product count: " + productCount);
    }
}
