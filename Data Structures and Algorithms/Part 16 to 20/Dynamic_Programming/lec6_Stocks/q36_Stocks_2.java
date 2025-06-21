package Dynamic_Programming.lec6_Stocks;

public class q36_Stocks_2 {
    public int maxProfit(int[] prices) {
        int aheadNotBuy = 0, aheadBuy=0;
        int currNotBuy, currBuy;
        int n= prices.length;
        for(int i=n-1;i>=0;i--){
            currNotBuy = Math.max(prices[i]+aheadBuy, aheadNotBuy);
            currBuy = Math.max(-prices[i]+aheadNotBuy, aheadBuy);
            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;
    }
}
/*
gREEDY  ways

class Solution {
    public  int maxProfit(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i] ) {
                total += nums[i+1] - nums[i];
            }
        }
        return total;
    }
    }
my approach of this question
int maxProfit(vector<int>& a) {
        int curr=a[0];
        int profit=0;
        for(int i=1;i<a.size();i++){
            if(a[i]<curr) curr=a[i];
            else if(a[i]>curr) {
                profit+=a[i]-curr;
                curr=a[i];
            }
        }
        return profit;
    } */