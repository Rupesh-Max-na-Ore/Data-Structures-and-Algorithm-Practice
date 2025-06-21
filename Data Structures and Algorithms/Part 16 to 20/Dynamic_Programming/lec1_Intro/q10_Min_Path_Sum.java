package Dynamic_Programming.lec1_Intro;
/*64. Minimum Path Sum
Medium
Topics
Companies
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.3M
Submissions
2M
Acceptance Rate
65.2% */
public class q10_Min_Path_Sum {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int prev[] = new int[m];

        for (int i = 0; i < n; i++) {
            int curr[] = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) curr[j] = grid[i][j]; 
                else {
                    int up = grid[i][j];
                    if (i > 0)up += prev[j]; else up += (int) Math.pow(10, 9);

                    int left = grid[i][j];
                    if (j > 0)left += curr[j - 1]; else left += (int) Math.pow(10, 9); 
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}
