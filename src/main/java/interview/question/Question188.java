package interview.question;

import interview.UtilPackages.Transaction;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Question188 {

    public static void main(String[] args) {

        // =========================================================
        // Question 188: Group transactions by month and calculate totals.
        //
        // Concept:
        // YearMonth combines the year and month, preventing January
        // from different years from being incorrectly grouped together.
        // summingDouble() calculates the total for each month.
        // =========================================================

        List<Transaction> transactions = Arrays.asList(
                new Transaction(101, 1200.0, LocalDate.of(2026, 1, 5)),
                new Transaction(102, 800.0, LocalDate.of(2026, 1, 20)),
                new Transaction(101, 300.0, LocalDate.of(2026, 2, 2)),
                new Transaction(103, 1500.0, LocalDate.of(2026, 2, 10)),
                new Transaction(103, 500.0, LocalDate.of(2026, 1, 30))
        );

        Map<YearMonth, Double> monthlyTransactionTotals =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                transaction ->
                                        YearMonth.from(transaction.getDate()),
                                TreeMap::new,
                                Collectors.summingDouble(
                                        Transaction::getAmount
                                )
                        ));

        System.out.println("\nQ188 - Monthly transaction totals:");

        monthlyTransactionTotals.forEach((month, total) ->
                System.out.println(month + " -> " + total)
        );


    }
}
