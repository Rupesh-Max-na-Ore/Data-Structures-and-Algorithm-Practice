
/*2484. Count Palindromic Subsequences
Hard
Topics
Companies
Hint
Given a string of digits s, return the number of palindromic subsequences of s having length 5. Since the answer may be very large, return it modulo 109 + 7.

Note:

A string is palindromic if it reads the same forward and backward.
A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 

Example 1:

Input: s = "103301"
Output: 2
Explanation: 
There are 6 possible subsequences of length 5: "10330","10331","10301","10301","13301","03301". 
Two of them (both equal to "10301") are palindromic.
Example 2:

Input: s = "0000000"
Output: 21
Explanation: All 21 subsequences are "00000", which is palindromic.
Example 3:

Input: s = "9999900000"
Output: 2
Explanation: The only two palindromic subsequences are "99999" and "00000".
 

Constraints:

1 <= s.length <= 104
s consists of digits.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
15.2K
Submissions
38.8K
Acceptance Rate
39.3%
Topics
String
Dynamic Programming
Companies
Hint 1
There are 100 possibilities for the first two characters of the palindrome.
Hint 2
Iterate over all characters, letting the current character be the center of the palindrome.
Similar Questions
Arithmetic Slices II - Subsequence
Hard
Count Different Palindromic Subsequences
Hard
Unique Length-3 Palindromic Subsequences
Medium */

import java.util.Arrays;

public class q9_Count_Palindromic_Subsequences {
    final long MOD = 1_000_000_007;

    private int givrev(int x) {//for 2 digit only
        if (x < 10) {
            return x * 10;
        }
        return ((x % 10) * 10) + (x / 10);
    }

    public int countPalindromes(String s) {
        long[] forwardcnt = new long[10];
        long[] backwardcnt = new long[10];
        long[] subfront = new long[100];
        long[] subback = new long[100];
        long ans = 0;

        // Backward pass: build subback table
        for (int i = s.length() - 1; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                if (backwardcnt[j] > 0) {
                    subback[x * 10 + j] += backwardcnt[j];
                }
            }
            backwardcnt[x]++;
        }

        // Forward pass: compute palindrome counts
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            backwardcnt[x]--;
            for (int j = 0; j < 10; j++) {
                if (backwardcnt[j] > 0) {
                    subback[x * 10 + j] -= backwardcnt[j];
                }
            }

            for (int j = 0; j < 100; j++) {
                ans = (ans + subfront[j] * subback[givrev(j)] % MOD) % MOD;
            }

            for (int j = 0; j < 10; j++) {
                if (forwardcnt[j] > 0) {
                    subfront[j * 10 + x] += forwardcnt[j];
                }
            }
            forwardcnt[x]++;
        }

        return (int) ans;
    }
}
//another way, same intuition
//https://leetcode.com/problems/count-palindromic-subsequences/solutions/2850466/c-java-python3-counting-prefixes-and-suffixes
class Solution {
    public int countPalindromes(String s) {
    int mod = 1000_000_007, n = s.length(), ans = 0, cnts[] = new int[10],
    pre[][][] = new int[n][10][10], suf[][][] = new int[n][10][10];
    for (int i = 0; i < n; i++) {
        int c = s.charAt(i) - '0';
        if (i > 0)
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++) {
                    pre[i][j][k] = pre[i - 1][j][k];
                    if (k == c) pre[i][j][k] += cnts[j];
                }
        cnts[c]++;
    }
    Arrays.fill(cnts, 0);
    for (int i = n - 1; i >= 0; i--) {
        int c = s.charAt(i) - '0';
        if (i < n - 1)
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++) {
                    suf[i][j][k] = suf[i + 1][j][k];
                    if (k == c) suf[i][j][k] += cnts[j];
                }
        cnts[c]++;
    }
    for (int i = 2; i < n - 2; i++)
        for (int j = 0; j < 10; j++)
            for (int k = 0; k < 10; k++)
                ans = (int)((ans + 1L * pre[i - 1][j][k] * suf[i + 1][j][k]) % mod);
    return ans;
}
}