package Heaps_And_PriorityQueues.Lec2_Mediums;
/*Q1 215. Kth Largest Element in an Array
Medium
Topics
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
Accepted
2.4M
Submissions
3.5M
Acceptance Rate
66.9% */
public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] a, int k) {
        int N= a.length;
        //max heapify a[], then deleteMax k times from it
        for (int i = (N / 2) - 1; i >= 0; i--) {
            // heapify on each internal, non-leaf node
            maxHeapify(a, N, i);
        }
        // Remove the max elem (k-1) times to get the k-th largest elem
        //for(int i=1; i<=k-1;i++) deleteMax(a, N);
        for(int i=1; i<=k-1;i++) N=deleteMax(a, N); //updates 

        //return deleteMax(a, N);
        // The k-th largest elem will be at the root of the max heap
        return a[0];
    }
    public void maxHeapify(int[] A, int N, int indx) {
        int maxTillNow = indx; // Ini. maxTillNow as the curr node
        int L = 2 * indx + 1; 
        int R = 2 * indx + 2; 

        if (L < N && A[L] > A[maxTillNow]) maxTillNow = L;
        if (R < N && A[R] > A[maxTillNow]) maxTillNow = R;

        // If the maxTillNow elem is not the curr node, swap them and recursively heapify the affected subtree
        if (maxTillNow != indx) {
            int temp = A[indx];
            A[indx] = A[maxTillNow];
            A[maxTillNow] = temp;
            maxHeapify(A, N, maxTillNow);
        }
    }
    public int deleteMax(int[] a, int n){
        if(n==0) return -1;
        int maxTillNow=a[0]; // Max elem is at the root
        a[0]=a[n-1]; // Move the last elem to the root
        //a[n-1] = 0;
        n=n-1; // -- the size of the heap
        // percolate down to maintain the max heap property
        maxHeapify(a, n, 0);
        //return maxTillNow;
        return n;
    }

}
// Using Quick Select ALgo
// public int findKthLargest(int[] a, int k) {
//     // Adjust k to find the k-th largest
//     return QuickSelect(a, 0, a.length - 1, a.length - k);
// }

// public int QuickSelect(int[] a, int l, int r, int k) {
//     if (l <= r) {
//         // Shuffle to randomize the pivot
//         int pivotIndex = partition(a, l, r);
//         if (pivotIndex == k) {
//             return a[pivotIndex];
//         } else if (pivotIndex > k) {
//             return QuickSelect(a, l, pivotIndex - 1, k);
//         } else {
//             return QuickSelect(a, pivotIndex + 1, r, k);
//         }
//     }
//     return -1; // This case will not be hit, added to handle edge cases
// }

// private int partition(int[] a, int l, int r) {
//     // Choose a random pivot and move it to the end
//     int pivotIndex = l + new Random().nextInt(r - l + 1);
//     swap(a, pivotIndex, r);
//     int pivot = a[r];
//     int p = l;

//     // Partition the array around the pivot
//     for (int i = l; i < r; i++) {
//         if (a[i] < pivot) {
//             swap(a, i, p);
//             p++;
//         }
//     }
//     swap(a, p, r);
//     return p;
// }

// private void swap(int[] array, int left, int right) {
//     int temp = array[left];
//     array[left] = array[right];
//     array[right] = temp;
// }

// //using MinHeap
// public int findKthLargest(int[] nums, int k) {

//     final PriorityQueue<Integer> pq = new PriorityQueue<>();
//     for(int val : nums) {
//         pq.offer(val);

//         if(pq.size() > k) {
//             pq.poll();
//         }
//     }
//     return pq.peek();
// }