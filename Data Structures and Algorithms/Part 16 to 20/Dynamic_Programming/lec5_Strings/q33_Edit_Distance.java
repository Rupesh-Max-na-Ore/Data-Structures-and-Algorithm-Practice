package Dynamic_Programming.lec5_Strings;

public class q33_Edit_Distance {
    public int minDistance(String w1, String w2) {
        int n=w1.length();
        int m=w2.length();
        int[]prev=new int[m+1];
        for(int i=0;i<=m;i++)prev[i]=i;

        for(int i=1;i<=n;i++){
            int[]curr=new int[m+1]; curr[0]=i;
            for(int j=1;j<=m;j++){
                if(w1.charAt(i-1)==w2.charAt(j-1))curr[j]=prev[j-1];
                else curr[j]=1+Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
            }
            prev=curr;
        } return prev[m];
    }
}
/*class Solution {
  public int minDistance(String word1, String word2) {
    final int m = word1.length();//first word length
    final int n = word2.length();///second word length
    // dp[i][j] := min # of operations to convert word1[0..i) to word2[0..j)
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; ++i)
      dp[i][0] = i;

    for (int j = 1; j <= n; ++j)
      dp[0][j] = j;

    for (int i = 1; i <= m; ++i)
      for (int j = 1; j <= n; ++j)
        if (word1.charAt(i - 1) == word2.charAt(j - 1))//same characters
          dp[i][j] = dp[i - 1][j - 1];//no operation
        else
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;                      //replace               //delete        //insert

    return dp[m][n];
  }
} */