package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
Medium
Topics
Companies
Hint
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

 

Example 1:



Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
Example 2:



Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
Output: 0
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4] 
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2.
 

Constraints:

2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
243.1K
Submissions
350K
Acceptance Rate
69.5% */
public class q43_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    public int findTheCity(int v, int[][] edge, int th) {
        //Make Adjacency Matrix
        int[][]d = new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++)
            {
                d[i][j]=Integer.MAX_VALUE;
            } d[i][i]=0;
        }
        int e = edge.length;
        for(int i=0;i<e;i++){
            int u = edge[i][0];
            int vi= edge[i][1];
            int w = edge[i][2];
            d[u][vi]=w;
            d[vi][u]=w;
        }
        //Flloyd Warshall
        for(int k=0;k<v;k++ ){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++) {
                    if(d[i][k]==Integer.MAX_VALUE||d[k][j]==Integer.MAX_VALUE) continue;
                    d[i][j] = Math.min(d[i][j], (d[i][k]+d[k][j]));
                }
            }
        }

        //for every node, find the no. of nodes it can reach within thereshaold dist, take node that gibs min. of that
        int mc=v,mn=v-1;
        for(int src=0;src<v;src++){
            int c=0;
            for(int dst=0;dst<v;dst++){
                if(d[src][dst]<=th) c++;
            }
            if(mc<c) continue;
            //else
            mc = c;
            mn = src;
        }
        return mn;
    }
    //Use Dijkstra
    public int findTheCity2(int v, int[][] edge, int th){
        //make adjacency list
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        int e = edge.length;
        for(int i=0;i<v;i++) g.add(new ArrayList<>());
        for(int i=0;i<e;i++){
            int u = edge[i][0];
            int vi= edge[i][1];
            int w = edge[i][2];
            g.get(u).add(new Pair(vi, w));
            g.get(vi).add(new Pair(u, w));
        }
        //Make Dist Matrix to store shortest dist
        int[][]d = new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++)
            {
                d[i][j]=Integer.MAX_VALUE;
            } d[i][i]=0;
        }
        for(int i=0;i<e;i++){
            int u = edge[i][0];
            int vi= edge[i][1];
            int w = edge[i][2];
            d[u][vi]=w;
            d[vi][u]=w;
        }
        //Apply Dijkstra, taking each node as src one by one
        for(int src=0;src<v;src++){
            PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingInt(x -> x.dist)) ;
            pq.add(new Pair(src, 0));
            int[]di = new int[v];  Arrays.fill(di, (int) 1e9); di[src]=0;
            while(!pq.isEmpty()){
                Pair curr =pq.poll();
                int cv=curr.node;
                int cw=curr.dist;
                for(Pair nbr:g.get(cv)){
                    int nn = nbr.node;
                    int nw = nbr.dist;
                    if(di[nn]>cw+nw){
                        di[nn]=cw+nw;
                        pq.add(new Pair(nn, di[nn]));
                    }
                }
            }
            for(int dst=0;dst<v;dst++){
                d[src][dst]=di[dst];
            }

        }
        //for every node, find the no. of nodes it can reach within thereshaold dist, take node that gibs min. of that
        int mc=v,mn=v-1;
        for(int src=0;src<v;src++){
            int c=0;
            for(int dst=0;dst<v;dst++){
                if(d[src][dst]<=th) c++;
            }
            if(mc<c) continue;
            //else
            mc = c;
            mn = src;
        }
        return mn;

    }
}
