package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*778. Swim in Rising Water
Hard
Topics
Companies
Hint
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

 

Example 1:


Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:


Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n2
Each value grid[i][j] is unique.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
213.8K
Submissions
342.1K
Acceptance Rate
62.5%
Topics
Array
Binary Search
Depth-First Search
Breadth-First Search
Union Find
Heap (Priority Queue)
Matrix
Companies
Hint 1
Use either Dijkstra's, or binary search for the best time T for which you can reach the end if you only step on squares at most T. */
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        DisjointSet dsu = new DisjointSet(n*n);
        List<Integer> posn = new ArrayList<>();
        for(int i=0; i<n*n;i++) posn.add(i);
        Collections.sort(posn, (a,b)->grid[a/n][a%n] - grid[b/n][b%n]);
        int[] dx ={1,0,-1,0};
        int[] dy ={0,1,0,-1};
        for(int pos:posn){
            int cr = pos/n;
            int cc = pos%n;
            for(int i=0;i<4;i++){
                int nr = cr+dx[i];
                int nc = cc+dy[i];

                if(nr>=0 && nc>=0 && nr<n && nc<n && grid[cr][cc]>grid[nr][nc]){
                    dsu.unionBySize(pos, nr*n+nc);
                }

                if(dsu.findParent(0)==dsu.findParent(n*n-1)) return grid[cr][cc];
            }
        }return -1;//never exec
    } 

    //way2-Djikstra
    class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int swimInWater_2(int[][] grid) {
        int n = grid.length;
        int[][]time = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(time[i],(int)1e9);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(time[a.x][a.y], time[b.x][b.y]));
        int dy[] = {0,-1,0,1};
        int dx[] = {-1,0,1,0};
        pq.add(new Node(0, 0));
        time[0][0]=grid[0][0];

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int cr = curr.x;
            int cc = curr.y;
            int ctime = time[cr][cc];
            for(int i=0;i<4;i++){
                int nr = cr+dx[i];
                int nc = cc+dy[i];

                if(!(nr>=0 && nc>=0 && nr<n && nc<n)) continue;
                if(grid[nr][nc]<=ctime && ctime<time[nr][nc]){
                    time[nr][nc] = ctime;
                    pq.add(new Node(nr, nc));
                }
                else if (grid[nr][nc]>ctime && grid[nr][nc]<time[nr][nc]) {
                    time[nr][nc] = grid[nr][nc];
                    pq.add(new Node(nr, nc));
                }
            }
        } return time[n-1][n-1];
    }

    //way3-Binary Search + SImple DFS
    public int swimInWater_3(int[][] grid){
        int n = grid.length;
        int r = n*n;
        int l = 0;

        while(l<r){
            int m = (l+r)/2;
            boolean [][]vis = new boolean[n][n];
            int x=0,y=0;
            dfs4dir(m,x,y,grid,vis);
            if(vis[n-1][n-1]) r=m;
            else l=m+1;
        } return l;
    }

    private void dfs4dir(int m, int x, int y, int[][] grid, boolean[][] vis) {
        if(vis[x][y]) return;
        if(grid[x][y]>m) return;
        //4dir explore
        int n = grid.length;
        vis[x][y]=true;//mark as valid visit
        if(x-1>=0) dfs4dir(m, x-1, y, grid, vis);
        if(y-1>=0) dfs4dir(m, x, y-1, grid, vis);
        if(x+1<n) dfs4dir(m, x+1, y, grid, vis);
        if(y+1<n) dfs4dir(m, x, y+1, grid, vis);
    }
}
