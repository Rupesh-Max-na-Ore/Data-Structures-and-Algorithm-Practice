package Dynamic_Programming.lec5_Strings;

public class q31_Shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m=s1.length(); int n=s2.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        int i=m; int j=n;
        while(i>0 && j>0){
            if(dp[i][j]==dp[i-1][j]){
                sb.append(s1.charAt(i-1)); i--;
            }
            else if(dp[i][j]==dp[i][j-1]){
                sb.append(s2.charAt(j-1)); j--;
            }
            else{
                sb.append(s1.charAt(i-1)); i--;j--;
            }
        }
        while(i>0){
            sb.append(s1.charAt(i-1)); i--;
        }
        while(j>0){
            sb.append(s2.charAt(j-1)); j--;
        }
        return sb.reverse().toString();
    }
}
