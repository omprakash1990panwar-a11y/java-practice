package interview.question;

import interview.UtilPackages.Transaction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question069 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(101, 1500, LocalDate.of(2022, 3, 10)),
                new Transaction(102, 2500, LocalDate.of(2023, 6, 15)),
                new Transaction(103, 1800, LocalDate.of(2022, 9, 20)),
                new Transaction(104, 3200, LocalDate.of(2024, 1, 5)),
                new Transaction(105, 2100, LocalDate.of(2023, 11, 25)),
                new Transaction(106, 4000, LocalDate.of(2024, 8, 12))
        );

        // 069. Group transactions by year using groupingBy().
        Map<Integer, List<Transaction>> transactionsByYear =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                transaction -> transaction.getDate().getYear()
                        ));

        System.out.println("\n069. Transactions grouped by year:");
        transactionsByYear.forEach((year, transactionList) ->
                System.out.println(year + " -> " + transactionList));
    }
}
