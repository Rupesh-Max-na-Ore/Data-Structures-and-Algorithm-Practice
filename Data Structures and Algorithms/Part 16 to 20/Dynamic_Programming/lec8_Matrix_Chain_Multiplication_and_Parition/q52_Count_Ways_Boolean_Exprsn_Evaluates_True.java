package Dynamic_Programming.lec8_Matrix_Chain_Multiplication_and_Parition;

public class q52_Count_Ways_Boolean_Exprsn_Evaluates_True {
    private static final int MOD = (int) 1e9 + 7;
    public static int evaluateExp(String exp) {
        int n = exp.length();
        long[][][] dp = new long[n][n][2];
        for (int i = 0 ; i < n ; i++) {
            if (exp.charAt(i) == 'T') {
                dp[i][i][1] = 1;
                dp[i][i][0] = 0;
            } else if (exp.charAt(i) == 'F') {
                dp[i][i][1] = 0;
                dp[i][i][0] = 1;
            }
        }
        for (int i = n-1 ; i >= 0 ; i-=2) {
            for (int j = i ; j < n ; j+=2) {
                for (int k = i+1 ; k < j ; k+=2) {
                    long lt = dp[i][k-1][1];
                    long rt = dp[k+1][j][1];
                    long lf = dp[i][k-1][0];
                    long rf = dp[k+1][j][0];
                    if (exp.charAt(k) == '&') {
                        dp[i][j][1] = (dp[i][j][1] + lt*rt) % MOD;
                        dp[i][j][0] = (dp[i][j][0] + lt*rf + rt*lf + rf*lf) % MOD;
                    } else if (exp.charAt(k) == '|') {
                        dp[i][j][1] = (dp[i][j][1] + lt*rf + rt*lf + rt*lt) % MOD;
                        dp[i][j][0] = (dp[i][j][0] + lf*rf) % MOD;
                    } else {
                        dp[i][j][1] = (dp[i][j][1] + lt*rf + rt*lf) % MOD;
                        dp[i][j][0] = (dp[i][j][0] + lf*rf + lt*rt) % MOD;
                    }
                }
            }
        }
        return (int) dp[0][n-1][1];
    }
}
