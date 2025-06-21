package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*Minimum Spanning Tree
Difficulty: MediumAccuracy: 47.82%Submissions: 157K+Points: 4Average Time: 25m
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is represented by an adjacency list, where each element adj[i] is a vector containing vector of integers. Each vector represents an edge, with the first integer denoting the endpoint of the edge and the second integer denoting the weight of the edge.

Input:
3 3
0 1 5
1 2 3
0 2 1

Output: 4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Input: 
2 1
0 1 5

  

Output: 5 

Explanation: Only one Spanning Tree is possible which has a weight of 5.
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges.

Company Tags
FlipkartAmazonMicrosoftSamsungCisco
Topic Tags
GreedyGraphData StructuresAlgorithms */

public class q47_Kruskals {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        //Construct set of edges and sort them in ASC order in terms of wt
        //or instead of sorting, use minheap
        PriorityQueue<Edge> edgs = new PriorityQueue<>(Comparator.comparingInt(x->x.w));
        for(int i=0;i<V;i++){
            for(int[] nbr:adj.get(i)){
                int u =i;
                int v=nbr[0];
                int w=nbr[1];
                edgs.add(new Edge(u, v, w));
            }
        } 
        //Create Disjoint set of V length
        DisjointSet dj = new DisjointSet(V);
        int cnt=1; int sum=0;
        Edge[]ans = new Edge[V-1];
        while(cnt!=V){//itr till we reach adding of V-1 edges
            Edge curre=edgs.poll();
            int cu =curre.u;
            int cv=curre.v;
            int cw=curre.w;
            int pu = dj.findParent(cu);
            int pv = dj.findParent(cv);
            if(pv==pu) continue;
            //else incl this edge
            sum+=cw;
            dj.unionBySize(pu, pv);
            ans[cnt-1]=curre;
            cnt++; 
        }
        return sum;
    }
}
//gfg submission
/*
 * //{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
 class Edge {
    int u,v,w;
    Edge(int u, int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}
 class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    //constructor
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(node==parent.get(node)) return node;
        int ulp = findParent(parent.get(node));//go dfs till we find set representative/ultimate parent
        parent.set(node, ulp);//Path Compression
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int uu=findParent(u); int uv=findParent(v);
        if(uu==uv)return;// Already in the same set
        int ru = rank.get(uu);
        int rv = rank.get(uv);
        if(ru==rv){
            rank.set(uu, rank.get(uu)+1);
            parent.set(uv, uu);
        }
        else if(ru>rv) parent.set(uv, uu);
        else parent.set(uu,uv);
    }
    public void unionBySize(int u, int v){
        int uu=findParent(u); int uv=findParent(v);
        if(uu==uv)return;
        int su = size.get(uu);
        int sv = size.get(uv);
        if(su>=sv){
            size.set(uu, su+sv);
            parent.set(uv, uu);
        }
        else{
            size.set(uv, sv+su);
            parent.set(uu, uv);
        }
    }
}

class Solution {
        static int spanningTree(int V, int E, List<List<int[]>> adj) {
        //Construct set of edges and sort them in ASC order in terms of wt
        //or instead of sorting, use minheap
        PriorityQueue<Edge> edgs = new PriorityQueue<>(Comparator.comparingInt(x->x.w));
        for(int i=0;i<V;i++){
            for(int[] nbr:adj.get(i)){
                int u =i;
                int v=nbr[0];
                int w=nbr[1];
                edgs.add(new Edge(u, v, w));
            }
        } 
        //Create Disjoint set of V length
        DisjointSet dj = new DisjointSet(V);
        int cnt=1; int sum=0;
        //Edge[]ans = new Edge[V-1];
        while(cnt!=V){//itr till we reach adding of V-1 edges
            Edge curre=edgs.poll();
            int cu =curre.u;
            int cv=curre.v;
            int cw=curre.w;
            int pu = dj.findParent(cu);
            int pv = dj.findParent(cv);
            if(pv==pu) continue;
            //else incl this edge
            sum+=cw;
            dj.unionBySize(pu, pv);
            //ans[cnt-1]=curre;
            cnt++;
        }
        return sum;
    }
}
 */