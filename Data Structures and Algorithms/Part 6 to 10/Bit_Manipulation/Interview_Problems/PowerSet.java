package Bit_Manipulation.Interview_Problems;
/*Q3 78. Subsets
Solved
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
78.5% */
import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    //using bit manip, recursive alredy done
    public List<List<Integer>> subsets(int[] a) {
        int n=a.length; int subsets=1<<n;
        List<List<Integer>> al= new ArrayList<>();
        for(int j=0; j< subsets; j++){
            List<Integer> CurrSub= new ArrayList<>();
            for(int i=0; i<n; i++){
                //if ith bit set, add corresponding elem from a[] to current set
                if((j & (1<<i))!=0) CurrSub.add(a[i]);
            } al.add(CurrSub);
        }
        return al;
    }
    
}
