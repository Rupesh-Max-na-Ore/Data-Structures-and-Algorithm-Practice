package Dynamic_Programming.lec1_Intro;
/*Chocolates Pickup
Difficulty: HardAccuracy: 50.36%Submissions: 28K+Points: 8
You are given an n rows and m cols matrix grid representing a field of chocolates where grid[i][j] represents the number of chocolates that you can collect from the (i, j) cell.

You have two robots that can collect chocolates for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of chocolates collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the chocolates.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
Example:

Input:
n = 4, m = 3
grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output:
24
Explanation:
Path of robot #1 and #2 are described in color green and blue respectively. Chocolates taken by Robot #1, (3 + 2 + 5 + 2) = 12. Chocolates taken by Robot #2, (1 + 5 + 5 + 1) = 12. Total of Chocolates: 12 + 12 = 24.
Expected Time Complexity: O(n * m * m)
Expected Space Complexity: O(n * m * m)

Constraint:
2 <= n, m < = 70
0 <= grid[i][j] <= 100 */
public class q13_Ninja_and_his_friends_3d {
    public int solve(int n, int m, int A[][]) {
        int[][] below = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) below[j1][j2] = A[n - 1][j1];
                else below[j1][j2] = A[n - 1][j1] + A[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[][] curr = new int[m][m];

            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                int maxPS = Integer.MIN_VALUE;

                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                    int currPS;

                    if (j1 == j2) currPS = A[i][j1];
                    else currPS = A[i][j1] + A[i][j2];

                    if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                        currPS += (int) Math.pow(-10, 9);
                    else currPS += below[j1 + di][j2 + dj];

                    maxPS = Math.max(currPS, maxPS);
                    }
                }
                curr[j1][j2] = maxPS;
                }
            }

            below=curr;
        }

        return below[0][m - 1];
    }
}
