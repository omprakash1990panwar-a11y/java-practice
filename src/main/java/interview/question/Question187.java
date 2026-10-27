package interview.question;

import interview.UtilPackages.Transaction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question187 {

    public static void main(String[] args) {


        // =========================================================
        // Question 187: Find duplicate transactions by transaction ID.
        //
        // Concept:
        // Group transactions by transaction ID, count each group,
        // and retain IDs appearing more than once.
        // =========================================================

        List<Transaction> transactions = Arrays.asList(
                new Transaction(101, 1200.0, LocalDate.of(2026, 1, 5)),
                new Transaction(102, 800.0, LocalDate.of(2026, 1, 20)),
                new Transaction(101, 300.0, LocalDate.of(2026, 2, 2)),
                new Transaction(103, 1500.0, LocalDate.of(2026, 2, 10)),
                new Transaction(103, 500.0, LocalDate.of(2026, 1, 30))
        );

        Map<Integer, Long> transactionIdCounts = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getTransactionId,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Map<Integer, Long> duplicateTransactionIds =
                transactionIdCounts.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        ));

        System.out.println("\nQ187 - Duplicate transaction IDs: "
                + duplicateTransactionIds);

    }
}
