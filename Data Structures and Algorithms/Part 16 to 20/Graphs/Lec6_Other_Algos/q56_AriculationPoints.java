package Graphs.Lec6_Other_Algos;

import java.util.ArrayList;
import java.util.Arrays;

/*Articulation Point - I
Difficulty: HardAccuracy: 39.26%Submissions: 73K+Points: 8Average Time: 20m
Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Example 1:

Input:

Output:{1,4}
Explanation: Removing the vertex 1 will
discconect the graph as-

Removing the vertex 4 will disconnect the
graph as-

 

Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.
 

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 

Constraints:
1 ≤ V ≤ 105

Topic Tags
GraphData Structures */
public class q56_AriculationPoints {
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> g)
    {
        int[]disc = new int[V];
        int[]low = new int[V];
        boolean[]ap=new boolean[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        int[]timer = new int[]{1};

        for(int i=0; i<V;i++){
            if(disc[i]==-1){
                //i not vistd so visit it
                int u = i;
                int parent =-1;
                DFS(g,u,parent,disc,low,ap,timer); 
            }
        }
        ArrayList<Integer> aps = new ArrayList<>();
        for(int i=0;i<V;i++) if(ap[i]) aps.add(i);
        if(aps.isEmpty()) aps.add(-1);
        return aps;

    }

    private void DFS(ArrayList<ArrayList<Integer>> g, int u, int parent, int[] disc, int[] low, boolean[] ap,
            int[] timer) {
        disc[u]=low[u]=timer[0]++;
        int childCount=0;
        for(int v:g.get(u)){
            if(v==parent) continue;
            if(disc[v]==-1){//not vistd
                childCount++;
                DFS(g, v, u, disc, low, ap, timer);
                if(low[u]>low[v]) low[u]=low[v];
                //case 1: node is root
                if(parent==-1){
                    if(childCount>1) ap[u] = true;
                }    
                //case 2: node is not root, find if no backedge to ancestor exist
                if(parent!=-1){
                    //wrong
                    //if(low[u]<=disc[v]) ap[u]=true;
                    if(disc[u]<=low[v]) ap[u]=true; //imply no backedge
                } 
            } else if(low[u]>disc[v]) low[u]=disc[v]; //alredy vistd, just update low if reqd.
        }
    }
}
