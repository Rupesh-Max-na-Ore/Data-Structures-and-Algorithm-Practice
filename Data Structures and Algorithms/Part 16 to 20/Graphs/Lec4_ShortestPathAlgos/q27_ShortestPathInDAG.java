package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Stack;

/*Shortest path in Directed Acyclic Graph
Difficulty: MediumAccuracy: 48.48%Submissions: 160K+Points: 4Average Time: 20m
Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a 2D Integer array(or vector) edges[ ][ ] of length E, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Examples :

Input: V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
Output: [0, 2, 1, -1]
Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->2 with edge weight 1. There is no way we can reach 3, so it's -1 for 3.
Input: V = 6, E = 7, edges = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]
Output: [0, 2, 3, 6, 1, 5]
Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3. Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6. Shortest path from 0 to 4 is 0->4 with edge weight 1.Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
Constraint:
1 <= V <= 100
1 <= E <= min((N*(N-1))/2,4000)
0 <= edgesi,0, edgesi,1 < n
0 <= edgei,2 <=105 */
public class q27_ShortestPathInDAG {
    private class  Pair {
        int edge,wt;
        Pair(int f, int s){
            edge = f;
            wt = s;
        }
        
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Prepare Graph from list of edges
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        for(int i=0;i<V;i++) g.add(new ArrayList<>());
        for(int i=0;i<E;i++) g.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));

        //DO topoSOrt, get order
        Stack<Integer>st=new Stack<>();
        int vis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0) DFS(g,vis, st, i);
        }

        //Take out from stack and relax edges
        int[] dist = new int[V];
        for(int i=0;i<V;i++) dist[i] = Integer.MAX_VALUE;
        dist[0] = 0; // Source node (0) has distance 0
        while (!st.isEmpty()) {
            int curr = st.pop();
            // If the current node is unreachable, skip it
            if (dist[curr] == Integer.MAX_VALUE) continue;
            for(Pair nbr:g.get(curr)){
                if(dist[nbr.edge]> dist[curr]+nbr.wt) dist[nbr.edge] = dist[curr]+nbr.wt;
            }
        }

        //Replace unvisited nodes' distance with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;

    }
    private void DFS(ArrayList<ArrayList<Pair>> g, int[] vis, Stack<Integer> st, int i) {
        vis[i] = 1; //visited
        for(Pair nbr : g.get(i)){
            if(vis[nbr.edge]==0) DFS(g, vis,st, nbr.edge); 
        }
        st.push(i);
    }
}
