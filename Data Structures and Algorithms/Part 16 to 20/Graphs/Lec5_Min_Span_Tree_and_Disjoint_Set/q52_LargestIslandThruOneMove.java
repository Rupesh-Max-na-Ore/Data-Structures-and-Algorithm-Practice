package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.HashSet;

/*827. Making A Large Island
Hard
Topics
Companies
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
326.1K
Submissions
600.4K
Acceptance Rate
54.3%
Topics
Array
Depth-First Search
Breadth-First Search
Union Find
Matrix */
public class q52_LargestIslandThruOneMove {
    public int largestIsland(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        DisjointSet dsu  = new DisjointSet(n*m);
        int[]dx={-1,0,1,0};
        int[]dy={0,-1,0,1};
        //itr theu each cell, if ==1, chk 4 dir, join with them if more 1's in nbrhood
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                if(g[x][y]==1){
                    int curr = x*m+y;
                    for(int i=0;i<4;i++){
                        //nbr coords
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        if(isValid(nx,ny,n,m)&&g[nx][ny]==1){
                            int nbr = nx*m+ny;
                            dsu.unionBySize(curr, nbr);
                        }
                    }
                }
            }    
        }
        //itr thru each 0 cell, act as if we made it =1, check if 1 val nbrs it connect or not, for all it does, collect its parent size to sum
        int maxSize=Integer.MIN_VALUE;
        int maxNode=-1;//init as none conversion
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                if(g[x][y]==0){
                    //set to collect parents, prevent overlap
                    HashSet<Integer> compsThatGetConnected = new HashSet<>();
                    int curr = x*m+y;
                    for(int i=0;i<4;i++){
                        //nbr coords
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        if(isValid(nx,ny,n,m)&&g[nx][ny]==1){
                            int nbr = nx*m+ny;
                            compsThatGetConnected.add(dsu.findParent(nbr));
                        }
                    }
                    int cSize=0+1;//for itself
                    for(int parent:compsThatGetConnected){
                        cSize+= dsu.size.get(parent);
                    }
                    if(maxSize<cSize){
                        maxNode=curr;
                        maxSize=cSize;
                    }
                }
            }
        }
        for(int cellNode=0;cellNode<n*m;cellNode++){
            int ParentSize = dsu.size.get(dsu.findParent(cellNode));
            if(maxSize<ParentSize){
                maxSize=ParentSize;
                maxNode = -1;//none node change reqd
            }
        }
        return maxSize;
    }

    private boolean isValid(int nx, int ny, int n, int m) {
        return(nx>=0 && ny>=0 && nx<n && ny<m);
    }
}
