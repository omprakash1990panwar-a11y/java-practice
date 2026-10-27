package interview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;


public class Question110 {

    public static void main(String[] args) {

        // Question 110: Calculate IntSummaryStatistics for an array.
        // IMPORTANT:
        // summaryStatistics() calculates count, sum, min, max, and average.
        // It is useful when multiple numeric statistics are required.
        // For an empty stream, count and sum are zero, while min and max
        // are represented by their primitive type's extreme values.

        System.out.println("\nQuestion 110: Calculate IntSummaryStatistics");

        int[] statisticsNumbers = {10, 20, 30, 40, 50};

        IntSummaryStatistics statistics = Arrays.stream(statisticsNumbers).summaryStatistics();

        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Minimum: " + statistics.getMin());
        System.out.println("Maximum: " + statistics.getMax());
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Complete statistics: " + statistics);
    }
}