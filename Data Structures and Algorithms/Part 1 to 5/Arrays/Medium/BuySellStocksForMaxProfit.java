package Arrays.Medium;
//q6
// 121. Best Time to Buy and Sell Stock
// Easy
// Topics
// Companies
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.
 

// Constraints:

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 4.6M
// Submissions
// 8.6M
// Acceptance Rate
// 53.7%

import java.util.Arrays;

public class BuySellStocksForMaxProfit {

    public static int maxProfit(int[] prices) {
        int currP=Integer.MIN_VALUE;
        int maxP=currP;
        int l=0;
        int r=1;
        while(r<prices.length){
            if(prices[r]>prices[l]){
                currP=prices[r]-prices[l];
                maxP=(currP>maxP)? currP:maxP;
            }else{
                l=r;
            }r++;
        }return maxP;
        
    }

        public static void main(String[] args) {
        int[] a1 = {5,1,4,2,3,4,3,2};//{-1,-1,0,3,-3,4,-5,6,-7};
        int [] a2 = {-1,-2,3};
        
        System.out.println("Original array of Prices of Stocks: " + Arrays.toString(a1));
        int max=BuySellStocksForMaxProfit.maxProfit(a1);
        System.out.println("Max Profit: "+max);
        }

    
}
//lc submission
// class Solution {
//     public int maxProfit(int[] prices) {
//         int currP=0;
//         int maxP=0;
//         int l=0;
//         int r=1;
//         int n=prices.length;
//         while(r<n){
//             if(prices[r]>prices[l]){
//                 currP=prices[r]-prices[l];
//                 maxP=(currP>maxP)? currP:maxP;
//             }else{
//                 l=r;
//             }r++;
//         }return maxP;
        

//     }
// }

//lc submission 2
// class Solution {
//     public int maxProfit(int[] prices) {
//     int maxPro = 0;
//     int minPrice = Integer.MAX_VALUE;
//     for (int i = 0; i < prices.length; i++) {
//         minPrice = (minPrice > prices[i])? prices[i]:minPrice;
//         maxPro = (maxPro < prices[i] - minPrice)?(prices[i] - minPrice):maxPro;
//     }
//     return maxPro;    
        

//     }
// }