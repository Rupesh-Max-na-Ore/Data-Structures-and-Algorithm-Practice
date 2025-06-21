package Graphs.Lec2_ProblemsOnBfsDfs;
/*547. Number of Provinces
Medium
Topics
Companies
There are n cities. Some of them are connected, while some are not. 
If city a is connected directly with city b, and city b is connected 
directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and 
no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 
if the ith city and the jth city are directly connected, and 
isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
Accepted
1.1M
Submissions
1.6M
Acceptance Rate
67.9% */
public class q7_Number_of_Provinces {
    public int findCircleNum(int[][] gp) {
        int v = gp.length;
        boolean vis[]=new boolean[v];
        int[] comps={0};
        for(int i=0;i<v;i++){
            if(!vis[i]){
                comps[0]++;
                dfs(gp,v,vis,i);
            }
        } return comps[0];
    }
                
    private void dfs(int[][] gp, int v, boolean[] vis, int i) {
        vis[i]=true;
        for(int j=0;j<v;j++){
            if(gp[i][j]!=0)//edge connect exist
            {
                if(!vis[j]){
                    dfs(gp, v, vis, j);
                }
            }
        }
    }
}
