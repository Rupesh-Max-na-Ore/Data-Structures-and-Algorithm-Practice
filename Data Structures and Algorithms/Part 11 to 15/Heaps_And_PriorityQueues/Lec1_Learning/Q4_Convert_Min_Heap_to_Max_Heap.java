package Heaps_And_PriorityQueues.Lec1_Learning;

public class Q4_Convert_Min_Heap_to_Max_Heap {
    static void convertMinToMaxHeap(int N, int A[]) {
        // it is same as converting any random array to max heap
        // Start from the last internal, non-leaf node and move up
            for (int i = (N / 2) - 1; i >= 0; i--) {
                // heapify on each internal, non-leaf node
                maxHeapify(A, N, i);
            }
        }
        static void maxHeapify(int[] A, int N, int indx) {
            int largest = indx; // Ini. largest as the curr node
            int L = 2 * indx + 1; 
            int R = 2 * indx + 2; 
    
            if (L < N && A[L] > A[largest]) largest = L;
            if (R < N && A[R] > A[largest]) largest = R;
    
            // If the largest elem is not the curr node, swap them and recursively heapify the affected subtree
            if (largest != indx) {
                int temp = A[indx];
                A[indx] = A[largest];
                A[largest] = temp;
                maxHeapify(A, N, largest);
            }
        }
}
