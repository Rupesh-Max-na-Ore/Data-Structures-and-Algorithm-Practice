package Dynamic_Programming.lec1_Intro;

public class q12_Min_Max_Falling_Path_Sum {
        public int minFallingPathSum(int[][] a) {
        int min=Integer.MAX_VALUE;
        int n=a.length;
        int m=a[0].length;
        int dp[][]= new int[n][m];

        for(int i=0;i<m;i++){
            dp[0][i]=a[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=Integer.MAX_VALUE,ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                up=a[i][j]+dp[i-1][j];
                if(j>0) ld=a[i][j]+dp[i-1][j-1];
                if(j<m-1) rd=a[i][j]+dp[i-1][j+1];
                dp[i][j]=Math.min(up,Math.min(ld,rd));
            }
        }
        for(int i=0;i<m;i++){
            min=Math.min(dp[n-1][i],min);
        }
        return min;
    }

}
