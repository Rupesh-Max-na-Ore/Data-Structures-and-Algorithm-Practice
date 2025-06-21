package Dynamic_Programming.lec6_Stocks;

public class q40_Stocks_Fee {
    public int maxProfit(int[] prices, int fee) {
        int aheadNotBuy = 0, aheadBuy=0;
        int currNotBuy, currBuy;
        int n= prices.length;
        for(int i=n-1;i>=0;i--){
            currNotBuy = Math.max(prices[i]+aheadBuy-fee, aheadNotBuy);
            currBuy = Math.max(-prices[i]+aheadNotBuy, aheadBuy);
            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;
    }
}
