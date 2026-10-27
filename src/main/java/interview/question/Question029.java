package interview.question;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question029 {

    public static void main(String[] args) {

        // Sort dates from latest to earliest.
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2025, 12, 25),
                LocalDate.of(2023, 5, 10),
                LocalDate.of(2024, 8, 15),
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2024, 2, 20)
        );

        List<LocalDate> sortedDates = dates.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Q029 - Dates descending:");

        sortedDates.forEach(System.out::println);
    }
}
