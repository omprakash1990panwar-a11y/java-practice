package interview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Question107 {

    public static void main(String[] args) {

        // Question 107: Find common elements in two arrays.
        // IMPORTANT:
        // filter() retains elements satisfying a condition.
        // anyMatch() checks whether an element exists in the second array.
        // distinct() prevents repeated common elements in the result.

        System.out.println("\nQuestion 107: Find common elements in two arrays");

        int[] firstArray = {10, 20, 30, 40, 50, 20};
        int[] secondArray = {30, 40, 50, 60, 70};

        List<Integer> commonElements =
                Arrays.stream(firstArray)
                        .filter(number ->
                                Arrays.stream(secondArray)
                                        .anyMatch(value -> value == number))
                        .distinct()
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println("Common elements: " + commonElements);



        ArrayList<Integer> firstArrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 20));
        ArrayList<Integer> secondArrayList = new ArrayList<>(Arrays.asList(30, 40, 50, 60, 70,50));

        ArrayList<Integer> commonElement =
                firstArrayList.stream().filter(number -> secondArrayList.stream().anyMatch(value -> value.equals(number)))
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Array List Common elements: " + commonElement);
    }
}
