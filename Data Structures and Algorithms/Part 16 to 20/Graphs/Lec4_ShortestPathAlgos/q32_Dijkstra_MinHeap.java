package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*Dijkstra Algorithm
Difficulty: MediumAccuracy: 50.83%Submissions: 209K+Points: 4Average Time: 25m
Given a weighted, undirected and connected graph where you have given adjacency list adj. You have to find the shortest distance of all the vertices from the source vertex src, and return a list of integers denoting the shortest distance between each node and source vertex src.

Note: The Graph doesn't contain any negative weight edge.

Examples:

Input: adj = [[[1, 9]], [[0, 9]]], src = 0
Output: [0, 9]
Explanation:

The source vertex is 0. Hence, the shortest distance of node 0 is 0 and the shortest distance from node 0 to 1 is 9.
Input: adj = [[[1, 1], [2, 6]], [[2, 3], [0, 1]], [[1, 3], [0, 6]]], src = 2
Output: [4, 3, 0]
Explanation:

For nodes 2 to 0, we can follow the path 2-1-0. This has a distance of 1+3 = 4, whereas the path 2-0 has a distance of 6. So, the Shortest path from 2 to 0 is 4.
The shortest distance from 0 to 1 is 1 .
Constraints:
1 ≤ no. of vertices ≤ 1000
0 ≤ adj[i][j] ≤ 1000
0 ≤ src < no. of vertices
Company Tags
FlipkartMicrosoft */
public class q32_Dijkstra_MinHeap {
    class iPair {
        int first, second;
    
        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int v = adj.size();
        int [] d = new int[v];
        Arrays.fill(d, (int)(1e9));
        d[src]=0;
        PriorityQueue<iPair> pq = new PriorityQueue<>((x,y)->x.second-y.second);
        pq.add(new iPair(src, 0));
        while(!pq.isEmpty()){
            iPair curr = pq.poll();
            for(iPair nbr: adj.get(curr.first)){
                if(d[nbr.first]>d[curr.first]+nbr.second){
                    d[nbr.first]=d[curr.first]+nbr.second;
                    pq.add(new iPair(nbr.first, d[nbr.first]));
                }
            }
        }
        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> result = new ArrayList<>();
        for (int dist : d) {
            result.add(dist);
        }

        return result;
    }
}
