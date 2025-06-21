package Dynamic_Programming.lec4_Subsequences;
/*Rod Cutting
Difficulty: MediumAccuracy: 60.66%Submissions: 144K+Points: 4
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.

Example:

Input: n = 8, price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.
Input: n = 8, price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.
Your Task:  You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n≤ 1000
1 ≤ price[i] ≤ 105

Seen this question in a real interview before ?
Yes
No
Company Tags
Google */
public class q24_Rod_Cutting {
    public int cutRod(int price[], int n) {
        //code here
        int cur[] = new int[n + 1];
        for (int i = 0; i <= n; i++) cur[i] = i * price[0];
        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= n; j++) {
                int excl = cur[j];
                int incl = Integer.MIN_VALUE;
                if ((ind+1) <= j) incl = price[ind] + cur[j - (ind+1)];
                cur[j] = Math.max(excl, incl);
            }
        }
        return cur[n];
    }
}
