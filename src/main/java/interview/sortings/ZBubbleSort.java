package interview.sortings;

public class ZBubbleSort {

    public static void main(String[] args) {

        int[] array = {10, 20, 30, 50, 100, 500, 99, 98, 77, 36};

        // Outer loop controls the number of passes through the array.
        for (int i = 0; i < array.length - 1; i++) {

            // Compare adjacent elements in the unsorted portion.
            // The last i elements are already sorted.
            for (int j = 0; j < array.length - 1 - i; j++) {

                // Compare the current element with the next element.
                if (array[j] > array[j + 1]) {

                    int temp = array[j];       // Store the current element temporarily.
                    array[j] = array[j + 1];   // Move the smaller element to the left.
                    array[j + 1] = temp;       // Move the larger element to the right.
                }
            }
        }

        // Print all elements of the sorted array.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}