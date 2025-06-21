package Heaps_And_PriorityQueues.Lec2_Mediums;

import java.util.PriorityQueue;

/*Q2 Kth Smallest
Difficulty: MediumAccuracy: 35.17%Submissions: 597K+Points: 4
Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array. It is given that all array elements are distinct.

Note:-  l and r denotes the starting and ending index of the array.

Example 1:

Input:
n = 6
arr[] = 7 10 4 3 20 15
k = 3
l=0 r=5

Output : 
7

Explanation :
3rd smallest element in the given 
array is 7.
Example 2:

Input:
n = 5
arr[] = 7 10 4 20 15
k = 4 
l=0 r=4

Output : 
15

Explanation :
4th smallest element in the given 
array is 15.
Your Task:
You don't have to read input or print anything. Your task is to complete the function kthSmallest() which takes the array arr[], integers l and r denoting the starting and ending index of the array and an integer k as input and returns the kth smallest element.
 
Expected Time Complexity: O(n*log(n) )
Expected Auxiliary Space: O(log(n))
Constraints:
1 <= n <= 105
l = 0
r = N-1
1<= arr[i] <= 105
1 <= k <= n */
public class Kth_Smallest {
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
    int n=arr.length;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=l; i<=r;i++) {
        pq.offer(arr[i]);
        //after insering more than n-k+1 elems, we can start polling
        if(pq.size()>(n-(k)+1)) pq.poll();
        //==//if(pq.size()>(n-(k-1))) pq.poll();
        //==//if(pq.size()-1>(n-(k))) pq.poll();
    }
    //for(int i=1;i<k;i++) pq.poll();
    return pq.peek();
    } 
    //first attempt, works
    // public static int kthSmallest(int[] arr, int l, int r, int k) 
    // { 
    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // for(int i=l; i<=r;i++) pq.offer(arr[i]);
    // for(int i=1;i<k;i++) pq.poll();
    // return pq.peek();
    // }
}
// Min Heap way1
// public static int kthSmallest(int[] arr, int l, int r, int k) 
//     { 
//     PriorityQueue<Integer> pq = new PriorityQueue<>();
//     for(int val : arr) {
//         pq.offer(val);
//     }
//     for(int i=1;i<k;i++) pq.poll();
//     return pq.peek();
//     } 