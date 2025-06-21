package Binary_Search.BS_on_Answers;
/*
 * Q13
 * K-th Element of two sorted arrays


12

2
Pre-requisite: Median of 2 sorted arrays

Problem Statement: Given two sorted arrays of size m and n respectively, 
you are tasked with finding the element that would be at the kth position of the final sorted array.
 */
public class KthElementOf2SortedArrs {
    public int findKthElement(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;
        if (n > m) return findKthElement(b, a, k); // ensure that a is the smaller array

        int l = Math.max(0, k - m), r = Math.min(k, n); // binary search range for the smaller array

        while (l <= r) {
            int m1 = l + (r - l) / 2; // cut point for array1
            int m2 = k - m1; // cut point for array2

            // Calc. elems for cross-check
            int l1 = (m1 > 0) ? a[m1 - 1] : Integer.MIN_VALUE;
            int l2 = (m2 > 0) ? b[m2 - 1] : Integer.MIN_VALUE;
            int r1 = (m1 < n) ? a[m1] : Integer.MAX_VALUE;
            int r2 = (m2 < m) ? b[m2] : Integer.MAX_VALUE;

            // Cross check
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                r = m1 - 1; // too many elems from a in left half
            } else {
                l = m1 + 1; // too many elems from a in right half
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        KthElementOf2SortedArrs kthElementFinder = new KthElementOf2SortedArrs();
        
        // Test cases
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3, 5};
        int k = 4;
        System.out.println("Test Case 1:");
        System.out.println("Input: arr1 = {2, 4, 6}, arr2 = {1, 3, 5}, k = " + k);
        System.out.println("Output: " + kthElementFinder.findKthElement(arr1, arr2, k)); // Expected output: 4

        int[] arr3 = {2, 4, 6};
        int[] arr4 = {1, 3};
        k = 5;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: arr1 = {2, 4, 6}, arr2 = {1, 3}, k = " + k);
        System.out.println("Output: " + kthElementFinder.findKthElement(arr3, arr4, k)); // Expected output: 6

        // Large inputs test
        int size = 1000000;
        int[] largeArr1 = new int[size];
        int[] largeArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            largeArr1[i] = 2 * i;
            largeArr2[i] = 2 * i + 1;
        }
        k = 1500000;
        System.out.println("\nLarge Input Test Case:");
        System.out.println("Output: " + kthElementFinder.findKthElement(largeArr1, largeArr2, k)); // Expected output will be 2 * (k-1)
    }
}

/*
 * //GFG submission, just change to long for large inputs
 * class Solution {
    public long kthElement( int a[], int b[], int n, int m, int k) {
        
        if (n > m) return kthElement(b, a, m, n, k); // ensure that a is the smaller array

        int l = Math.max(0, k - m), r = Math.min(k, n); // binary search range for the smaller array

        while (l <= r) {
            int m1 = l + (r - l) / 2; // cut point for array1
            int m2 = k - m1; // cut point for array2

            // Calculate elements for cross-check
            long l1 = (m1 > 0) ? a[m1 - 1] : Long.MIN_VALUE;
            long l2 = (m2 > 0) ? b[m2 - 1] : Long.MIN_VALUE;
            long r1 = (m1 < n) ? a[m1] : Long.MAX_VALUE;
            long r2 = (m2 < m) ? b[m2] : Long.MAX_VALUE;

            // Cross check
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                r = m1 - 1; // too many elements from a in left half
            } else {
                l = m1 + 1; // too many elements from a in right half
            }
        }
        return 0;
    }
} 
 */