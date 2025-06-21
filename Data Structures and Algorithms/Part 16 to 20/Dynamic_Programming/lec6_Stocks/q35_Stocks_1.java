package Dynamic_Programming.lec6_Stocks;

public class q35_Stocks_1 {
    //Better Attempt for Explaining
    public int maxProfit(int[] prices) {
        int maxP = 0, min = prices[0], currP;
        for (int i = 1; i < prices.length; i++) {
            currP=prices[i] - min;
            maxP=Math.max(maxP,currP);
            min=Math.min(min,prices[i]);
        }
        return maxP;
    }

    //Little Better Attempt for M/C
    public int maxProfit_(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}
/*class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else if (prices[i] > min) max = Math.max(prices[i] - min, max);
        }
        return max;
    }
} */

/*class Solution {
    public int maxProfit(int[] prices) {
        
        int max=0, sum=0;
        for(int i=0;i<prices.length-1;i++)
        {
            sum = Math.max(sum+prices[i+1]-prices[i],0);
            max = Math.max(sum, max);
        }
        return max;
    }
} */