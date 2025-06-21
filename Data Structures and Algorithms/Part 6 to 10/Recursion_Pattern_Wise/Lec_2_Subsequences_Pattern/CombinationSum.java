package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] a, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=a.length;
        recurCSum(a, n, k, 0, ans, new ArrayList<Integer>());
        return ans;
    }

    private void recurCSum(int[] a, int n, int k, int i, List<List<Integer>> ans, ArrayList<Integer> combo) {
        if(i==n){
            if(k==0) ans.add(new ArrayList<>(combo));
            return;
        }
        //if(a[i]>k) return; //fatal mistake
        //if(k<0) return; //optional
        //select curr elem
        if(a[i]<=k){
            combo.add(a[i]);
            recurCSum(a, n, k-a[i], i, ans, combo);
            combo.remove(combo.size()-1);
        }
        //reject current elem
        recurCSum(a, n, k, i+1, ans, combo);
    }

}
// // /*//fastest soln of LC
// import java.util.AbstractList;

// class Solution {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         return new AbstractList<List<Integer>>() {

//             private List<List<Integer>> resList;

//             private void onload() {
//                 resList = new ArrayList<List<Integer>>();
//                 Arrays.sort(candidates);
//                 findCombination(0, target, new ArrayList<Integer>());
//             }

            // private void findCombination(int index, int target, ArrayList<Integer> elements) {
            //     if (0 == target) {
            //         resList.add(new ArrayList<Integer>(elements));
            //         return;
            //     }

            //     if (target < 0 || index == candidates.length) {
            //         return;
            //     }

            //     for (int i = index; i < candidates.length; i++) {
            //         if (target >= candidates[i]) {
            //             elements.add(candidates[i]);

            //             findCombination(i, target - candidates[i], elements);
            //             elements.remove(elements.size() - 1);
            //         } else {
            //             /**
            //              * The array is sorted
            //              * , and subsequent elements are larger than the current element
            //              * , so there is no need to search again.
            //              *
            //              */
            //             break;
            //         }
//                 }
//             }

//             private void init() {
//                 if (null == resList) {
//                     onload();
//                     System.gc();
//                 }
//             }

//             @Override
//             public List<Integer> get(int index) {
//                 init();
//                 return resList.get(index);
//             }

//             @Override
//             public int size() {
//                 init();
//                 return resList.size();
//             }
//         };
//     }
// }
//  */
//Ai generated comments, for easy revision later
/*
 import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] a, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = a.length;
        recurCSum(a, n, k, 0, ans, new ArrayList<Integer>());
        return ans;
    }

    private void recurCSum(int[] a, int n, int k, int i, List<List<Integer>> ans, ArrayList<Integer> combo) {
        // If the current sum is zero, add the combination to the answer list
        if (k == 0) {
            ans.add(new ArrayList<>(combo));
            return;
        }

        // If the index exceeds the length of the array or the current sum is negative, return
        if (i >= n || k < 0) {
            return;
        }

        // Select the current element
        if (a[i] <= k) {
            combo.add(a[i]);
            recurCSum(a, n, k - a[i], i, ans, combo); // Recur with the same index
            combo.remove(combo.size() - 1); // Backtrack
        }

        // Reject the current element and move to the next
        recurCSum(a, n, k, i + 1, ans, combo);
    }
}

 */