package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*787. Cheapest Flights Within K Stops
Medium
Topics
Companies
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
Seen this question in a real interview before?
1/5
Yes
No
Accepted
696.1K
Submissions
1.7M
Acceptance Rate
40.1% */
class Tuple{
    int node, cost, stops;
    Tuple(int n, int c, int s){
        node = n;
        cost = c;
        stops = s;
    }
}
class Pair {
    int node, dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class q38_CheapestFlightWithinKstops {
    public int findCheapestPrice(int v, int[][] flights, int src, int dst, int k) 
        // Step 2: Edge case (src == dst)
        if (src == dst) return 0;
        //Construct directed graph
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        for(int i=0;i<v;i++) g.add(new ArrayList<>());
        int e = flights.length;
        for(int i=0;i<e;i++) g.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        //Init Q and dist array
        Queue<Tuple> q = new LinkedList<>();
        int[]dist = new int[v];
        for(int i=0;i<v;i++) dist[i] = (int)1e9;
        dist[src] = 0;
        q.add(new Tuple(src, 0, 0));
        //Loop over q elems
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            
            if(curr.stops>k) continue;

            for(Pair nbr: g.get(curr.node)){
                if (dist[nbr.node]>curr.cost+nbr.dist) {
                    dist[nbr.node]=curr.cost+nbr.dist;
                    q.add(new Tuple(nbr.node, dist[nbr.node], curr.stops+1));
                }
            }
        }
        return (dist[dst]==(int)1e9)? -1:dist[dst];
    }
}
