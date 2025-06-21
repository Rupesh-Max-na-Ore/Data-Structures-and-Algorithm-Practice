package Heaps_And_PriorityQueues.Lec2_Mediums;
/*Q5 Replace elements by its rank in the array
Difficulty: MediumAccuracy: 49.96%Submissions: 14K+Points: 4
Given an array arr of N integers, the task is to replace each element of the array by its rank in the array. The rank of an element is defined as the distance between the element with the first element of the array when the array is arranged in ascending order. If two or more are same in the array then their rank is also the same as the rank of the first occurrence of the element. 

Example 1:

Input:
N = 6
arr = [20, 15, 26, 2, 98, 6]
Output:
4, 3, 5, 1, 6, 2
Explanation:
After sorting, array becomes {2,6,15,20,26,98}
Rank(2) = 1 (at index 0) 
Rank(6) = 2 (at index 1) 
Rank(15) = 3 (at index 2) 
Rank(20) = 4 (at index 3) and so on..
Example 2:

Input:
N = 4
arr = [2, 2, 1, 6]
Output:
2, 2, 1, 3
Explanation:
After sorting, array becomes {1, 2, 2, 6}
Rank(1) = 1 (at index 0) 
Rank(2) = 2 (at index 1) 
Rank(2) = 2 (at index 2) 
Rank(6) = 3 (at index 3)
Rank(6) = 3 because rank after 2 is 3 as rank 
of same element remains same and for next element 
increases by 1.
Your Task:
Complete the function int replaceWithRank(), which takes integer N  and an array of N integers as input and returns the list in which element at each position of original array is replaced by the rank of that element.

Expected Time Complexity: O(N * logN)
Expected Auxiliary Space: O(N)


Constraints:

1 <= N <= 105
1 <= arr[i] <= 109 */
import java.util.HashMap;
import java.util.PriorityQueue;

public class Replace_elements_by_its_rank_in_the_array {
    static int[] replaceWithRank(int a[], int n) {
        int [] b = new int[n];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int num: a) pq.offer(num);
        int rank=1;
        for(int i=0; i<n; i++){
            int curr=pq.poll();
            hmap.put(curr,rank);
            if(!pq.isEmpty() && curr==pq.peek()) continue;
            rank++;
        }
        for(int i=0; i<n; i++) b[i] = hmap.get(a[i]);
        return b;
    }
    //1st attempt, some wrongs, tho logic correct
    // static int[] replaceWithRank(int a[], int n) {
    //     int [] b = new int[n];
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     HashMap<Integer,Integer> hmap = new HashMap<>();
    //     for(int num: a) pq.offer(num);
    //     int rank=1; //int prevCurr;
    //     for(int i=0; i<n; i++){
    //         int curr=pq.poll();
    //         hmap.put(curr,rank);
    //         if(curr!=pq.peek()) rank++;//rank for next itr
    //         //prevCurr=curr;
    //     }
    //     for(int i=0; i<n; i++) b[i] = hmap.get(a[i]);
    //     return b;
    // }
}
// //Striver's HMap soln., for reference
// import java.util.*;
// public class Main {
//   public static void main(String args[]) {
//     int arr[] = {20,15,26,2,98,6};
//     HashMap < Integer, Integer > mp = new HashMap < Integer, Integer > ();
//     int temp = 1;
//     int n = arr.length;
//     int brr[] = new int[n];
//     for (int i = 0; i < n; i++) {
//       brr[i] = arr[i];
//     }
//     Arrays.sort(brr);
//     for (int i = 0; i < n; i++) {
//       //if element is previously not store in the map
//       if (mp.get(brr[i]) == null) {
//         mp.put(brr[i], temp);
//         temp++;
//       }
//     }
//     for (int i = 0; i < n; i++) {
//       System.out.print(mp.get(arr[i]) + " ");
//     }
//   }
// }