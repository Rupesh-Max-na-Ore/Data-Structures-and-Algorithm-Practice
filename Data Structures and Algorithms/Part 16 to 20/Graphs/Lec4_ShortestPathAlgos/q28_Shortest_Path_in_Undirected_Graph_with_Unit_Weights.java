package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*

Shortest Path in Undirected
Difficulty: MediumAccuracy: 49.98%Submissions: 133K+Points: 4Average Time: 20m
You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

Examples :

Input: adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]], src=0
Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]

Input: adj[][]= [[3], [3], [], [0, 1]], src=3
Output: [1, 1, -1, 0]

Input: adj[][]= [[], [], [], [4], [3], [], []], src=1
Output: [-1, 0, -1, -1, -1, -1, -1] 
Constraint:
1<=adj.size()<=104
0<=edges<=adj.size()-1
https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
*/
public class q28_Shortest_Path_in_Undirected_Graph_with_Unit_Weights {
    private class  Pair {
        int node,cost;
        Pair(int f, int s){
            node = f;
            cost = s;
        }
        
    }
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> g, int src) {
        // here we already have adjacency list
        //
        int v = g.size();
        boolean[]vis = new boolean[v];
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<Pair> q = new LinkedList<>();
        vis[src] = true;
        q.add(new Pair(src, 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int nbr:g.get(curr.node)){
                if(vis[nbr]||dist[nbr]!=Integer.MAX_VALUE) continue; 
                //any one condn.will do, writing both to signify equivalence
                //else
                dist[nbr] = curr.cost + 1;
                vis[nbr] = true;
                q.add(new Pair(nbr, dist[nbr]));

            }
        }

        for(int i=0;i<v;i++) if(dist[i]==Integer.MAX_VALUE||!vis[i]) dist[i]=-1; 
        //any one condn.will do, writing both to signify equivalence

        return dist;
    }
}
