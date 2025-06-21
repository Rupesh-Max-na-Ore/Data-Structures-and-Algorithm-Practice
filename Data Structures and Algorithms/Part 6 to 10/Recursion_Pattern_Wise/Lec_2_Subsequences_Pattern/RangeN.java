package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
/*Q1 type Q in LC
 * 600. Non-negative Integers without Consecutive Ones
Hard
Topics
Companies
Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

 

Example 1:

Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Example 2:

Input: n = 1
Output: 2
Example 3:

Input: n = 2
Output: 3
 

Constraints:

1 <= n <= 109
Seen this question in a real interview before?
1/5
Yes
No
Accepted
39.4K
Submissions
98.9K
Acceptance Rate
39.8%
 */
public class RangeN {
    public int findIntegers(int n) {
        if(n==1) return 2;
        int cnt=2;
        for(int i=2; i<=n; i++)
        {
            int j=i;
            int preR=0;
            int rem=0;
            while(j>0){
                rem=j%2;
                if(preR==1 && rem==1) break;
                preR=rem;
                j=j/2;
                if(j==0) cnt++;
            }
        }
        return cnt;
    }
}
// // 1st attempt, works for small n, O(n*log_2(n)) soln., Time limit exceed for large n like n=1000000000
// class Solution {
//     public int findIntegers(int n) {
//         if(n==1) return 2;
//         int cnt=2;
//         for(int i=2; i<=n; i++)
//         {
//             int j=i;
//             int preR=0;
//             int rem=0;
//             while(j>0){
//                 rem=j%2;
//                 if(preR==1 && rem==1) break;
//                 preR=rem;//1
//                 //rem=j%2;
//                 //preR=rem;//2
//                 j=j/2;
//                 if(j==0) cnt++;
//             }
//         }
//         return cnt;
//     }
// }
//good soln requires DP, will do later.