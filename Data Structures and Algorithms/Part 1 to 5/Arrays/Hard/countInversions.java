package Arrays.Hard;
// //q10
// Count inversions in an array

import java.util.ArrayList;

// 26

// 0
// Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

// What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

// Examples
// Example 1:
// Input Format
// : N = 5, array[] = {1,2,3,4,5}
// Result
// : 0
// Explanation
// : we have a sorted array and the sorted array has 0 inversions as 
// for i < j you will never find a pair such that A[j] < A[i]. 
// More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

// Example 2:
// Input Format
// : N = 5, array[] = {5,4,3,2,1}
// Result
// : 10
// Explanation
// : we have a reverse sorted array and we will get the maximum inversions 
// as for i < j we will always find a pair such that A[j] < A[i]. 
// Example: 5 has index 0 and 3 has index 2 now (5,3) pair 
// is inversion as 0 < 2 and 5 > 3 which will satisfy out conditions 
// and for reverse sorted array we will get maximum inversions and 
// that is (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

// Example 3:
// Input Format
// : N = 5, array[] = {5,3,2,1,4}
// Result
// : 7
// Explanation
// : There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) 
// and we have Lft 2 pairs (2,4) and (1,4) as both are not satisfy our condition. 
public class countInversions {
    private static int merge(int[] A, int LO, int MID, int HI) {
        ArrayList<Integer> AL = new ArrayList<>(); 
        int Lft = LO;      // start i of Lft half of subarr
        int Rit = MID + 1;   // start i of Rit half of subarr

        //MOD 1: cnt variable to keep track of #inversions
        int cnt = 0;

        //storing elems in the AL arraylist in a sorted manner

        while (Lft <= MID && Rit <= HI) {
             if(A[Lft]>A[Rit]) // condn. for Inversion pair
             {
                AL.add(A[Rit]);
                cnt += (MID - Lft + 1); //MOD 2 - take advantage of sorted Lft subarr to update cnt+= |>= +1|, on avg
                Rit++;
            }
            else if (A[Lft] <= A[Rit]) // condn. for Non-Inversion pair
            {
                AL.add(A[Lft]);
                Lft++;
            }
        }

        // if elems on the Lft half still remaining

        while (Lft <= MID) {
            AL.add(A[Lft]);
            Lft++;
        }

        //  if elems on the Rit half are still remaining
        while (Rit <= HI) {
            AL.add(A[Rit]);
            Rit++;
        }

        // transfer all elems from AL to A //
        for (int i = LO; i <= HI; i++) {
            A[i] = AL.get(i - LO);
        }
        return cnt; // MOD 3
    }

    public static int mergeSort(int[] A, int LO, int HI) {
        int cnt = 0;
        if (LO >= HI) return cnt;
        int MID = (LO + HI) / 2 ;
        cnt += mergeSort(A, LO, MID);  // Lft half
        cnt += mergeSort(A, MID + 1, HI); // Rit half
        cnt += merge(A, LO, MID, HI);  // merging sorted halves
        return cnt;
    }

    public static int numberOfInversions(int[] a, int n) {
        // Count no. of Inversion pairs
        return mergeSort(a, 0, n - 1);
    }


    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = numberOfInversions(a, n);
        System.out.println("The number of inversions are: " + cnt);
    }
}


// gfg submission 2, 1 failed because of I learnt gfg compiler is ancient with lethargy for Arraylist
// changed to array insted of Arraylist because Long wrapper class, I didn't want to get into it now
// will learn later
// import java.util.ArrayList;

// class Solution {
//     // arr[]: Input Array
//     // N : Size of the Array arr[]
//     // Function to count inversions in the array.
//     static long inversionCount(long arr[], long N) {
//         return mergeSort(arr, 0, (int) N - 1);
//     }

//     public static long mergeSort(long[] A, int LO, int HI) {
//         long cnt = 0;
//         if (LO >= HI) return cnt;
//         int MID = (LO + HI) / 2;
//         cnt += mergeSort(A, LO, MID);  // Left half
//         cnt += mergeSort(A, MID + 1, HI); // Right half
//         cnt += merge(A, LO, MID, HI);  // merging sorted halves
//         return cnt;
//     }

//     private static long merge(long[] A, int LO, int MID, int HI) {
//         long[] temp = new long[HI - LO + 1];
//         int Lft = LO; // start index of Left half of subarray
//         int Rit = MID + 1; // start index of Right half of subarray

//         // Count variable to keep track of number of inversions
//         long cnt = 0;
//         int k = 0;

//         // Storing elements in the temp array in a sorted manner
//         while (Lft <= MID && Rit <= HI) {
//             if (A[Lft] <= A[Rit]) {
//                 temp[k++] = A[Lft++];
//             } else {
//                 temp[k++] = A[Rit++];
//                 cnt += (MID - Lft + 1); // Count inversions
//             }
//         }

//         // If elements on the Left half are still remaining
//         while (Lft <= MID) {
//             temp[k++] = A[Lft++];
//         }

//         // If elements on the Right half are still remaining
//         while (Rit <= HI) {
//             temp[k++] = A[Rit++];
//         }

//         // Transfer all elements from temp to A
//         for (int i = 0; i < temp.length; i++) {
//             A[LO + i] = temp[i];
//         }
//         return cnt;
//     }
// }
