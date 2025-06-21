package Dynamic_Programming.lec6_Stocks;

public class q37_Stocks_3 {
    public int maxProfit(int[] prices) {
        int[] curr=new int [5];
        int n = prices.length;
        for(int i=n-1;i>=0;i--){
            for(int t=0;t<4;t++){
                if(t==0||t==2){
                    curr[t]=Math.max(-prices[i]+curr[t+1], curr[t]);
                }
                else curr[t]=Math.max(prices[i]+curr[t+1], curr[t]);
            }
        } return curr[0];
    }
}
/*4 Solution mentioned (Memoized CODE , Tabulation code , Space Optimized with 2 Array ,Space Optimized with 1 D array  )


Memoized CODE :- 

class Solution {
public:
    
    int recur(int i,int trans,vector<int> & nums,int n, vector<vector<int>>& dp)
    {
        if(i == n || trans == 4)return 0;
        
        if(dp[i][trans] != -1)return dp[i][trans];
        
        if(trans % 2 == 0)
        {
            return dp[i][trans] = max(-nums[i] + recur(i+1,trans+1,nums,n,dp) , recur(i+1,trans,nums,n,dp));
        }
        else
        {
            return dp[i][trans] = max(nums[i] + recur(i+1,trans+1,nums,n,dp) , recur(i+1,trans,nums,n,dp));
        }
    }
    
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n,vector<int> (4,-1));
        return recur(0,0,prices,n,dp);
    }
};

================================================================================================
Tabulation code :- 

class Solution {
public:
    
    int maxProfit(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n+1,vector<int> (5,0));
        
        for(int i=n-1;i>=0;i--)
        {
            for(int trans = 3;trans >= 0;trans--)
            {
                if(trans % 2 == 0)
                {
                    dp[i][trans] = max(-nums[i]+dp[i+1][trans+1],dp[i+1][trans]);
                }
                else
                {
                    dp[i][trans] = max(nums[i] + dp[i+1][trans+1] , dp[i+1][trans]);
                }
            }
        }
        return dp[0][0];
    }
};

==================================================================================================
Space Optimized with 2 Array  :- 

class Solution {
public:
    
    int maxProfit(vector<int>& nums) {
        int n = nums.size();
        vector<int> next(5,0);
        
        for(int i=n-1;i>=0;i--)
        {
            vector<int> curr(5,0);
            for(int trans = 3;trans >= 0;trans--)
            {
                if(trans % 2 == 0)
                {
                    curr[trans] = max(-nums[i]+next[trans+1],next[trans]);
                }
                else
                {
                    curr[trans] = max(nums[i] + next[trans+1] , next[trans]);
                }
            }
            next = curr;
        }
        return next[0];
    }
};


=================================================================================================
Space Optimized with 1 D array:-

class Solution {
public:
    
    int maxProfit(vector<int>& nums) {
        int n = nums.size();
        vector<int> next(5,0);
        
        for(int i=n-1;i>=0;i--)
        {
            for(int trans = 0; trans <= 3;trans++)
            {
                if(trans % 2 == 0)
                {
                    next[trans] = max(-nums[i]+next[trans+1],next[trans]);
                }
                else
                {
                    next[trans] = max(nums[i] + next[trans+1] , next[trans]);
                }
            }
        }
        return next[0];
    }
};

in any case you are looking for the java solution :)

Space optimization:

class Solution {
    
    private int helper(int[] prices , int ind , int buy , int cap , int dp[][][]){
        
        if(ind == prices.length || cap == 0) return 0;
        
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        
        int profit = 0;
        
        if(buy == 1){
           profit = Math.max(-prices[ind] + helper(prices , ind+1 , 0 , cap ,dp) , helper(prices , ind+1 , 1 , cap ,dp)); 
        }else{
            profit = Math.max(prices[ind] + helper(prices, ind+1 , 1 , cap-1 ,dp) , helper(prices , ind+1 , 0 ,cap , dp));
        }
        
        return dp[ind][buy][cap] = profit;
    }
    
    public int maxProfit(int[] prices) {
        
        
        int n = prices.length;
        
        int dp[][][] = new int[n][2][3];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 2 ; j++){
                for(int k = 0 ; k < 3 ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return helper(prices , 0 , 1 , 2 , dp);
        
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Tabulation:

class Solution {
    

    
    public int maxProfit(int[] prices) {
        
        
        int n = prices.length;
        
        int dp[][][] = new int[n+1][2][3];
        
        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy < 2 ; buy++){
                for(int cap = 1 ; cap < 3 ; cap++){
                    
                     int profit = 0;
        
                    if(buy == 1){
                        profit = Math.max(-prices[ind] + dp[ind+1][0][cap] ,dp[ind+1][1][cap]); 
                    }else{
                        profit = Math.max(prices[ind] + dp[ind+1][1][cap-1] , dp[ind+1][0][cap]);
                    }
        
                     dp[ind][buy][cap] = profit;
                    
                    
                }
            }
        }
        
        return dp[0][1][2];
        
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Space optimization:

class Solution {
    

    
    public int maxProfit(int[] prices) {
        
        
        int n = prices.length;
        
        int dp[][] = new int[2][3];
        
        for(int ind = n-1 ; ind >= 0 ; ind--){
            
            int curr[][] = new int[2][3];
            
            for(int buy = 0 ; buy < 2 ; buy++){
                for(int cap = 1 ; cap < 3 ; cap++){
                    
                     int profit = 0;
        
                    if(buy == 1){
                        profit = Math.max(-prices[ind] + dp[0][cap] ,dp[1][cap]); 
                    }else{
                        profit = Math.max(prices[ind] + dp[1][cap-1] , dp[0][cap]);
                    }
        
                     curr[buy][cap] = profit;
                    
                    
                }
            }
            
            dp = curr;
        }
        
        return dp[1][2];
        
    }
}

I have solved it using the concept that you taught at the last but I have solved for maximum k transactions instead of two. And I have space optimized it to a single 1D vector of size 2*k+1

Here is the space optimized code :-

int maximumProfit(vector<int> &prices, int n, int k)
{
    vector<int> cur(2*k+1,0);
    for(int transaction=0;transaction<2*k;transaction++)
    {
        if(transaction%2==1)
            cur[transaction]=prices[n-1];
    }
    
    for(int index=n-2;index>=0;index--)
    {
        for(int transaction=0;transaction<2*k;transaction++)
        {
            int profit=0;
            if(transaction%2==0)
                profit=-prices[index]+cur[transaction+1];
            if(transaction%2)
                profit=prices[index]+cur[transaction+1];

            int skip=cur[transaction];

            cur[transaction]=max(profit,skip);
        }
    }
    return cur[0];
}
    
*/