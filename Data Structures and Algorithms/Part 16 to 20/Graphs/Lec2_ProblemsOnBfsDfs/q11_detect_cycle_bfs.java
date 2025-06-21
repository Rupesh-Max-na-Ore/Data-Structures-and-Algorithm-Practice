package Graphs.Lec2_ProblemsOnBfsDfs;
/*Undirected Graph Cycle
Difficulty: MediumAccuracy: 30.13%Submissions: 527K+Points: 4Average Time: 20m
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether the graph contains any cycle or not. The Graph is represented as an adjacency list, where adj[i] contains all the vertices that are directly connected to vertex i.

NOTE: The adjacency list represents undirected edges, meaning that if there is an edge between vertex i and vertex j, both j will be adj[i] and i will be in adj[j].

Examples:

Input: adj = [[1], [0,2,4], [1,3], [2,4], [1,3]] 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
Input: adj = [[], [2], [1,3], [2]]
Output: 0
Explanation: 

No cycle in the graph.
Constraints:
1 ≤ adj.size() ≤ 105 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class q11_detect_cycle_bfs {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> g) {
        // Code here
        int n = g.size();
        boolean[]vis=new boolean[n];
        boolean ans = false;
        for(int i=0;i<n;i++){
            if(!vis[i]) ans = ans || detectCycle(g, i,vis);
        }
        return ans;
    }
            
    private boolean detectCycle(ArrayList<ArrayList<Integer>> g, int i, boolean[] vis) {
        // Set<Integer> parent = new HashSet<>(); //Can be used to find all nodes with atlest 1 outdegree
        Queue<Integer[]> q = new LinkedList<>();

        q.offer(new Integer[]{i,-1});
        vis[i] =true;

        while(!q.isEmpty()){
            Integer[] curr = q.poll();
            int curri = curr[0];
            int currp = curr[1];

            //redundant mistakes
            // parent.add(currp);
            // vis[curri]=true;

            for(int nbr : g.get(curri)){
                if(!vis[nbr]){
                    q.offer(new Integer[]{nbr,curri});
                    vis[nbr]=true;
                    // parent.add(curri);
                }
                // if adjacent node is visited and is not its own parent node
                else if (currp != nbr) return true;
            }

        } return false;
    }
}
/*
//slightly better looking code
import java.util.*;

public class q11_detect_cycle_bfs {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i] && detectCycle(g, i, vis)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycle(ArrayList<ArrayList<Integer>> g, int src, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, -1});
        vis[src] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curNode = curr[0];
            int parent = curr[1];

            for (int neighbor : g.get(curNode)) {
                if (!vis[neighbor]) {
                    q.offer(new int[]{neighbor, curNode});
                    vis[neighbor] = true;
                } 
                // If the neighbor is visited and not the parent, then there is a cycle.
                else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}

 */