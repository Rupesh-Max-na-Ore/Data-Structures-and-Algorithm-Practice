package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Number of Distinct Islands
Difficulty: MediumAccuracy: 62.29%Submissions: 94K+Points: 4Average Time: 20m
Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

Example 1:

Input:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 0, 1, 1}, 
            {0, 0, 0, 1, 1}}
Same colored islands are equal.
We have 2 equal islands, so we 
have only 1 distinct island.

Example 2:

Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1}, 
            {1, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 1, 0, 1, 1}}
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.

Your Task:

You don't need to read or print anything. Your task is to complete the function countDistinctIslands() which takes the grid as an input parameter and returns the total number of distinct islands.

Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] == 0 or grid[i][j] == 1 */
public class q16_No_of_distinct_islands {//using base concept
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<String> uniqueIslands = new HashSet<>();

        // Directions for movement (Up, Left, Down, Right)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    // Store the island's relative shape
                    List<String> shape = new ArrayList<>();
                    dfs(grid, vis, i, j, i, j, shape, dx, dy, n, m);
                    uniqueIslands.add(String.join(",", shape));  // Convert list to string for HashSet
                }
            }
        }

        return uniqueIslands.size(); // Number of distinct islands
    }

    private void dfs(int[][] grid, boolean[][] vis, int row, int col, int baseRow, int baseCol, List<String> shape, int[] dx, int[] dy, int n, int m) {
        vis[row][col] = true;
        shape.add((row - baseRow) + "_" + (col - baseCol));  // Store relative position

        for (int k = 0; k < 4; k++) {
            int newRow = row + dx[k];
            int newCol = col + dy[k];

            // Check boundary conditions and unvisited land
            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m &&
                grid[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                dfs(grid, vis, newRow, newCol, baseRow, baseCol, shape, dx, dy, n, m);
            }
        }
    }
}
//https://chatgpt.com/share/67d133e8-54dc-8005-a162-c8792725afe9
/*//using path hashing
import java.util.*;

public class q16_No_of_distinct_islands {
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<String> uniqueIslands = new HashSet<>();

        // Directions: Up, Left, Down, Right
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        char[] dir = {'U', 'L', 'D', 'R'};  // Movement encoding

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    StringBuilder path = new StringBuilder("S"); // Start marker
                    dfs(grid, vis, i, j, path, dx, dy, dir, n, m);
                    uniqueIslands.add(path.toString()); // Store path signature
                }
            }
        }

        return uniqueIslands.size(); // Number of distinct islands
    }

    private void dfs(int[][] grid, boolean[][] vis, int row, int col, StringBuilder path, int[] dx, int[] dy, char[] dir, int n, int m) {
        vis[row][col] = true;

        for (int k = 0; k < 4; k++) {
            int newRow = row + dx[k];
            int newCol = col + dy[k];

            // Check if within bounds and is a land cell and not visited
            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m &&
                grid[newRow][newCol] == 1 && !vis[newRow][newCol]) {

                // Record direction before the recursive call
                path.append(dir[k]);
                dfs(grid, vis, newRow, newCol, path, dx, dy, dir, n, m);
                path.append('B'); // Backtrack marker
            }
        }
    }
}
 */
