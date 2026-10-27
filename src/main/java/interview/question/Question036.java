package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question036 {
    public static void main(String[] args) {
        // Flatten nested Integer arrays.
        Integer[][] arraysObj = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8}
        };

        List<Integer> combinedList = Arrays.stream(arraysObj)
                .flatMap(eachArray -> Arrays.stream(eachArray))
                .toList();

        System.out.println("Q36 - Flattened array (lambda): " + combinedList);



        combinedList = Arrays.stream(arraysObj).flatMap(Arrays::stream).toList();



        System.out.println("Q36 - Flattened array (method reference): " + combinedList);
    }
}
