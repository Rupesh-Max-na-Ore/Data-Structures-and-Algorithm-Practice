package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Q10 90. Subsets II
Medium
Topics
Companies
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
Seen this question in a real interview before?
1/5
Yes
No
Accepted
935.4K
Submissions
1.6M
Acceptance Rate
57.5%
 */
public class SubsetSum02 {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        //List<Integer> current = new ArrayList<>();
        int n=a.length;
        Arrays.sort(a); // Sort the a[] to handle duplicates
        //recurSub2(a, n, 0, current, ans);
        recurSub2(a, n, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void recurSub2(int[] a, int n, int i, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));// add prev elem set to list of subsets 
        if(i==n) return;//optional
        //Iterate over possible next elem to make curr set, which is superset of prev set 
        for(int j=i;j<n;j++){
            if(j>i && a[j]==a[j-1]) continue; //skip duplicates at this level
            current.add(a[j]);//add elem for current set as last elem, superset of prev set
            //if((j+1)<n)
            recurSub2(a, n, j+1, current, ans);//for next supersets
            current.remove(current.size()-1);// backtrack to prev set, subset of curr set
        }
    }

    public static void main(String[] args) {
        SubsetSum02 obj = new SubsetSum02();

        // Test Case 1: Simple case with duplicates
        int[] nums1 = {1, 2, 2};
        System.out.println("Test Case 1: " + obj.subsetsWithDup(nums1));

        // Test Case 2: No duplicates
        int[] nums2 = {1, 2, 3};
        System.out.println("Test Case 2: " + obj.subsetsWithDup(nums2));

        // Test Case 3: Single element
        int[] nums3 = {0};
        System.out.println("Test Case 3: " + obj.subsetsWithDup(nums3));

        // Test Case 4: All elements are the same
        int[] nums4 = {1, 1, 1};
        System.out.println("Test Case 4: " + obj.subsetsWithDup(nums4));

        // Test Case 5: Larger set with duplicates
        int[] nums5 = {4, 4, 4, 1, 4};
        System.out.println("Test Case 5: " + obj.subsetsWithDup(nums5));
    }
}
/*
 * //another way to do it using hashset
 * //
 * class Solution {

    HashMap<String, Boolean> map;
    List<List<Integer>> answer;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        map = new HashMap<String, Boolean>();
        answer = new ArrayList<>();

        // Count Sort - O(k)
        int[] countMap = new int[21];
        for (int num : nums) countMap[num + 10]++;
        for (int i = 0, j = 0; i < 21; i++) while (countMap[i]-- > 0) nums[j++] = i - 10;
        // Sorting done !

        List<Integer> empty = new ArrayList<>();
        addSubSets(empty, 0, nums);
        return answer;
    }

    private void addSubSets(List<Integer> curSet, int pos, int[] set) {
        answer.add(curSet);

        for (int i = pos; i < set.length; i++) {

            if (i == pos || set[i] != set[i - 1]) {
                List<Integer> nextSet = new ArrayList<>(curSet);
                nextSet.add(set[i]);
                addSubSets(nextSet, i + 1, set);
            }
        }
    }
}
 */