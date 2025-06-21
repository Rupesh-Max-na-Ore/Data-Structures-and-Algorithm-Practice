package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.ArrayList;
import java.util.List;

/*802. Find Eventual Safe States
Medium
Topics
Companies
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 

Constraints:

n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104].
Accepted
425.8K
Submissions
626.3K
Acceptance Rate
68.0% */
public class q20_Eventual_Safe_States_DFS {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int v=g.length;
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        boolean check[] = new boolean[v];
        for(int i=0; i<v; i++) if(!vis[i]) dfs_check(i,g,v,vis,pathVis,check);
            List<Integer> safeNodes = new ArrayList<>();
            for(int i=0; i<v; i++) if(!pathVis[i]) safeNodes.add(i);
            //for(int i=0; i<v; i++) if(check[i]) safeNodes.add(i); //same
            return safeNodes;
        }
    
        private boolean dfs_check(int curr, int[][] g, int v, boolean[] vis, boolean[] pathVis, boolean[] check) {
            vis[curr] = true;
            pathVis[curr] = true;
            //check[curr] = false; //for now

            for(int nbr:g[curr]) if((!vis[nbr] && dfs_check(nbr, g, v, vis, pathVis, check))||pathVis[nbr]) return true;

            //check[curr]=true;
            pathVis[curr]=false;
            return false;
        }
}
//LC submission
/*class Solution {
        public List<Integer> eventualSafeNodes(int[][] g) {
        int v=g.length;
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        //boolean check[] = new boolean[v];
        for(int i=0; i<v; i++) if(!vis[i]) dfs_check(i,g,v,vis,pathVis);//,check);
            List<Integer> safeNodes = new ArrayList<>();
            for(int i=0; i<v; i++) if(!pathVis[i]) safeNodes.add(i);
            //for(int i=0; i<v; i++) if(check[i]) safeNodes.add(i); //same
            return safeNodes;
        }
    
        private boolean dfs_check(int curr, int[][] g, int v, boolean[] vis, boolean[] pathVis)//, boolean[] check) 
        {
            vis[curr] = true;
            pathVis[curr] = true;
            //check[curr] = false; //for now

            for(int nbr:g[curr]) if((!vis[nbr] && dfs_check(nbr, g, v, vis, pathVis))||pathVis[nbr]) return true;

            //check[curr]=true;
            pathVis[curr]=false;
            return false;
        }

} */

/*//JAVA CODE USING SINGLE VIS[] ARRAY
class Solution {
    private static boolean dfs(int num , int vis[] , List<List<Integer>> adj){
        vis[num] = 1;
        for(int it : adj.get(num)){
            if(vis[it] == 0){
                if(dfs(it,vis,adj)) return true;
            }else if(vis[it] == 1) return true;
        }
        vis[num] = 2;
        return false;
    }
    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj){
        int vis[] = new int[v];
        for(int i=0;i<v;i++){
            if(vis[i] == 0) dfs(i,vis,adj);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(vis[i] == 2) list.add(i);
        }
        Collections.sort(list);
        return list;
    }
} */