package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

public class q47_Count_LIS {
    public int findNumberOfLIS(int[] a) {
        int n=a.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
        }
        int maxL=1,maxI=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(a[prev]<a[i]){
                    if(dp[prev]+1>dp[i]){
                        dp[i]=1+dp[prev];
                        cnt[i]=cnt[prev];
                    }
                    else if(dp[prev]+1==dp[i]){
                        cnt[i]+=cnt[prev];
                    }
                }
            }
            if(dp[i]>maxL){
                maxL=dp[i];
                maxI=i;
            }
        }
        //return cnt[maxI]; //Wrong cuz there can be multiple maxL places, need to count all of them
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxL) {
                totalCount += cnt[i];
            }
        }

        return totalCount;
    }
}
