package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.LinkedList;
import java.util.Queue;

/* 542. 01 Matrix
Medium
Topics
Companies
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 

Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/

Seen this question in a real interview before?
1/5
Yes
No
Accepted
694.3K
Submissions
1.4M
Acceptance Rate
50.7% */
public class q13_0_1_Matrix_bfs {
    class Node {
        int first;
        int second;
        int third; 
        Node(int _first, int _second, int _third) {
            this.first = _first; 
            this.second = _second; 
            this.third = _third; 
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length; 
	    int m = mat[0].length; 
	    int vis[][] = new int[n][m]; 
	    int dist[][] = new int[n][m]; 
	    // <coords, steps>
	    Queue<Node> q = new LinkedList<>();
	    // traverse the matrix
	    for(int i = 0;i<n;i++) {
	        for(int j = 0;j<m;j++) {
	        // start BFS with cells that contain 0
	            if(mat[i][j] == 0) {
	                q.add(new Node(i, j, 0)); 
	                vis[i][j] = 1; 
	            }
	            else {
	                // mark unvisited 
	                vis[i][j] = 0; 
	            }
	        }
	    }
	        
	    int dx[] = {-1, 0, +1, 0}; 
	    int dy[] = {0, +1, 0, -1}; 
	    
	    while(!q.isEmpty()) {
	        int row = q.peek().first; 
	        int col = q.peek().second; 
	        int steps = q.peek().third; 
	        q.remove(); 
	        dist[row][col] = steps; 
	        // there is atmost 4 valid nbrs
	        for(int i = 0;i<4;i++) {
	            int nrow = row + dx[i]; 
	            int ncol = col + dy[i]; 
	            // check for valid unvisited cell
	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
	            && vis[nrow][ncol] == 0)  {
	                    vis[nrow][ncol] = 1; 
    	            q.add(new Node(nrow, ncol, steps+1));  
	            } 
	            }
	        }
	    return dist; 
    }
}
