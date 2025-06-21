package Dynamic_Programming.lec8_Matrix_Chain_Multiplication_and_Parition;

public class q53_Palindrome_Partitioning_2_Front_Partitionining {
    // some indexing issues, logic correct
    // public int minCut(String s) {
    //     int n = s.length();
    //     //s0
    //     int pal[][] = precomputePal(s,n);
    //     int dp[]=new int[n+1];
    //     //s1 base
    //     dp[n]=-1;
    //     //s2 recur
    //     for(int i = n-1;i>=0;i--){
    //         int minCost = Integer.MAX_VALUE;
    //         for(int j=i+1;j<n;j++){
    //             if(pal[i][j-1]==1){
    //                 int curr = 1+dp[j];
    //                 minCost = Math.min(minCost, curr);
    //             }
    //         }
    //         dp[i]=minCost;
    //     }
    //     return dp[0];
    // }
        
    // private int[][] precomputePal(String s,int n){
    //     int is_pal[][]= new int[n+1][n+1];

    //     for(int i=0;i<n;i++){
    //         for(int j =i;j<n;j++){
    //             if(isPal(s.substring(i, j+1),i,j)){
    //                     is_pal[i][j]=1;
    //                 }
    //         }
    //     }
    //     return is_pal;
    // }
    // private boolean isPal(String s, int i, int j){
    //     while(i<j){
    //         if(s.charAt(i)!=s.charAt(j)) return false;
    //         i++;j--;
    //     }
    //     return true;
    // }
}
// package Dynamic_Programming.lec8_Matrix_Chain_Multiplication_and_Parition;

// public class q53_Palindrome_Partitioning_2_Front_Partitionining {
    // public int minCut(String s) {
    //     int n = s.length();

    //     // Precompute palindrome substrings
    //     boolean[][] pal = precomputePal(s, n);

    //     // DP array to store minimum cuts
    //     int[] dp = new int[n + 1];

    //     // Base case: no cuts needed for an empty substring
    //     dp[n] = 0;

    //     // Bottom-up calculation
    //     for (int i = n - 1; i >= 0; i--) {
    //         int minCost = Integer.MAX_VALUE;
    //         for (int j = i; j < n; j++) {
    //             if (pal[i][j]) {
    //                 int currCost = 1 + dp[j + 1];
    //                 minCost = Math.min(minCost, currCost);
    //             }
    //         }
    //         dp[i] = minCost;
    //     }

    //     // Final result: dp[0] - 1 (subtract 1 because the last cut is unnecessary)
    //     return dp[0] - 1;
    // }

    // // Helper function to precompute all palindromic substrings
    // private boolean[][] precomputePal(String s, int n) {
    //     boolean[][] is_pal = new boolean[n][n];

    //     // Palindromes of length 1
    //     for (int i = 0; i < n; i++) {
    //         is_pal[i][i] = true;
    //     }

    //     // Palindromes of length 2
    //     for (int i = 0; i < n - 1; i++) {
    //         if (s.charAt(i) == s.charAt(i + 1)) {
    //             is_pal[i][i + 1] = true;
    //         }
    //     }

    //     // Palindromes of length > 2
    //     for (int len = 3; len <= n; len++) {
    //         for (int i = 0; i <= n - len; i++) {
    //             int j = i + len - 1;
    //             if (s.charAt(i) == s.charAt(j) && is_pal[i + 1][j - 1]) {
    //                 is_pal[i][j] = true;
    //             }
    //         }
    //     }

    //     return is_pal;
    // }
// }
