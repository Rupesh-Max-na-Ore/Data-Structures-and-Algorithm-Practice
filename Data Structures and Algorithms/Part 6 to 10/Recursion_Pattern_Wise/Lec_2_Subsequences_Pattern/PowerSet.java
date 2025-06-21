package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.List;

// Q2 LC78
/*78. Subsets
Medium
Topics
Companies
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2M
Submissions
2.5M
Acceptance Rate
78.4%
 */
public class PowerSet {
    public List<List<Integer>> subsets(int[] a) {
        int n=a.length;
        List<List<Integer>> al= new ArrayList<>();
        recurSubset(0, n, a,al,new ArrayList<Integer>());
        return al;
    }

    private void recurSubset(int i, int n, int[] a, List<List<Integer>> al, ArrayList<Integer> setElem) {
        if(i==n) {
            //al.add(setElem);
            al.add(new ArrayList<>(setElem)); // Create a new list to avoid modification issues

            return;
        }

        //Rejecting curr elem
        recurSubset(i+1, n, a, al, setElem);

        //Selecting curr elem
        //below is the wrong attempt
        //it's wrong, as setting new arraylist damages recursive calls 
        // ArrayList<Integer> nextSet = setElem; //nextSet refers to same obj setElem
        // nextSet.add(a[i]); // changes og setElem, damaging recursive calls
        // // recurSubset(i+1, n, a, al, setElem.add(a[i]));
        // recurSubset(i+1, n, a, al, nextSet);
        setElem.add(a[i]);
        recurSubset(i + 1, n, a, al, setElem);
        setElem.remove(setElem.size() - 1); // Remove the last elem to backtrack
        /*
        // another way to do it correctly
         List<Integer> nextSet = new ArrayList<>(setElem); // Create a new list
         nextSet.add(a[i]);
         recurSubset(i + 1, n, a, al, nextSet);
         */
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = ps.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }

    }

   
}
/*// Iterative soln, for revision
 * public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
        /*aidid
Mar 18, 2019
Because the numbers are distinct, 
we know that all unique subsets given a number 
are just the already existing subsets with the new number added. */
// */