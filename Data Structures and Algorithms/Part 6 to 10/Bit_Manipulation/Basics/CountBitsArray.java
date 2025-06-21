package Bit_Manipulation.Basics;
/*Q5 related Q on lc
 * 338. Counting Bits
Easy
Topics
Companies
Hint
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105
 

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.1M
Submissions
1.4M
Acceptance Rate
78.4%
 */
public class CountBitsArray {
    public int[] countBits(int n) {
        int a[]=new int[n+1];
        a[0]=0;
        //a[n] = a[n/2] + last bit set or not(ie,1 if odd and 0 if even)
        for(int i=0; i<=n;i++) a[i]=a[i>>1]+(i&1);
        return a;
    }
}
// a general method based on different observation- https://leetcode.com/problems/counting-bits/solutions/79557/how-we-handle-this-question-on-interview-thinking-process-dp-solution/