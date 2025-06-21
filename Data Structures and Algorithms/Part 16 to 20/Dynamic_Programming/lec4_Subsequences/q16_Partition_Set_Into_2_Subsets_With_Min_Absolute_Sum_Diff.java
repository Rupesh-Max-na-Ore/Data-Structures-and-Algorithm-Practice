package Dynamic_Programming.lec4_Subsequences;
/*2035. Partition Array Into Two Arrays to Minimize Sum Difference
Hard
Topics
Companies
Hint
You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.

Return the minimum possible absolute difference.

 

Example 1:

example-1
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
Example 2:

Input: nums = [-36,36]
Output: 72
Explanation: One optimal partition is: [-36] and [36].
The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.
Example 3:

example-3
Input: nums = [2,-1,0,4,-2,-9]
Output: 0
Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.
 

Constraints:

1 <= n <= 15
nums.length == 2 * n
-107 <= nums[i] <= 107
Accepted
32.3K
Submissions
154.8K
Acceptance Rate
20.8% */
public class q16_Partition_Set_Into_2_Subsets_With_Min_Absolute_Sum_Diff {
    public int minimumDifference(int[] a) {
        int n = a.length;
        int s=0;
        for(int e:a)s+=e;
        boolean[]lastRow=isSubsetSum(a, s);
        int minDiff=Integer.MAX_VALUE;
        for(int j=0; j<=s; j++){
            if(lastRow[j]!=true) continue;
            minDiff = Math.min(minDiff, Math.abs(j-(s-j)));
        }
        return minDiff;
    }

    boolean[] isSubsetSum(int a[], int k) {
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

        return prev;

    }
}
/*
// Function to calculate the minimum absolute difference of two subsets
    static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create an array to store DP results for the previous row
        boolean[] prev = new boolean[totSum + 1];

        // Initialize the DP array for the first row
        prev[0] = true;

        // Initialize the DP array for the first column
        if (arr.get(0) <= totSum) {
            prev[arr.get(0)] = true;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store DP results for the current row
            boolean[] cur = new boolean[totSum + 1];
            cur[0] = true;
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = prev[target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = prev[target - arr.get(ind)];
                }

                // Update the DP array for the current element and target sum
                cur[target] = notTaken || taken;
            }
            prev = cur;
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
 */