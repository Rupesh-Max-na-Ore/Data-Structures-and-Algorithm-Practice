package Dynamic_Programming.lec4_Subsequences;
/*Perfect Sum Problem
Difficulty: MediumAccuracy: 20.58%Submissions: 414K+Points: 4
Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7.

Examples:

Input: 
n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.
Input: 
n = 5, arr = [2, 5, 1, 4, 3], sum = 10
Output: 
3
Explanation: 
{2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.

Expected Time Complexity: O(n*sum)
Expected Auxiliary Space: O(n*sum)

Constraints:
1 ≤ n*sum ≤ 106
0 ≤ arr[i] ≤ 106

 Count Subsets with Sum K
Moderate
0/80
Contributed by
430 upvotes
Asked in company
Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.



Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.



Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.



Example:
Input: 'arr' = [1, 1, 4, 5]

Output: 3

Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 5
1 4 4 5


Sample Output 1 :
 3


Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.


Sample Input 2 :
3 2
1 1 1


Sample Output 2 :
3


Explanation For Sample Output 1:
There are three 1 present in the array. Answer is the number of ways to choose any two of them.


Sample Input 3 :
3 40
2 34 5


Sample Output 3 :
0


Expected time complexity :
The expected time complexity is O('n' * 'k').


Constraints:
1 <= 'n' <= 100
0 <= 'arr[i]' <= 1000
1 <= 'k' <= 1000

Time limit: 1 sec

Problem case: 3 4
0 1 3

*/
public class q17_Count_Subsets_with_Sum_K {
    public static int findWays(int a[], int k) {
        // Write your code here.
        int m = 1000000007;
        int[] bottom = new int[k+1];
        bottom[0]=(a[0]==0)?2:1;
        //Imp addition is && a[0] != 0 in condn.
        if(a[0]<=k && a[0] != 0) bottom[a[0]]=1;
        for(int i=1;i<a.length;i++){
            int[] up = new int[k+1];
            up[0]=(a[0]==0)?2:1;
            //even below works
            //up[0]=1;
            for(int j=1;j<=k;j++){
                int e = a[i];
                int incl=(e <= j)?bottom[j-e]:0;
                int excl=bottom[j];
                up[j]=(incl+excl)%m;
            }
            bottom = up;
        } return bottom[k];
    }

    //Logic correct
    // public static int findWays(int a[], int k) {
    //     // Write your code here.
    //     int[] bottom = new int[k+1];
    //     bottom[0]=1;
    //     if(a[0]<=k) bottom[a[0]]=1;
    //     for(int i=1;i<a.length;i++){
    //         int[] up = new int[k+1];
    //         up[0]=1;
    //         for(int j=1;j<=k;j++){
    //             int e = a[i];
    //             int incl=(e <= j)?bottom[j-e]:0;
    //             int excl=bottom[j];
    //             up[j]=incl+excl;
    //         }
    //         bottom = up;
    //     } return bottom[k];
    // }
}
/*import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {
// Write your code here.
int n = num.length;
int m = (int)(1e9+7);
long[][] dp = new long[n][tar+1];
// for(int i=0;i<n;i++) dp[i][0] = 1;
// if(num[0] <= tar) dp[0][num[0]] = 1;
for(int i=0;i<n;i++) {
for(int j=0;j<=tar;j++) {
if(i == 0) {
if(j == 0 && num[i] == 0) dp[i][j] = 2;
else if(j == 0 || j == num[i]) dp[i][j] = 1;
else dp[i][j] = 0;
continue;
}
long take = 0;
long notTake = dp[i-1][j]%m;
if(num[i] <= j) take = dp[i-1][j-num[i]]%m;
dp[i][j] = (take%m + notTake%m)%m;
}
}
return (int)(dp[n-1][tar]%m);
}
} */
/*	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n][sum+1];


        for(int currArr=0;currArr<n;currArr++){
            for(int currSum=0;currSum<=sum;currSum++){
                // if current Value added to sub array is itself
                // equal to the current sum
                int sameSum = (arr[currArr] == currSum) ? 1 : 0;
                // Is the current Sum possible by old values of 
                // current Array
                int oldSum  = (currArr>0 && dp[currArr-1][currSum] != 0) ? dp[currArr-1][currSum] : 0 ;
                // if some old subarray + new value add up to 
                // current Sum, than add that as well.
                int partial = (currArr > 0 && currSum-arr[currArr] > -1 && dp[currArr-1][currSum-arr[currArr]] != 0) ? dp[currArr-1][currSum-arr[currArr]] : 0;
                // Sum of all cases is total value
                dp[currArr][currSum] = (sameSum + oldSum + partial)%1000000007;
            }
        }

        return dp[n-1][sum];
	} 
 */