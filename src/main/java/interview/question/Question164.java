package interview.question;

import java.util.*;
import java.util.stream.Collectors;

public class Question164 {
    public static void main(String[] args) {


        // =========================================================
        // Question 164: Compare two maps and find differing entries.
        // Concept: compare the union of keys and use Objects.equals()
        // to safely compare values, including null values.
        // =========================================================

        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("A", 100);
        map1.put("B", 200);
        map1.put("C", 300);

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("A", 100);
        map2.put("B", 250);
        map2.put("D", 400);

        Set<String> allKeys = new LinkedHashSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        Map<String, String> differingEntries = allKeys.stream()
                .filter(key -> !Objects.equals(map1.get(key), map2.get(key))
                        || map1.containsKey(key) != map2.containsKey(key))
                .collect(Collectors.toMap(
                        key -> key,
                        key -> "map1=" + map1.get(key)
                                + ", map2=" + map2.get(key),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Q164 - Differing entries: " + differingEntries);

    }
}
