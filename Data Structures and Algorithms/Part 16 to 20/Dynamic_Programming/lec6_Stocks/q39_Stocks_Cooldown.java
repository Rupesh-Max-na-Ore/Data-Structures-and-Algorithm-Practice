package Dynamic_Programming.lec6_Stocks;

public class q39_Stocks_Cooldown {
    //If any no. of transactions, but space optimised
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int cool=1;
        int[][]dp=new int[cool+2][2];
        for(int i=n-1;i>=0;i--){
            dp[0][0]=Math.max(-prices[i]+dp[1][1], dp[1][0]);
            dp[0][1]=Math.max(prices[i]+((i<=n-1-cool)?dp[1+cool][0]:0), dp[1][1]);
            for(int j=0;j<=cool;j++) dp[j]=dp[j+1].clone();
        }
        return dp[0][0];
    }

    //If any no. of transactions
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int cool=1;
    //     int[][]dp=new int[n+1][2];
    //     for(int i=n-1;i>=0;i--){
    //         dp[i][0]=Math.max(-prices[i]+dp[i+1][1], dp[i+1][0]);
    //         dp[i][1]=Math.max(prices[i]+((i<=n-1-cool)?dp[i+1+cool][0]:0), dp[i+1][1]);
    //     }
    //     return dp[0][0];
    // }
    
    //If atmost K transactions
    // public int maxProfit(int[] prices) {
    //     return F(k,prices,1);
    // }
    // public int F(int k, int[] prices, int cooldown) {
    //     int[][] dp=new int [cooldown+1][2*k+1];
    //     int n = prices.length;
    //     for(int i=n-1;i>=0;i--){
    //         int[] curr=new int [2*k+1];
    //         for(int t=0;t<2*k;t++){
    //             if(t%2==0){
    //                 curr[t]=Math.max(-prices[i]+dp[0][t+1], dp[0][t]);
    //             }
    //             else curr[t]=Math.max(prices[i]+dp[cooldown][t+1], dp[0][t]);
    //         }
    //         for(int j=1;j<=cooldown-1;j++) dp[j+1]=dp[j];
    //         dp[0]=curr;
    //     } 
    //     return dp[0][0];
    // }
}
/*package Dynamic_Programming.lec6_Stocks;

public class q39_Stocks_Cooldown_SpaceOptimized {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        // Space optimized: Keep track of only the required states
        int aheadNotHold = 0; // dp[i+1][0]
        int aheadHold = 0;    // dp[i+1][1]
        int aheadCooldown = 0; // dp[i+2][0]

        for (int i = n - 1; i >= 0; i--) {
            int currNotHold = Math.max(prices[i] + aheadCooldown, aheadNotHold);
            int currHold = Math.max(-prices[i] + aheadNotHold, aheadHold);

            // Update states for the next iteration
            aheadCooldown = aheadNotHold;
            aheadNotHold = currNotHold;
            aheadHold = currHold;
        }

        return aheadNotHold; // The result starts at dp[0][0]
    }

    public static void main(String[] args) {
        q39_Stocks_Cooldown_SpaceOptimized stocks = new q39_Stocks_Cooldown_SpaceOptimized();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println("Max Profit: " + stocks.maxProfit(prices)); // Output: 3
    }
}
 */