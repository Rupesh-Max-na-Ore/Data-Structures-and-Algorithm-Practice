package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

public class q41_LIS {

    //1Arr Way, Intuitive-ish
    public int lengthOfLIS_(int[] a) {
        int n=a.length;
        int dp[]=new int[n];
        for(int i = 0; i<n; i ++) dp[i]=1;

        int maxNo=Integer.MIN_VALUE;
        int maxI=-1;
        int parent[]=new int[n];
        for(int i = 0; i<n; i ++){
            for (int pindx = i-1; pindx >=0; pindx--){
                if(a[pindx]<a[i] && 1+dp[pindx]>dp[i]){
                    dp[i]=1+dp[pindx];
                    parent[i]=pindx;
                    if(maxNo<dp[i]){
                        maxNo=dp[i];
                        maxI=i;
                    }
                }
            } 
        }

        //print
        return (maxI!=-1)?dp[maxI]:1;
    }
        // //1Arr SpcOpti
        // public int lengthOfLIS(int[] arr) {
        //     int n=arr.length;
        //     int ahd[]=new int[n+2];
        
        //     for(int i = n-1; i>=0; i --){
        //         // int cur[]=new int[n+2];
        //         for (int pindx = i; pindx >=0; pindx--){
        //             int excl = 0 + ahd[pindx];
        //             int incl = 0;
        //             if(pindx == 0 || arr[i] > arr[pindx-1]) incl = 1 + ahd[i+1];
        //             // cur[pindx] = Math.max(excl,incl);       
        //             ahd[pindx] = Math.max(excl,incl);    
        //         } // ahd=cur;
        //     }
        //     return ahd[0];
        // }
    

    // //2Arr SpcOpti
    // public int lengthOfLIS(int[] arr) {
    //     int n=arr.length;
    //     int ahd[]=new int[n+2];
    
    //     for(int i = n-1; i>=0; i --){
    //         int cur[]=new int[n+2];
    //         for (int pindx = i; pindx >=0; pindx--){
    //             int excl = 0 + ahd[pindx];
    //             int incl = 0;
    //             if(pindx == 0 || arr[i] > arr[pindx-1]) incl = 1 + ahd[i+1];       
    //             cur[pindx] = Math.max(excl,incl);    
    //         } ahd=cur;
    //     }
    //     return ahd[0];
    // }

    //Tabulation - 1-based indexing
    // public int lengthOfLIS(int[] arr) {
    //     int n=arr.length;
    //     int dp[][]=new int[n+1][n+2];
    
    //     for(int i = n-1; i>=0; i --){
    //         for (int pindx = i; pindx >=0; pindx--){
                
    //             int excl = 0 + dp[i+1][pindx];
        
    //             int incl = 0;
        
    //             if(pindx == 0 || arr[i] > arr[pindx-1]){
                    
    //                 incl = 1 + dp[i+1][i+1];
    //             }
        
    //             dp[i][pindx] = Math.max(excl,incl);
                
    //         }
    //     }
    
    //     return dp[0][0];
    // }

}
