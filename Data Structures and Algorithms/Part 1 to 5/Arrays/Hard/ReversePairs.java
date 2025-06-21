package Arrays.Hard;

// //q11
// 493. Reverse Pairs
// Solved
// Hard
// Topics
// Companies
// Hint
// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
 

// Example 1:

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// Example 2:

// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -231 <= nums[i] <= 231 - 1
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 175.8K
// Submissions
// 574.3K
// Acceptance Rate
// 30.6%

import java.util.ArrayList;

public class ReversePairs {
    public static int countRevPairs(int[] A, int LO, int MID, int HI) {
        int LFT =LO;
        int RIT = MID + 1;
        int cnt = 0;
        while (LFT <= MID) {
            while (RIT <= HI && A[LFT] > 2L * A[RIT]) RIT++;
            cnt += (RIT - (MID + 1));
            LFT++;
        }
        return cnt;
    }

    public static int mergeSort(int[] A, int LO, int HI) {
        int cnt = 0;
        if (LO >= HI) return cnt;
        int MID = (LO + HI) / 2 ;
        cnt += mergeSort(A, LO, MID);  // LFT subarray
        cnt += mergeSort(A, MID + 1, HI); // RIT subarray
        cnt += countRevPairs(A, LO, MID, HI); //MOD
        merge(A, LO, MID, HI);  // merging sorted halves
        return cnt;
    }

    private static void merge(int[] A, int LO, int MID, int HI) {
        ArrayList<Integer> AL = new ArrayList<>(); // for temp storage
        int LFT = LO;      // start i of LFT subarray
        int RIT = MID + 1;   // start i of RIT subarray

        //storing elems in sorted way in AL

        while (LFT <= MID && RIT <= HI) {
            if (A[LFT] <= A[RIT]) {
                AL.add(A[LFT]);
                LFT++;
            } else {
                AL.add(A[RIT]);
                RIT++;
            }
        }

        // if elems on LFT subarray are still remaining

        while (LFT <= MID) {
            AL.add(A[LFT]);
            LFT++;
        }

        //  if elems on RIT subarray are still remaining
        while (RIT <= HI) {
            AL.add(A[RIT]);
            RIT++;
        }

        // transfer all elems from AL to A[] 
        for (int i = LO; i <= HI; i++) {
            A[i] = AL.get(i - LO);
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 4, 9, 1, 6, 2, 5, 3, 11, 1};
        int cnt = mergeSort(a, 0, a.length - 1);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}

//LC submission 2, 1 failed cuz of TC = [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
// just modified to do mult of 2*A[RIT] in long to 2L*A[RIT] for implicit typecast to handle big nos. like above
// used temp[] over AL cuz a little faster I heard, took 42secs
// class Solution {
//     public int reversePairs(int[] a) {
//         return mergeSort(a, 0, a.length - 1);
//     }

//     public static int countRevPairs(int[] A, int LO, int MID, int HI) {
//         int LFT = LO;
//         int RIT = MID + 1;
//         int cnt = 0;
//         while (LFT <= MID) {
//             while (RIT <= HI && A[LFT] > 2L * A[RIT]) RIT++; //MOD 2 to 2L for implicit type
//             cnt += (RIT - (MID + 1));
//             LFT++;
//         }
//         return cnt;
//     }

//     public static int mergeSort(int[] A, int LO, int HI) {
//         int cnt = 0;
//         if (LO >= HI) return cnt;
//         int MID = (LO + HI) / 2;
//         cnt += mergeSort(A, LO, MID);  
//         cnt += mergeSort(A, MID + 1, HI); 
//         cnt += countRevPairs(A, LO, MID, HI); 
//         merge(A, LO, MID, HI);  
//         return cnt;
//     }

//     private static void merge(int[] A, int LO, int MID, int HI) {
//         int[] temp = new int[HI - LO + 1];
//         int LFT = LO; 
//         int RIT = MID + 1; 
//         int k = 0;

//         while (LFT <= MID && RIT <= HI) {
//             if (A[LFT] <= A[RIT]) {
//                 temp[k++] = A[LFT++];
//             } else {
//                 temp[k++] = A[RIT++];
//             }
//         }

//         while (LFT <= MID) {
//             temp[k++] = A[LFT++];
//         }

//         while (RIT <= HI) {
//             temp[k++] = A[RIT++];
//         }

//         for (int i = 0; i < temp.length; i++) {
//             A[LO + i] = temp[i];
//         }
//     }
// }

// //LC submission 3 with arraylist, took 79sec
// class Solution {
//     public int reversePairs(int[] a) {
//         return mergeSort(a, 0, a.length - 1);
//     }

//     public static int countRevPairs(int[] A, int LO, int MID, int HI) {
//         int LFT =LO;
//         int RIT = MID + 1;
//         int cnt = 0;
//         while (LFT <= MID) {
//             while (RIT <= HI && A[LFT] > 2L * A[RIT]) RIT++;
//             cnt += (RIT - (MID + 1));
//             LFT++;
//         }
//         return cnt;
//     }

//     public static int mergeSort(int[] A, int LO, int HI) {
//         int cnt = 0;
//         if (LO >= HI) return cnt;
//         int MID = (LO + HI) / 2 ;
//         cnt += mergeSort(A, LO, MID);  // LFT subarray
//         cnt += mergeSort(A, MID + 1, HI); // RIT subarray
//         cnt += countRevPairs(A, LO, MID, HI); //MOD
//         merge(A, LO, MID, HI);  // merging sorted halves
//         return cnt;
//     }

//     private static void merge(int[] A, int LO, int MID, int HI) {
//         ArrayList<Integer> AL = new ArrayList<>(); // for temp storage
//         int LFT = LO;      // start i of LFT subarray
//         int RIT = MID + 1;   // start i of RIT subarray

//         //storing elems in sorted way in AL

//         while (LFT <= MID && RIT <= HI) {
//             if (A[LFT] <= A[RIT]) {
//                 AL.add(A[LFT]);
//                 LFT++;
//             } else {
//                 AL.add(A[RIT]);
//                 RIT++;
//             }
//         }

//         // if elems on LFT subarray are still remaining

//         while (LFT <= MID) {
//             AL.add(A[LFT]);
//             LFT++;
//         }

//         //  if elems on RIT subarray are still remaining
//         while (RIT <= HI) {
//             AL.add(A[RIT]);
//             RIT++;
//         }

//         // transfer all elems from AL to A[] 
//         for (int i = LO; i <= HI; i++) {
//             A[i] = AL.get(i - LO);
//         }
//     }
// }