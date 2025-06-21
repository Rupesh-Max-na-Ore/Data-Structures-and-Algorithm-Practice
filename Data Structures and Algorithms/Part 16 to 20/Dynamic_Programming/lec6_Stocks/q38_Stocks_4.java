package Dynamic_Programming.lec6_Stocks;

public class q38_Stocks_4 {
    public int maxProfit(int k, int[] prices) {
        int[] curr=new int [2*k+1];
        int n = prices.length;
        for(int i=n-1;i>=0;i--){
            for(int t=0;t<2*k;t++){
                if(t%2==0){
                    curr[t]=Math.max(-prices[i]+curr[t+1], curr[t]);
                }
                else curr[t]=Math.max(prices[i]+curr[t+1], curr[t]);
            }
        } return curr[0];
    }
}
