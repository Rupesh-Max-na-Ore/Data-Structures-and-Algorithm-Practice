package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*1976. Number of Ways to Arrive at Destination
Medium
Topics
Companies
Hint
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
179.6K
Submissions
474.9K
Acceptance Rate
37.8% */
/*Leetcode soln sttempt
 * class Pair {
    int node; long dist;

    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int) 1e9 + 7;
        //construct undirected graph
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        int e = roads.length;
        for(int i=0;i<e;i++) {
            g.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            g.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        //init data structs
        int[]ways=new int[n]; ways[0]=1;
        //both below work, 1e11/19e10 starts to fail, 2e11 starts to work tho
        long[]d = new long[n];  Arrays.fill(d, Long.MAX_VALUE/2); d[0]=0;
        // long[]d = new long[n];  Arrays.fill(d, (long)1e12); d[0]=0;
        //3 ways to write same comparator, 2nd & 3rd preferred
        //PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.dist-y.dist);
        //PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> Integer.compare(x.dist, y.dist));
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.dist));
        pq.add(new Pair(0, 0));
        //Loop thru pq elems
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int cn = curr.node;
            long cd = curr.dist;
            if (cd > d[cn]) continue; // If the current distance is greater than recorded, ignore
            for(Pair nbro : g.get(cn)){
                int nbr = nbro.node;
                long nc = nbro.dist;
                if(d[nbr]>cd+nc){
                    d[nbr]=cd+nc;
                    ways[nbr] = ways[cn];
                    pq.add(new Pair(nbr, d[nbr]));
                }
                else if(d[nbr]==cd+nc){
                    ways[nbr]=(ways[nbr]+ways[cn]) % mod;
                }
            }
        } return ways[n-1];
    }
}
 */
public class q40_Number_of_Ways_to_Arrive_at_Destination {
    public int countPaths(int n, int[][] roads) {
        int mod = (int) 1e9 + 7;
        //construct undirected graph
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        int e = roads.length;
        for(int i=0;i<e;i++) {
            g.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            g.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        //init data structs
        int[]ways=new int[n]; ways[0]=1;
        int[]d = new int[n];  Arrays.fill(d, (int) 1e9); d[0]=0;
        //3 ways to write same comparator, 2nd & 3rd preferred
        //PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.dist-y.dist);
        //PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> Integer.compare(x.dist, y.dist));
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));
        pq.add(new Pair(0, 0));
        //Loop thru pq elems
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int cn = curr.node;
            int cd = curr.dist;
            if (cd > d[cn]) continue; // If the current distance is greater than recorded, ignore
            for(Pair nbro : g.get(cn)){
                int nbr = nbro.node;
                int nc = nbro.dist;
                if(d[nbr]>cd+nc){
                    d[nbr]=cd+nc;
                    ways[nbr] = ways[cn];
                    pq.add(new Pair(nbr, d[nbr]));
                }
                else if(d[nbr]==cd+nc){
                    ways[nbr]+=ways[cn] % mod;
                }
            }
        } return ways[n-1];
    }
}
/* gfg soln attempt
class Pair {
    int node;
    long distance;
    
    Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    

    static int countPaths(int n, List<List<Integer>> roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        int m = roads.size();
        for(int i = 0; i < m;i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> (int)(x.distance - y.distance));
        pq.add(new Pair(0,0));
        long[] dist = new long[n];
        int[] ways = new int[n];
        for(int i = 0; i < n;i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9 + 7);
        
        while(pq.size() != 0) {
            Pair ele = pq.peek();
            pq.remove();
            int node = ele.node;
            long distance = ele.distance;
            
            for(Pair pair:adj.get(node)) {
                int adjNode = pair.node;
                long adjDist = pair.distance;
                if(adjDist + distance < dist[adjNode]) {
                    dist[adjNode] = adjDist + distance;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, adjDist + distance));
                }
                else if(adjDist + distance == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1];
        

    }
}*/
/*For all those, whose 13th test case is failing in GFG, just change distance /weights to long and take the maximum value as Long.MAX_VALUE

class Pair {
    int node;
    long distance;
    
    Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    

    static int countPaths(int n, List<List<Integer>> roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        int m = roads.size();
        for(int i = 0; i < m;i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> (int)(x.distance - y.distance));
        pq.add(new Pair(0,0));
        long[] dist = new long[n];
        int[] ways = new int[n];
        for(int i = 0; i < n;i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9 + 7);
        
        while(pq.size() != 0) {
            Pair ele = pq.peek();
            pq.remove();
            int node = ele.node;
            long distance = ele.distance;
            
            for(Pair pair:adj.get(node)) {
                int adjNode = pair.node;
                long adjDist = pair.distance;
                if(adjDist + distance < dist[adjNode]) {
                    dist[adjNode] = adjDist + distance;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, adjDist + distance));
                }
                else if(adjDist + distance == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
        
        
        // Your code here
    }
} */