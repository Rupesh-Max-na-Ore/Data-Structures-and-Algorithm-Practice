package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.Arrays;

//Q5
/*Perfect Sum Problem
MediumAccuracy: 20.58%Submissions: 276K+Points: 4
Given an array arr of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7.

Example 1:

Input: 
N = 6
arr = [5, 2, 3, 10, 6, 8]
sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.
Example 2:
Input: 
N = 5
arr = [2, 5, 1, 4, 3]
sum = 10
Output: 
3
Explanation: 
{2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
Your Task:  
You don't need to read input or print anything. Complete the function perfectSum() which takes N, array arr and sum as input parameters and returns an integer value.

Expected Time Complexity: O(N*sum)
Expected Auxiliary Space: O(N*sum)

Constraints:
1 ≤ N*sum ≤ 106
0 ≤ arr[i] ≤ 106 */
public class CountSubsequences {
    private static final int MOD = 1_000_000_007;
    //Dynamic Prog. Soln.
    public int perfectSum(int a[], int n, int k) { 
        // Ini. memoization table with -1
        // to indicate that val isn't yet computed
        int[][] memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // handy fn.
        }
        return recurSub(a, n, k, 0, 0, memo);
    }
    //Top-DOwn Approach
    private int recurSub(int[] a, int n, int k, int i, int sum, int[][] memo) {
        if (i == n) {
            return (sum == k)? 1 : 0;
        }
        // If already computed this subproblem, return the stored result
        if (memo[i][sum] != -1) {
            return memo[i][sum];
        }

        // Reject curr elem
        int exclude = recurSub(a, n, k, i + 1, sum, memo) % MOD;

        // Include curr elem if it doesn't exceed the target sum
        int include = 0;
        if (sum + a[i] <= k) {
            include = recurSub(a, n, k, i + 1, sum + a[i], memo) % MOD;
        } // no need to propagate that recursion branch if 
            // including curr elem exceeds the target sum
            // save avg TC

        // Memoize and return the result
        memo[i][sum] = (include + exclude) % MOD;
        return memo[i][sum];
    }

//     // Bottom-up approach 
//     package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

// import java.util.Arrays;

// public class CountSubsequences {
//     private static final int MOD = 1_000_000_007;

//     public int perfectSum(int a[], int n, int k) {
//         int[][] dp = new int[n + 1][k + 1];

//         // Initialize dp table
//         dp[0][0] = 1; // There's exactly one way to get sum 0 with 0 elems (empty subset)
        
//         // Fill the dp table
//         for (int i = 1; i <= n; i++) {
//             dp[i][0] = 1; // There's exactly one way to get sum 0 (empty subset)
//             for (int j = 0; j <= k; j++) {
//                 dp[i][j] = dp[i - 1][j]; // Not including the current elem
//                 if (j >= a[i - 1]) {
//                     dp[i][j] = (dp[i][j] + dp[i - 1][j - a[i - 1]]) % MOD; // Including the current elem
//                 }
//             }
//         }

//         return dp[n][k];
//     }

//     public static void main(String[] args) {
//         CountSubsequences cs = new CountSubsequences();
//         int[] arr1 = {5, 2, 3, 10, 6, 8};
//         int sum1 = 10;
//         System.out.println(cs.perfectSum(arr1, arr1.length, sum1)); // Output: 3

//         int[] arr2 = {2, 5, 1, 4, 3};
//         int sum2 = 10;
//         System.out.println(cs.perfectSum(arr2, arr2.length, sum2)); // Output: 3
//     }
// }

    // SImple soln that works for all normal cases
    // public int perfectSum(int a[],int n, int k) 
	// { 
    //     return recurSub(a,n,k,0,0);
	// }

    // private int recurSub(int[] a, int n, int k, int i, int sum) {
    //     if(i==n){
    //         if (sum==k) return 1;
    //         return 0;
    //     }
    //     //Reject
    //     int l=recurSub(a, n, k, i+1, sum);
    //     //Select
    //     int r=recurSub(a, n, k, i+1, sum+a[i]);
    //     return r+l;
    // }

    public static void main(String[] args) {
        CountSubsequences cs = new CountSubsequences();
        int[] arr1 = {5, 2, 3, 10, 6, 8};
        int sum1 = 8;
        System.out.println(cs.perfectSum(arr1, arr1.length, sum1)); // Output: 3

        int[] arr2 = {2, 5, 1, 4, 3};
        int sum2 = 10;
        System.out.println(cs.perfectSum(arr2, arr2.length, sum2)); // Output: 3
    }
}
/*//Runtime Error 
// Test Cases Passed: 
// 1000 /1120
// Time Limit Exceeded

// Your program took more time than expected.Expected Time Limit : 1.8sec
// Hint : Please optimize your code and submit again.
 * class Solution{

	public int perfectSum(int a[],int n, int k) 
	{ 
        return recurSub(a,n,k,0,0);
	}

    private int recurSub(int[] a, int n, int k, int i, int sum) {
        if(i==n){
            if (sum==k) return 1;
            return 0;
        }
        //Reject
        int l=recurSub(a, n, k, i+1, sum)%1000000007;
        //Select
        int r=recurSub(a, n, k, i+1, sum+a[i])%1000000007;
        return (r+l)%1000000007;
    } 
}
 */
// // Reference DP solution, with  AI generated comments, for revision
// package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

// public class CountSubsequences {
//     private static final int MOD = 1_000_000_007; 
//     // Define a constant for modulo operation to handle large numbers

//     // Function to count the number of subsets with a given sum
//     public int perfectSum(int a[], int n, int k) {
//         // Create a 2D array dp where dp[i][j] will store the number of subsets 
//         // of the first i elements that sum up to j
//         int[][] dp = new int[n + 1][k + 1];

//         // Base case: There's exactly one way to get sum 0 with 0 elements, which is by taking an empty subset
//         dp[0][0] = 1;

//         // Fill the dp table iteratively
//         for (int i = 1; i <= n; i++) {
//             // There's exactly one way to get sum 0 (by taking an empty subset), regardless of the number of elements
//             dp[i][0] = 1;
//             for (int j = 0; j <= k; j++) {
//                 // Not including the current element: number of ways to get sum j using the first i-1 elements
//                 dp[i][j] = dp[i - 1][j];
//                 // Including the current element a[i-1], if it doesn't exceed the current sum j
//                 if (j >= a[i - 1]) {
//                     // Add the number of ways to get sum (j - a[i-1]) using the first i-1 elements
//                     dp[i][j] = (dp[i][j] + dp[i - 1][j - a[i - 1]]) % MOD;
//                 }
//             }
//         }

//         // The answer is the number of ways to get sum k using all n elements
//         return dp[n][k];
//     }

//     // Main method for testing the function
//     public static void main(String[] args) {
//         CountSubsequences cs = new CountSubsequences();
//         int[] arr1 = {5, 2, 3, 10, 6, 8};
//         int sum1 = 10;
//         // Output: 3 (subsets are {5, 2, 3}, {2, 8}, and {10})
//         System.out.println(cs.perfectSum(arr1, arr1.length, sum1));

//         int[] arr2 = {2, 5, 1, 4, 3};
//         int sum2 = 10;
//         // Output: 3 (subsets are {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3})
//         System.out.println(cs.perfectSum(arr2, arr2.length, sum2));
//     }
// }
// //gfg submission
// class Solution{

// 	public int perfectSum(int a[],int n, int k) 
// 	{ 
// 	    int dp[][]=new int[n+1][k+1];
// 	    dp[0][0]=1;
// 	    for(int j=1; j<=k; j++) dp[0][k]=0;
// 	    for(int i=1; i<=n; i++){
// 	        for(int j=0; j<=k; j++){
// 	            int excl=dp[i-1][j]%1000000007;
// 	            int incl=0;
// 	            int rem=j-a[i-1];
// 	            if(rem>=0) incl=dp[i-1][rem]%1000000007;
// 	            dp[i][j]=(excl+incl)%1000000007;
// 	        }
// 	    } return dp[n][k];
// 	}

// }