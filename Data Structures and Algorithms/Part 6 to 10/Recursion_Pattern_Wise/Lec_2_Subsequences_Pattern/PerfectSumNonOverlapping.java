package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
/*Q5
 * Perfect Sum Problem
MediumAccuracy: 20.58%Submissions: 277K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
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
0 ≤ arr[i] ≤ 106

 */
public class PerfectSumNonOverlapping {
    //Will write Top-down DP code later, during revision
    //Bottom-up DP code
    public int perfectSum2(int a[],int n, int k) 
	{ 
	    int dp[][]=new int[n+1][k+1];
	    dp[0][0]=1;
	    for(int j=1; j<=k; j++) dp[0][k]=0;
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=k; j++){
	            int excl=dp[i-1][j]%1000000007;
	            int incl=0;
	            int rem=j-a[i-1];
	            if(rem>=0) incl=dp[i-1][rem]%1000000007;
	            dp[i][j]=(excl+incl)%1000000007;
	        }
	    } return dp[n][k];
	}
    //Recursive Soln, trying combos
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
        int r=0;
        if(sum+a[i]<=k)
        r+=recurSub(a, n, k, i+1, sum+a[i])%1000000007;
        return (r+l)%1000000007;
    } 


}
