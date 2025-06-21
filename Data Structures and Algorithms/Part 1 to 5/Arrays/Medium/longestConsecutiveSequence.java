package Arrays.Medium;
// //q10
// 128. Longest Consecutive Sequence
// Medium
// Topics
// Companies
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

 

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.8M
// Submissions
// 3.7M
// Acceptance Rate
// 47.3%
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSequence {
 public static int longestSuccessiveElements(int[] A) {
        int n = A.length;
        // If empty array passed, max=0
        if (n == 0)
            return 0;

        int max = 1;
        Set<Integer> Eset = new HashSet<>();

        // insert all the array elements into Eset
        for (int i = 0; i < n; i++) {
            Eset.add(A[i]);
        }

        // Find the longest sequence via
        for (int E : Eset) {
            // if 'E' is a starting no.
            if (!Eset.contains(E - 1)) {
                // find consecutive (next) nos.
                int cnt = 1;
                int x = E;
                // check if E+1 exists, successively
                while (Eset.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                max = (max < cnt)? cnt : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {5, 300, 100, 200, 1, 2, 3, 4};
        int max = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + max);
    }
}
// //lc submission 1
// class Solution {
//     public int longestConsecutive(int[] A) {
//                 int n = A.length;
//         // If empty array passed, max=0
//         if (n == 0)
//             return 0;

//         int max = 1;
//         Set<Integer> Eset = new HashSet<>();

//         // insert all the array elements into Eset
//         for (int i = 0; i < n; i++) {
//             Eset.add(A[i]);
//         }

//         // Find the longest sequence via
//         for (int E : Eset) {
//             // if 'E' is a starting no.
//             if (!Eset.contains(E - 1)) {
//                 // find consecutive (next) nos.
//                 int cnt = 1;
//                 int x = E;
//                 // check if E+1 exists, successively
//                 while (Eset.contains(x + 1)) {
//                     x = x + 1;
//                     cnt = cnt + 1;
//                 }
//                 max = (max < cnt)? cnt : max;
//             }
//         }
//         return max;

//     }
// }