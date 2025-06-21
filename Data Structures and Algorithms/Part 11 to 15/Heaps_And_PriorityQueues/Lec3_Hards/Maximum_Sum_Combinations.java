package Heaps_And_PriorityQueues.Lec3_Hards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*Q4 Maximum Sum Combinations
Programming
Heaps And Maps
Medium
44.6% Success

476

30

Bookmark
Asked In:
Problem Description
 
 

Given two equally sized 1-D arrays A, B containing N integers each.

A sum combination is made by adding one element from array A and another element of array B.

Return the maximum C valid sum combinations from all the possible sum combinations.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 105

1 <= C <= N



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an one-dimensional integer array B of size N.

Third argument is an integer C.



Output Format
Return a one-dimensional integer array of size C denoting the top C maximum sum combinations.

NOTE:

The returned array must be sorted in non-increasing order.



Example Input
Input 1:

 A = [3, 2]
 B = [1, 4]
 C = 2
Input 2:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4


Example Output
Output 1:

 [7, 6]
Output 1:

 [10, 9, 9, 8]


Example Explanation
Explanation 1:

 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
Explanation 2:

 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)

 */
public class Maximum_Sum_Combinations {
    // Not my soln, reference soln. from yt
     public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        // Sort both arrays A and B
        Collections.sort(A);
        Collections.sort(B);
        
        // Max-heap to store the maximum sums and their indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // Set to keep track of visited pairs of indices
        Set<String> visited = new HashSet<>();
        
        // Add the largest possible sum combination
        int n = A.size();
        maxHeap.add(new int[]{A.get(n - 1) + B.get(n - 1), n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Extract the maximum sums
        while (C > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int sum = top[0];
            int i = top[1];
            int j = top[2];
            
            result.add(sum);
            C--;
            
            // Next possible sum combinations
            if (i > 0 && !visited.contains((i - 1) + "," + j)) {
                maxHeap.add(new int[]{A.get(i - 1) + B.get(j), i - 1, j});
                visited.add((i - 1) + "," + j);
            }
            if (j > 0 && !visited.contains(i + "," + (j - 1))) {
                maxHeap.add(new int[]{A.get(i) + B.get(j - 1), i, j - 1});
                visited.add(i + "," + (j - 1));
            }
        }
        
        return result;
    }
}
