package Dynamic_Programming.lec4_Subsequences;
/*518. Coin Change II
Solved
Medium
Topics
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
Seen this question in a real interview before?
1/5
Yes
No
Accepted
707.4K
Submissions
1.1M
Acceptance Rate
64.2% */
public class q22_Coin_Change_2 {
    public int change(int target, int[] nums) {
        int n = nums.length;
        int[] p = new int[target + 1];
        //Base
        for (int i = 0; i <= target; i++) p[i] = (i % nums[0] == 0)?1:0;

        //Recurring
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int excl = p[j]; 
                int incl = (nums[i] <= j)?p[j - nums[i]]:0;

                p[j] = incl + excl;
            }
        }

        return p[target];
    }

    
    public int change_(int target, int[] nums) {
        int n = nums.length; //p==prev
        int[] p = new int[target + 1];
        int[] curr = new int[target + 1];
        //Base
        for (int i = 0; i <= target; i++) {
            if (i % nums[0] == 0) {
                p[i] = 1;
            }
        }
        //Recurring
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int excl = p[j]; 
                int incl = 0;

                if (nums[i] <= j) {
                    incl = curr[j - nums[i]]; 
                }

                curr[j] = incl + excl;
            }

            //* Copy curr[] to p[] for the next iter
            System.arraycopy(curr, 0, p, 0, target + 1);
        }

        return p[target];
    }

}
//https://leetcode.com/problems/coin-change-ii/solutions/176706/beginner-mistake-why-an-inner-loop-for-coins-doensn-t-work-java-soln/
