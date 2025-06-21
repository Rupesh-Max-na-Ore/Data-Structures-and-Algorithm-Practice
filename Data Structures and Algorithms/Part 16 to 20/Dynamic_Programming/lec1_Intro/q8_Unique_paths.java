package Dynamic_Programming.lec1_Intro;
/*62. Unique Paths
Solved
Medium
Topics
Companies
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2M
Submissions
3.2M
Acceptance Rate
64.9% */
public class q8_Unique_paths {
    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        
        for (int i = 0; i < m; i++) {
            int curr[] = new int[n];
            
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    curr[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0) up = prev[j];
                if (j > 0) left = curr[j - 1];

                curr[j] = up + left;
            }
            
            prev = curr;
        }

        return prev[n - 1];
    }

}
/*//Math Cobinatorics Soln. 
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              
            // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       
            // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
}

    public int uniquePaths(int m, int n) {
        double result = 1;
        for (int i = 0; i < (m - 1); i++) {
            result = result * (n + i) / (m - i - 1);
        }
        return (int)(result + 0.5);
    }
*/