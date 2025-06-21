package Dynamic_Programming.lec8_Matrix_Chain_Multiplication_and_Parition;

public class q51_Burst_Ballons {
    public int maxCoins(int[] a) {
        int n = a.length;
        int[][] dp = new int[n+2][n+2];

        for(int i=n; i>0; i--) { // left ptr 
            for(int j=1; j<=n; j++){ // right ptr
                if(i>j) continue;
                int maxi = 0;// or Integer.MIN_VALUE;
                for(int k=i; k<=j; k++) { // pick every elem from the window to find max Coins that can be Scored
                    int currCoinsScored = get(a, i-1) * get(a, k) * get(a, j+1) + dp[i][k-1] + dp[k+1][j];
                    maxi = Math.max(maxi, currCoinsScored);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    private int get(int[] a, int i) {
        if (i < 0 || i >= a.length) {
            return 1;
        }
        return a[i];
    }
}
