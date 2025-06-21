package Dynamic_Programming.lec4_Subsequences;
/*Subset Sum Problem
Difficulty: MediumAccuracy: 32.0%Submissions: 276K+Points: 4
Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

Examples:

Input: arr[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: true 
Explanation: Here there exists a subset with sum = 9, 4+3+2 = 9.
Input: arr[] = {3, 34, 4, 12, 5, 2} , sum = 30
Output: false
Explanation: There is no subset with sum 30.
Expected Time Complexity: O(sum*n)
Expected Auxiliary Space: O(sum*n)

Constraints:
1 <= n <= 200
1<= arr[i] <= 200
1<= sum <= 4*104 */
public class q14_Subset_sum_equal_to_target {
    static Boolean isSubsetSum(int a[], int k) {
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
