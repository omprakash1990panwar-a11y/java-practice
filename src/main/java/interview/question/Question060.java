package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question060 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

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
