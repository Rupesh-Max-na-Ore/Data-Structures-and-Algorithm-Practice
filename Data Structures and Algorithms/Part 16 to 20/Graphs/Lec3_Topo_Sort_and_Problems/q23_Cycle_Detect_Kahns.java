package Graphs.Lec3_Topo_Sort_and_Problems;
/*Cycle in a Directed Graph
Difficulty: MediumAccuracy: 27.88%Submissions: 452K+Points: 4
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as an adjacency list, where adj[i] contains a list of vertices that are directly reachable from vertex i. Specifically, adj[i][j] represents an edge from vertex i to vertex j.

Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle
Example 2:
Input:


Output: 0
Explanation: no cycle in the graph
Constraints:
1 ≤ V, E ≤ 105

Company Tags
FlipkartAmazonMicrosoftSamsungMakeMyTripOracleGoldman SachsAdobeBankBazaarRockstand */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q23_Cycle_Detect_Kahns {
     // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> g) {
        // code here
        int v=g.size();
        int [] indegree=new int[v];
        for(int i=0;i<v;i++){
            for(int nbr:g.get(i)) indegree[nbr]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0)q.offer(i);
        }
        //ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            //ans.add(curr);
            i++;
            for(int nbr:g.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr]==0)q.add(nbr);
            }
        }

        return (i==v)?false:true;
    }
}
