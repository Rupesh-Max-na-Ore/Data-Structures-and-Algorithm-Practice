package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
//q6
/* Subset Sum
Moderate
80/80
Average time to solve is 25m
Contributed by
39 upvotes
Problem statement
You are given an array 'A' of 'N' integers. You have to return true if there exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return false.



For Example
'N' = 3, 'K' = 5, 'A' = [1, 2, 3].
Subset [2, 3] has sum equal to 'K'.
So our answer is True.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 13
4 3 5 2
Sample Output 1 :
No
Sample Input 2 :
5 14
4 2 5 6 7
Sample Output 2 :
Yes
Constraints :
1 <= 'N' <= 10^3
1 <= 'A[i]' <= 10^3
1 <= 'K' <= 10^3
Time Limit: 1 sec
 */
public class SubsetWithSumKorNot {
    // Normal recursive soln, as chapter intended
    public static boolean isSubsetPresent(int n, int k,int []a) {
        return recurSub(a,n,k,0,0);
    }

    private static boolean recurSub(int[] a, int n, int k, int i, int sum) {
        // Base Case
        if(i==n){
            if(sum==k) return true;
            return false;
        }
        //Reject ith elem
        boolean excl=recurSub(a, n, k, i+1, sum);
        //Select ith elem
        boolean incl=((sum+a[i])<=k)? recurSub(a, n, k, i+1, sum+a[i]): false;

        return (incl||excl);

    }
    /*
    TLE for TC 6
    94 84
    22 17 19 46 48 27 22 39 20 13 18 50 36 45 4 12 23 34 24 15 42 12 4 19 48 45 13 8 38 10 24 42 30 29 17 36 41 43 39 7 41 43 15 49 47 6 41 30 21 1 7 2 44 49 30 24 35 5 7 41 17 27 32 9 45 40 27 24 38 39 19 33 30 42 34 16 40 9 5 31 28 7 24 37 22 46 25 23 21 30 28 24 48 13 
    true
    */

}
// //Code 360 submission, using bottom up DP approach
// public class Solution {
//     public static boolean isSubsetPresent(int n, int k,int []a) {
//         // Write your code here
//         int dp[][]=new int[n+1][k+1];
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
// 	    } return (dp[n][k]>0);

//     }
// }


// Code 360 editorial, optimal solution using dp, pasted here to revise
// /*
//     Time Complexity: O(N*K)
//     Space Complexity: O(N*K)

//     where 'N'is the length of the array 'A' and 'K' is the given sum.
// */
// public class Solution {
//     public static boolean isSubsetPresent(int n, int k,int []a) {
//         // dp[i][j] is true if we can create 'A' subset sum of 'j' from first 'i' elements.
//         boolean [][]dp = new boolean[n + 1][];

//         // If 'K' is 0, then answer is true.
//         for (int i = 0; i <= n; i++)
//         {
//             dp[i] = new boolean[k + 1];
//             dp[i][0] = true;
//         }

//         // If 'K' ' is not 0 and 'N' is 0, the answer is false.
//         for (int i = 1; i <= k; i++)
//         {
//             dp[0][i] = false;
//         }

//         // Fill the table in bottom up manner.
//         for (int i = 1; i <= n; i++)
//         {
//             for (int j = 1; j <= k; j++)
//             {
//                 if (j < a[i - 1])
//                 {
//                     dp[i][j] = dp[i - 1][j];
//                 }
//                 else
//                 {
//                     dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
//                 }
//             }
//         }

//         return dp[n][k];
//     }
// }