package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*743. Network Delay Time
Medium
Topics
Companies
Hint
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
Seen this question in a real interview before?
1/5
Yes
No
Accepted
645.2K
Submissions
1.1M
Acceptance Rate
56.8%
Topics
Depth-First Search
Breadth-First Search
Graph
Heap (Priority Queue)
Shortest Path
Companies
Hint 1
We visit each node at some time, and if that time is better than the fastest time we've reached 
this node, we travel along outgoing edges in sorted order. Alternatively, we could use Dijkstra's algorithm. */
public class NetworkTimeDelay {
    public int networkDelayTime(int[][] times, int n, int src) {
        //make graph
        ArrayList<ArrayList<GridNode>> g = new ArrayList<>();
        int e = times.length;
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        for(int i=0;i<e;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            g.get(u).add(new GridNode(v, w));
        }
        //apply dijkstra
        int Delay[] = new int[n+1];//n+1 cuz 1-based indexing
        Arrays.fill(Delay, Integer.MAX_VALUE);

        PriorityQueue<GridNode> pq = new PriorityQueue<>((x,y)->x.y-y.y);
        Delay[src]=0;
        pq.add(new GridNode(src, 0));

        while(!pq.isEmpty()){
            GridNode curr = pq.poll();
            int cu = curr.x;
            int cw = curr.y;

            for(GridNode nbr:g.get(cu)){
                int nv = nbr.x;
                int nw = nbr.y;
                int nc = Delay[cu]+nw;
                if(nc < Delay[nv]){
                    Delay[nv] = nc;
                    pq.add(new GridNode(nv, nc));
                }
            }
        }
        // int unreacheable = 0; int maxD = Integer.MIN_VALUE;
        // for(int i=1;i<n;i++){
        //     if(Delay[i]==Integer.MAX_VALUE){
        //         unreacheable++; continue;
        //     }
        //     if(maxD<Delay[i]) maxD = Delay[i];
        // }

        // if(maxD == Integer.MIN_VALUE) return -1; //all nodes unreacheable
        // return maxD;

        // Get the max delay among all nodes
        int maxD = 0;
        for (int i = 1; i <= n; i++) {
            if (Delay[i] == Integer.MAX_VALUE) return -1;
            maxD = Math.max(maxD, Delay[i]);
        }

        return maxD;
    }
}
