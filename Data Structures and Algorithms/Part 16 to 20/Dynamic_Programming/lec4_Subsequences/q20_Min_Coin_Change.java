package Dynamic_Programming.lec4_Subsequences;
/*322. Coin Change
Medium
Topics
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2M
Submissions
4.5M
Acceptance Rate
45.1% */
public class q20_Min_Coin_Change {
    //Can be little hard to do fast. Do normal space optimization in that case
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] p=new int [amount+1];
        for(int j=1;j<=amount;j++) p[j] = ((j%coins[0])==0)?(j/coins[0]):Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                //we can skip j = 0 to coin[i]-1, as they will always be p[j]
                if(p[j-coins[i]]==Integer.MAX_VALUE) continue;
                p[j]=Math.min((1+p[j-coins[i]]),(p[j]));
            }
        } //return p[amount];
        if(p[amount]==Integer.MAX_VALUE) return -1;
        //else
        return p[amount];
    }

    //Rit answer, wrong explanation
    public int coinChange_(int[] coins, int amount) {
        int n = coins.length;
        int[] p=new int [amount+1];
        for(int j=1;j<=amount;j++) p[j] = ((j%coins[0])==0)?(j/coins[0]):Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=i;j<=amount;j++){
                //we can skip j = 0 to i-1, as they will always be p[j]
                if(j>=coins[i] && p[j-coins[i]]==Integer.MAX_VALUE) continue;
                if(j>=coins[i])p[j]=Math.min((1+p[j-coins[i]]),(p[j]));
            }
        } //return p[amount];
        if(p[amount]==Integer.MAX_VALUE) return -1;
        //else
        return p[amount];
    }
}
/* */
/*Why j starts from coins[i]: The value j represents the amount 
we are trying to form using the current set of coins. 
Starting j from coins[i] ensures that we only attempt to 
update the dp[j] for amounts that are at least as large 
as the current coin's denomination. If j < coins[i], 
it is impossible to use that coin to form the amount.

Why not start from 0 or i:

0: Starting from 0 would be inefficient 
because dp[j] for j < coins[i] 
will remain unchanged 
(as the current coin cannot contribute to 
amounts smaller than its value).
i: This is incorrect because 
i refers to the index of the coin in the array, 
not an amount. The inner loop should iterate over 
the possible amounts, not the coin indices. */