package Graphs.Lec4_ShortestPathAlgos;
/*1091. Shortest Path in Binary Matrix
Medium
Topics
Companies
Hint
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
Seen this question in a real interview before?
1/5
Yes
No
Accepted
634.1K
Submissions
1.3M
Acceptance Rate
49.3% */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*package Graphs.Lec4_ShortestPathAlgos;

public class GridNode {
    int x,y;
    GridNode(int k, int l){
        x=k;
        y=l;
    }
}
 */
/*package Graphs.Lec4_ShortestPathAlgos;

public class GridPair {
    GridNode node; int cost;
    GridPair(GridNode n, int p){
        node = n;
        cost = p;
    }

    GridPair(int h, int o, int p){
        node = new GridNode(h, o);
        cost = p;
    }
} */
public class q36_ShortestPathInBinaryMaze {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        //src=[0,0]; dest=[n-1,m-1];
        
        int n = grid.length ;
        int m = grid[0].length ;
        if(grid[0][0]==0 && n==1 && m==1) return 1;
        // base case 
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1)return -1 ;
        
        int[] dx={0,0,-1,1,-1,-1,1,1};
        int[] dy={-1,1,0,0,-1,1,-1,1};
        Queue<GridPair> q = new LinkedList<>();
        q.add(new GridPair(0,0, 1));
        int[][] d = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(d[i], (int)1e9);
        d[0][0] = 0;
        while(!q.isEmpty()){
            GridPair currP = q.poll();
            int x = currP.node.x;
            int y = currP.node.y;
            int cd = currP.cost;
            for(int i=0;i<8;i++){
                //explore nbrs
                int nx = dx[i]+x;
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m||grid[nx][ny]==1||(cd+1)>=d[nx][ny]) continue;

                //else
                d[nx][ny] = cd+1;
                if(nx==n-1 && ny==m-1) return d[nx][ny];
                q.add(new GridPair(nx, ny, d[nx][ny]));
            }
        } return -1;//if dest unreachable
    }
}
