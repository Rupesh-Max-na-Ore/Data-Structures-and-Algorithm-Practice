package Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] array) {
        // Find the max. no. to know the no. of digits
        int max = getMax(array);

        // Perform counting sort for every digit from least significant to most significant
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static void countingSort(int[] array, int exp) {
        int[] count = new int[10];
        int[] output = new int[array.length];

        // Count the freq. of occurrences of each digit in the current position
        for (int value : array) {
            count[(value / exp) % 10]++;
        }

        // Modify count array to store cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted output array
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, array, 0, array.length);
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(array));
        radixSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
