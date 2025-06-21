package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class q35_Print_Sortest_Path {
    ArrayList<Integer> print_dijkstra(ArrayList<ArrayList<Pair>> adj, int src, int dest) {
        // Write your code here
        int v = adj.size();
        int [] d = new int[v];
        Arrays.fill(d, (int)(1e9));
        int [] parent = new int[v];
        Arrays.fill(parent, (int)(-1e9));
        d[src]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.dist-y.dist); 
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            for(Pair nbr: adj.get(curr.node)){
                if(d[nbr.node]>d[curr.node]+nbr.dist){
                    parent[nbr.node] = curr.node;
                    d[nbr.node]=d[curr.node]+nbr.dist;
                    pq.add(new Pair(nbr.node, d[nbr.node]));
                }
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        int node = dest;
        while(!(parent[node]==node)){
            path.add(node);
            node = parent[node];
        }
        Collections.reverse(path);
        return path;
    }
}
