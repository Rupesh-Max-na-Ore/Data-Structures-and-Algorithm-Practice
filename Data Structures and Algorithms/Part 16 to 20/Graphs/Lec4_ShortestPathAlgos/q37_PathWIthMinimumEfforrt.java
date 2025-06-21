package Graphs.Lec4_ShortestPathAlgos;

import java.util.PriorityQueue;

/*1631. Path With Minimum Effort
Medium
Topics
Companies
Hint
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
Seen this question in a real interview before?
1/5
Yes
No
Accepted
326.5K
Submissions
535.2K
Acceptance Rate
61.0%
Topics
Array
Binary Search
Depth-First Search
Breadth-First Search
Union Find
Heap (Priority Queue)
Matrix */
class Tuple{
    int x,y,diff; //diff==difficulty==effort reqd.
    Tuple(int _x, int _y, int _diff){
        x=_x;
        y=_y;
        diff=_diff;
    }
}

public class q37_PathWIthMinimumEfforrt {
    public int minimumEffortPath(int[][] hts) {
        int n = hts.length;
        int m = hts[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)-> Integer.compare(x.diff, y.diff));
        pq.add(new Tuple(0, 0, 0));
        dist[0][0]=0;
        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();

            for(int i=0;i<=3;i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=n||ny>=m||nx<0||ny<0) continue;
                int gradientStep = Math.abs((hts[curr.x][curr.y] - hts[nx][ny]));
                int ndiff = Math.max(curr.diff, gradientStep);
                if(ndiff>=dist[nx][ny]) continue;
                dist[nx][ny] = ndiff;
                pq.add(new Tuple(nx, ny, ndiff));
            }
        }
        return (dist[n-1][m-1]==((int)1e9))? 0: dist[n-1][m-1];
        
    }
}
