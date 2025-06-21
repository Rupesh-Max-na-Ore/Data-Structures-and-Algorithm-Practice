package Dynamic_Programming.lec4_Subsequences;
/*416. Partition Equal Subset Sum
Medium
Topics
Companies
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
Accepted
958.1K
Submissions
2M
Acceptance Rate
46.8% */
public class q15_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for(int e:nums) s+=e;
        if(s%2==1)return false;
        return isSubsetSum(nums, s/2);
    }

    private Boolean isSubsetSum(int a[], int k) {
        boolean[] prev = new boolean[k+1];
        prev[0]=true;
        if (a[0] <= k) prev[a[0]]=true;
        int n = a.length;

        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int j = 1; j<=k; j++){
                boolean incl = (j>=a[i])?prev[j-a[i]]:false;
                boolean excl = prev[j];

                curr[j] = incl||excl;
            }
            prev=curr;
        }

        return prev[k];

    }
}
