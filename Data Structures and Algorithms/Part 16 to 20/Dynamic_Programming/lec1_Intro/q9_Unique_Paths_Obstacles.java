package Dynamic_Programming.lec1_Intro;
/*63. Unique Paths II
Medium
Topics
Companies
Hint
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.1M
Submissions
2.5M
Acceptance Rate
42.3% */
public class q9_Unique_Paths_Obstacles {
    public int uniquePathsWithObstacles(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int prev[] = new int[n];
        
        for (int i = 0; i < m; i++) {
            int curr[] = new int[n];
            
            for (int j = 0; j < n; j++) {
                if(maze[i][j]==1){
                    curr[j] = 0;
                    continue;
                }
                if (i==0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0 ) up = prev[j];
                if (j > 0 ) left = curr[j - 1];

                curr[j] = up + left;
            }
            
            prev = curr;
        }

        return prev[n - 1];
    }
/*//1st attempt, also correct, more typing than i like tho
class Solution {
    public int uniquePathsWithObstacles(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int prev[] = new int[n];
        
        for (int i = 0; i < m; i++) {
            int curr[] = new int[n];
            
            for (int j = 0; j < n; j++) {
                if (i==0 && j == 0 && maze[i][j]==0) {
                    curr[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0 && maze[i][j]==0) up = prev[j];
                if (j > 0 && maze[i][j]==0) left = curr[j - 1];

                curr[j] = up + left;
            }
            
            prev = curr;
        }

        return prev[n - 1];
    }
}
 */
}
