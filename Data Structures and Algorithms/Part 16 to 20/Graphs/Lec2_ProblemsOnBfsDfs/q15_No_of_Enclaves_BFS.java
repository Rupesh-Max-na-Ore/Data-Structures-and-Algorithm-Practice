package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.LinkedList;
import java.util.Queue;

/*1020. Number of Enclaves
Medium
Topics
Companies
Hint
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
290.2K
Submissions
414.3K
Acceptance Rate
70.0% */
public class q15_No_of_Enclaves_BFS {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Mark boundary cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
        }

        // Directions for 4-way traversal
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // BFS traversal to mark all reachable land cells from the boundary
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int row = e[0], col = e[1];

            for (int k = 0; k < 4; k++) {
                int nr = row + dx[k];
                int nc = col + dy[k];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !vis[nr][nc] && grid[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

        // Count enclaves (1s that are not visited)
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

    // public int numEnclaves(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     boolean [][] vis = new boolean[n][m];
    //     //boundary 1s
    //     Queue<Integer[]> q=new LinkedList<>();
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(i==0||j==0||i==n-1||j==m-1){
    //                 if(grid[i][j]==1) {q.offer(new Integer[]{i,j}); vis[i][j]=true;
    //             }
    //         }
    //     } 
    // }
    //     int[]dx={0,-1,0,+1};
    //     int[]dy={-1,0,+1,0};
    //     while (!q.isEmpty()) {
    //         Integer[]e=q.poll();
    //         for(int k=0;k<4;k++){
    //             int nr=e[0]+dx[k];
    //             int nc=e[1]+dy[k];
    //             if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc] && grid[nr][nc]==1) {
    //                 q.offer(new Integer[]{nr,nc});
    //                 vis[nr][nc]=true;
    //             }
    //         }
    //     }
    //     int cnt=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(grid[i][j]==1 && !vis[i][j]) cnt++;
    //         }
    //     }
    //     return cnt;
    // }
}
