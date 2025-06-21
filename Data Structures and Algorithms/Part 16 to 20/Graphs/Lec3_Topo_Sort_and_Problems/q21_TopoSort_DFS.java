package Graphs.Lec3_Topo_Sort_and_Problems;
/*Topological sort
Difficulty: MediumAccuracy: 56.52%Submissions: 267K+Points: 4Average Time: 15m
Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all vertices v such that there exists a directed edge u -> v. Return topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be 1 else 0.

Examples:

Input: adj = [[], [0], [0], [0]] 

Output: 1
Explanation: The output 1 denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
Input: adj = [[], [3], [3], [], [0,1], [0,2]]

Output: 1
Explanation: The output 1 denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
Constraints:
2  ≤  V  ≤  103
1  ≤  E  ≤  (V * (V - 1)) / 2

Company Tags
Moonfrog LabsFlipkartMorgan StanleyAccoliteAmazonMicrosoftOYO RoomsSamsungD-E-ShawVisa */
import java.util.ArrayList;
import java.util.Stack;

public class q21_TopoSort_DFS {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> g) {
        // Your code here
        int v = g.size();
        boolean[]vis=new boolean[v];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<v;i++) if(!vis[i]) dfs(g,i,st,vis);
                ArrayList<Integer> ans = new ArrayList<>();
                for(int i=0;i<v;i++) ans.add(st.pop());
                return ans;
            }
        
            private static void dfs(ArrayList<ArrayList<Integer>> g, int curr, Stack<Integer> st, boolean[] vis) {
                vis[curr]=true;
                for(int nbr:g.get(curr)) if(!vis[nbr]) dfs(g, nbr, st, vis);
                st.push(curr);
            }
}
