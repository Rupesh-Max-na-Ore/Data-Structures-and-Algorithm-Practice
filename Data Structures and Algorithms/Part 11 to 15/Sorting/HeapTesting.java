package Sorting;

public class HeapTesting {

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
        
        // Sorting using MinHeap
        MinHeap minHeap = new MinHeap(array.length);
        minHeap.heapSort(array);
        System.out.println("Sorted array using MinHeap:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Search for 2: " + minHeap.search(2)); // Should print true
        System.out.println("Search for 7: " + minHeap.search(7)); // Should print false

        // Sorting using MaxHeap
        MaxHeap maxHeap = new MaxHeap(array.length);
        maxHeap.heapSort(array);
        System.out.println("Sorted array using MaxHeap:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Search for 2: " + maxHeap.search(2)); // Should print true
        System.out.println("Search for 7: " + maxHeap.search(7)); // Should print false

    }


}
