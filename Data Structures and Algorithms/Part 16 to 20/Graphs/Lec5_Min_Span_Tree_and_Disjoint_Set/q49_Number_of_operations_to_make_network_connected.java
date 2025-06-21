package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*1319. Number of Operations to Make Network Connected
Medium
Topics
Companies
Hint
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

Example 1:


Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
270.3K
Submissions
421.2K
Acceptance Rate
64.2%
Topics
Depth-First Search
Breadth-First Search
Union Find
Graph
Companies
Hint 1
As long as there are at least (n - 1) connections, there is definitely a way to connect all computers.
Hint 2
 */
public class q49_Number_of_operations_to_make_network_connected {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet dsu = new DisjointSet(n);
        int e = connections.length;
        int extraEdg=0;
        for(int i=0;i<e;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            int pu = dsu.findParent(u);
            int pv = dsu.findParent(v);
            if(pu==pv) extraEdg++;
            else{
                dsu.unionByRank(pu, pv);
            } 
        }
        int comps=0;
        for(int i=0;i<n;i++) if(dsu.findParent(i)==i) comps++;
        int extraEdgsReqdToConnectComps = comps-1;
        if(extraEdg<extraEdgsReqdToConnectComps) return -1;
        //else we have enough extra edges
        return extraEdgsReqdToConnectComps;
    }
    //Instead of calcing extra edges we can just check simple condition that if e < v-1, can't make connected!
    public int makeConnected2(int n, int[][] connections) {
        int e = connections.length;
        if(e<n-1) return -1;
        DisjointSet dsu = new DisjointSet(n);
        for(int i=0;i<e;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            int pu = dsu.findParent(u);
            int pv = dsu.findParent(v);
            if(pu==pv) continue;
            else{
                dsu.unionByRank(pu, pv);
            } 
        }
        int comps=0;
        for(int i=0;i<n;i++) if(dsu.findParent(i)==i) comps++;
        int extraEdgsReqdToConnectComps = comps-1;
        return extraEdgsReqdToConnectComps;
    }
    //got memory exceeded on 3rd TC w/ below way
    public int makeConnected3(int n, int[][] connections) {
        //can use dfs to find connected components
        int e = connections.length;
        if(e<n-1) return -1;
        //make adjacency matrix for dfs
        int [][]gp = new int[n][n]; 
        for(int i=0;i<e;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            gp[u][v]=1;
            //gp[v][u]=1;
        }
        boolean vis[]=new boolean[n];
        int comps=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                comps++;
                dfs(gp,n,vis,i);
            }
        } return comps-1;
    }
    private void dfs(int[][] gp, int n, boolean[] vis, int i) {
        vis[i]=true;
        for(int j=0;j<n;j++){
            if(gp[i][j]==1)//edge connectn. exist
            {
                if(!vis[j]){
                    dfs(gp, n, vis, j);
                }
            }
        }
    }

    public int makeConnected4(int n, int[][] connections) {
        //can use dfs to find connected components
        int e = connections.length;
        if(e<n-1) return -1;
        //make adjacency list for dfs
        ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
        for(int i=0;i<n;i++) gp.add(new ArrayList<>());
        for(int i=0;i<e;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            gp.get(u).add(v);
            gp.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        int comps=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                comps++;
                dfs2(gp,n,vis,i);
            }
        } return comps-1;
    }
    private void dfs2(ArrayList<ArrayList<Integer>> gp, int n, boolean[] vis, int i) {
        vis[i]=true;
        for(int nbr:gp.get(i)){
            if(!vis[nbr]) dfs2(gp, n, vis, nbr);
        }
    }

        public int makeConnected5(int n, int[][] connections) {
            //use bfs
        if(connections.length<n-1)return -1;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean vis[]=new boolean[n];
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0);
        int comp=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,adj);
                comp++;
            }
        }
        return comp-1;
    }
    public void bfs(int node,boolean[] vis,List<List<Integer>> adj){
        Queue<Integer> qu=new LinkedList<>();
        qu.add(node);
        while(!qu.isEmpty()){
            int curr=qu.poll();
            for(int adjnode:adj.get(curr)){
                if(!vis[adjnode]){
                    qu.add(adjnode);
                    vis[adjnode]=true;
                }
            }
        }
    }

    public int makeConnected5_modified(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
    
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    
        boolean vis[] = new boolean[n];
        int comps = 0;
        int extraEdg = 0;
    
        // Step 2: BFS traversal
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                comps++;
                extraEdg += bfs_findExtraEdges(i, vis, adj);
            }
        }
    
        int extraEdgsReqdToConnectComps = comps - 1;
        return (extraEdg >= extraEdgsReqdToConnectComps) ? extraEdgsReqdToConnectComps : -1;
    }
    
    // Modified BFS to count extra edges
    private int bfs_findExtraEdges(int node, boolean[] vis, List<List<Integer>> adj) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(node);
        vis[node] = true;
        int extraEdg = 0;
    
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            for (int adjnode : adj.get(curr)) {
                if (!vis[adjnode]) {
                    vis[adjnode] = true;
                    qu.add(adjnode);
                } else {
                    // If already visited, it's an extra edge
                    extraEdg++;
                }
            }
        }
        
        return extraEdg / 2; // Each extra edge is counted twice (u->v and v->u)
    }

    public int makeConnected4_fixed(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
    
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) gp.add(new ArrayList<>());
        
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            gp.get(u).add(v);
            gp.get(v).add(u);
        }
    
        boolean vis[] = new boolean[n];
        int comps = 0;
        int extraEdg = 0;
    
        // Step 2: Run DFS on unvisited nodes
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                comps++;
                extraEdg += dfs_countExtraEdges(gp, vis, i);
            }
        }
    
        int extraEdgsReqdToConnectComps = comps - 1;
        return (extraEdg >= extraEdgsReqdToConnectComps) ? extraEdgsReqdToConnectComps : -1;
    }
    
    // Corrected DFS to count extra edges
    private int dfs_countExtraEdges(ArrayList<ArrayList<Integer>> gp, boolean[] vis, int node) {
        vis[node] = true;
        int extraEdg = 0;
    
        for (int nbr : gp.get(node)) {
            if (!vis[nbr]) {
                dfs_countExtraEdges(gp, vis, nbr);
            } else {
                // If already visited, count as an extra edge
                extraEdg++;
            }
        }
        
        return extraEdg / 2; // Each extra edge is counted twice (u->v and v->u)
    }
    

}
