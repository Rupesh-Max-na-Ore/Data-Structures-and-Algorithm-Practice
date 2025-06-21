package Dynamic_Programming.lec8_Matrix_Chain_Multiplication_and_Parition;

public class q48_MCM {
    static int matrixMultiplication(int a[]) {
        int n = a.length;
        int[][]dp=new int [n+1][n+1];
        // for(int i=0;i<n;i++) dp[i][i]=0;

        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int minim=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int currSteps = a[i-1]*a[k]*a[j]
                                    + dp[i][k]
                                    + dp[k+1][j];
                    if(minim>currSteps) minim=currSteps;
                }
                dp[i][j]=minim;
            }
        }
        return dp[1][n];
    }
}
