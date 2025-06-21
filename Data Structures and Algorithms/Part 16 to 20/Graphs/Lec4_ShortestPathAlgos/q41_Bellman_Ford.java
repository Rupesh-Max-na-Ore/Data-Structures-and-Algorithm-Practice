package Graphs.Lec4_ShortestPathAlgos;

import java.util.Arrays;

/*Bellman-Ford
Difficulty: MediumAccuracy: 48.11%Submissions: 175K+Points: 4Average Time: 25m
Given a weighted and directed graph of v vertices and edges, Find the shortest distance of all the vertex's from the source vertex, src 
and return a list of integers where the ith integer denotes the distance of the ith node from the source node. If a vertices can't be reach 
from the s then mark the distance as 10^8.
Note: If there exist a path to a negative weighted cycle from the source node then return {-1}.

Examples:

Input: edges = [[0,1,9]], src = 0

Output: [0, 9]
Explanation: Shortest distance of all nodes from source is printed.
Input: edges = [[0,1,5], [1,0,3], [1,2,-1], [2,0,1]], src = 2

Output: [1, 6, 0]
Explanation: For nodes 2 to 0, we can follow the path: 2-0. This has a distance of 1. For nodes 2 to 1, we cam follow the path: 2-0-1, 
which has a distance of 1+5 = 6,
Constraints:
1 ≤ V ≤ 500
1 ≤ E ≤ V*(V-1)
-1000 ≤ data of nodes, weight ≤ 1000
0 ≤ S < V

Company Tags
AmazonMicrosoft
Topic Tags
Dynamic ProgrammingGraphData StructuresAlgorithms */
public class q41_Bellman_Ford {
    static int[] bellmanFord(int n, int[][] edges, int src) {
        int e = edges.length;
        int [] d = new int[n];
        Arrays.fill(d, (int)1e8);
        d[src] = 0;
        boolean chg=false;
        for(int i=0; i<=n;i++){
            for(int[] edg: edges){
                int u=edg[0];
                int v=edg[1];
                int w=edg[2];
                if(d[u]==(int)1e8) continue; // comparison useless here
                if(d[v]<= d[u]+w) continue;
                d[v]=d[u]+w;
                if(i==n) chg = true;
            }
        } // absolute speediness do nth itr outside loop and check, reduces operations per loop as need to check i==n for chg
        return (chg==true)?(new int[]{-1}):d;
    }
}

