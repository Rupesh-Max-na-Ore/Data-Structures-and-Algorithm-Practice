#include <stdio.h>
#include <limits.h>


int minimumWeeklyInput(int costs[], int n, int weeks) {
    int dp[n+1][weeks+1];  
    int max_cost[n+1][n+1]; 
    
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= weeks; j++) {
            dp[i][j] = INT_MAX;
        }
    }
    
    dp[0][0] = 0;

    for (int i = 0; i < n; i++) {
        max_cost[i][i] = costs[i];
        for (int j = i + 1; j < n; j++) {
            max_cost[i][j] = (costs[j] > max_cost[i][j-1]) ? costs[j] : max_cost[i][j-1];
        }
    }

    for (int j = 1; j <= weeks; j++) {  
        for (int i = j; i <= n; i++) {  
            for (int k = 0; k < i; k++) {  
                // Try to placw the last week starting from k+1 th camp to ith
                dp[i][j] = dp[i][j] < dp[k][j-1] + max_cost[k][i-1] ? dp[i][j] : dp[k][j-1] + max_cost[k][i-1];
            }
        }
    }

    return dp[n][weeks]; // last posn answer
}

int main() {
    int costs[] = {1000, 500, 2000, 8000, 1500};
    int n = 5;  // Number of campaigns
    int weeks = 3;  // Number of weeks
    int result = minimumWeeklyInput(costs, n, weeks);
    printf("Minimum sum of weekly inputs: %d\n", result);
    return 0;
}
//it was Hoffmann coding implemented in disk management