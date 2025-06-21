package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Graphs.Lec4_ShortestPathAlgos.q32_Dijkstra_MinHeap.iPair;

public class q34_Dijkstra_Queue {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int v = adj.size();
        int [] d = new int[v];
        Arrays.fill(d, (int)(1e9));
        d[src]=0;
        //PriorityQueue<iPair> pq = new PriorityQueue<>((x,y)->x.second-y.second);
        Queue<iPair>pq=new LinkedList<>();
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
}
