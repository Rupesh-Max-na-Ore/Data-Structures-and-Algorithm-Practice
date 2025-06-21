package Graphs.Lec2_ProblemsOnBfsDfs;
/*994. Rotting Oranges
Medium
Topics
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.1M
Submissions
2M
Acceptance Rate
55.9% */
import java.util.LinkedList;
import java.util.Queue;

public class q10_Rotting_Oranges {
    // Wrong attempt
    // public int orangesRotting(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     if(grid==null||n==0||m==0) return 0; //no organes
    //     Queue<int[]> q= new LinkedList<>();
    //     int fresh=0;
    //     int t=0;
    //     int updates=0;
    //     int [] dx = {0,-1,0,1};
    //     int [] dy = {-1,0,1,0};
    //     int [][] vis = new int[n][m];

    //     //S1
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(grid[i][j]==2) {q.offer(new int[]{i,j});}
    //             if(grid[i][j]==1) fresh++;
    //         }
    //     }
    //     //s2
    //     while(!q.isEmpty()){
    //         t++;
    //         int lvl_size=q.size();
    //         updates+=lvl_size;
    //         for(int itr=0;itr<lvl_size;itr++){
    //             int curr[]=q.poll(); int ox = curr[0], oy= curr[1];
    //             vis[ox][oy]=2;

    //             for(int d=0;d<4;d++){
    //                 int x = ox + dx[d];
    //                 int y = oy + dy[d];

    //                 if(x < n && y <m && x>=0 && y>=0){
    //                     if(vis[x][y]!=2 && fresh !=0){
    //                         if(grid[x][y]==1){
    //                             q.offer(new int[]{x,y});
    //                             fresh--;
    //                         }
    //                     }
    //                 }
    //             }

    //             if(fresh==0) return t;
    //         }
    //         //else
    //     }
    //     return -1;//else
    // }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m]; // Visited array
        int fresh = 0;  // Count of fresh oranges
        int minutes = 0;

        // Directions for 4-way movement (left, up, right, down)
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        // **Step 1: Initialize queue with rotten oranges & count fresh oranges**
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Rotten orange
                    vis[i][j] = true; // Mark visited
                } else if (grid[i][j] == 1) {
                    fresh++; // Count fresh oranges
                }
            }
        }

        // **Edge Case: If no fresh oranges, return 0**
        if (fresh == 0) return 0;

        // **Step 2: BFS Traversal (Level Order)**
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false; // Track if any orange rots in this round

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int ox = curr[0], oy = curr[1];

                // Explore all 4 directions
                for (int d = 0; d < 4; d++) {
                    int x = ox + dx[d];
                    int y = oy + dy[d];

                    // **Check valid cell and fresh orange**
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1 && !vis[x][y]) {
                        queue.offer(new int[]{x, y}); // Add to queue
                        vis[x][y] = true; // Mark visited
                        fresh--; // Reduce fresh orange count
                        rotted = true;
                    }
                }
            }

            // If at least one orange rotted in this round, increase time
            if (rotted) minutes++;
        }

        // **Step 3: Check if all fresh oranges have rotted**
        return (fresh == 0) ? minutes : -1;
    }

    public static void main(String[] args) {
        q10_Rotting_Oranges solution = new q10_Rotting_Oranges();
        int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(solution.orangesRotting(grid1)); // Output: 4

        int[][] grid2 = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        System.out.println(solution.orangesRotting(grid2)); // Output: -1

        int[][] grid3 = {
            {0, 2}
        };
        System.out.println(solution.orangesRotting(grid3)); // Output: 0
    }
}
