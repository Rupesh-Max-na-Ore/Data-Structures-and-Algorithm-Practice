package Sorting;
import java.util.*;
public class CountingSort {
    public static void countingSort(int[] array) {
        int max = getMax(array);
        int[] count = new int[max + 1];
        int[] result = new int[array.length];

        // Count no. of occurrences (freq.) of each element
        for (int value : array) {
            count[value]++;
        }

        // Modify count array to store cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array
        for (int i = array.length - 1; i >= 0; i--) {
            result[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements back into the original array
        System.arraycopy(result, 0, array, 0, array.length);
    }

    private static int getMax(int[] array) {
        //int max = -1; Works but best practice as below
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original array: " + Arrays.toString(array));
        countingSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

