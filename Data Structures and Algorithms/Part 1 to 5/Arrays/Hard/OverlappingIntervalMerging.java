package Arrays.Hard;
// // q7
// Merge Overlapping Sub-intervals


// 26

// 0
// Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

// Examples
// Example 1:
// Example 1:
// Input:
//  intervals=[[1,3],[2,6],[8,10],[15,18]]

// Output:
//  [[1,6],[8,10],[15,18]]

// Explanation:
//  Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
//  intervals.

// Example 2:
// Input:
//  [[1,4],[4,5]]

// Output:
//  [[1,5]]

// Explanation:
//  Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervalMerging {
    public static List<List<Integer>> mergeOverlappingIntervals(int[][] A) {
        int n = A.length; // size of the array
        //sort the given intervals, by giving own implementation of -
        // that is overriding comparator fn, via anonymous inner class
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> AL = new ArrayList<>();
        AL.add(Arrays.asList(A[0][0],A[0][1]));
        for (int i = 1; i < n; i++) {
            int lastelem=AL.size() - 1;
            // if no overlap b/w end of last elem of AL and start of A[i](i.e., A[i][0])
            if (AL.isEmpty() || A[i][0] > AL.get(lastelem).get(1)) {
                AL.add(Arrays.asList(A[i][0], A[i][1]));
            }
            // if overlap, update end to whichever greater, it itself currently or end ofA[i](i.e., A[i][1])
            else {
                AL.get(lastelem).set(1,Math.max(AL.get(lastelem).get(1), A[i][1]));
            }
        }
        return AL; //in case ask ans in matrix form use ALto2DmatrixSize2(AL)
    }
    public static int[][] ALto2DmatrixSize2(List<List<Integer>> AL){
        int l=AL.size();
        int [][]A =new int[l][2];
        for(int i=0;i<l;i++){
            A[i][0]=AL.get(i).get(0);
            A[i][1]=AL.get(i).get(1);
        }

        return A;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ansAL = mergeOverlappingIntervals(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ansAL) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}

// //lc submission
// class Solution {
//     public int[][] merge(int[][] A) {
//          int n = A.length; // size of the array
//         //sort the given intervals, by giving own implementation of -
//         // that is overriding comparator fn, via anonymous inner class
//         Arrays.sort(A, new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                 return a[0] - b[0];
//             }
//         });

//         List<List<Integer>> AL = new ArrayList<>();
//         AL.add(Arrays.asList(A[0][0],A[0][1]));
//         for (int i = 1; i < n; i++) {
//             int lastelem=AL.size() - 1;
//             // if no overlap b/w end of last elem of AL and start of A[i](i.e., A[i][0])
//             if (AL.isEmpty() || A[i][0] > AL.get(lastelem).get(1)) {
//                 AL.add(Arrays.asList(A[i][0], A[i][1]));
//             }
//             // if overlap, update end to whichever greater, it itself currently or end ofA[i](i.e., A[i][1])
//             else {
//                 AL.get(lastelem).set(1,Math.max(AL.get(lastelem).get(1), A[i][1]));
//             }
//         }
//         return ALto2DmatrixSize2(AL);
//     }

//     public static int[][] ALto2DmatrixSize2(List<List<Integer>> AL){
//         int l=AL.size();
//         int [][]A =new int[l][2];
//         for(int i=0;i<l;i++){
//             A[i][0]=AL.get(i).get(0);
//             A[i][1]=AL.get(i).get(1);
//         }

//         return A;
//     }
// }