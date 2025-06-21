package Dynamic_Programming.lec8_Matrix_Chain_Multiplication_and_Parition;

import java.util.Arrays;

public class q50_Min_Cost_to_Cut_A_Stick {
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        int mc[]=new int [c+2]; //modified cuts arr[]
        mc[0]=0; mc[c+1]=n;
        for(int i=0;i<c;i++) mc[i+1]=cuts[i];
        Arrays.sort(mc);
        int [][] dp= new int[c+2][c+2];

        for(int i=c;i>0;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;

                int minCost=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int currCost=mc[j+1] - mc[i-1]
                                    + dp[i][k-1] 
                                    + dp[k+1][j];
                    minCost=Math.min(minCost, currCost);
                }
                dp[i][j]=minCost;
            }
        }
        return dp[1][c];
    }
}
