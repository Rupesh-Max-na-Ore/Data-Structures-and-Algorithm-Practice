package Graphs.Lec6_Other_Algos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/*Strongly Connected
Difficulty: MediumAccuracy: 50.61%Submissions: 105K+Points: 4Average Time: 20m
Given an adjacency list, adj of Directed Graph, Find the number of strongly connected components in the graph.
 

Examples :

Input: adj[][] = [[2, 3], [0], [1], [4], []]

Output: 3
Explanation: We can clearly see that there are 3 Strongly Connected Components in the Graph.
 
Input: adj[][] = [[1], [2], [0]]

Output: 1
Explanation: All of the nodes are connected to each other. So, there's only one SCC.
Input: adj[][] = [[1], []]
Output: 2
Constraints:
2<=adj.size()<=106
0<=edges<=adj.size()-1

 */
public class q54_KosarajuAlgo_Strongly_Connected_Components {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        
        // Step 1: DFS to get stack order
        Deque<Integer> st = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) 
                DFSstackOrder(g, i, vis, st);
        }

        // Step 2: Transpose the graph
        ArrayList<ArrayList<Integer>> gt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gt.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int nbr : g.get(i)) {
                gt.get(nbr).add(i); // Reverse edges
            }
        }

        // Step 3: DFS on transposed graph in decreasing finish time order
        int scc = 0;
        vis = new boolean[n]; // Reset visited array

        ArrayList<ArrayList<Integer>> sccList = new ArrayList<>(); // Store SCCs

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                ArrayList<Integer> currSCC = new ArrayList<>();
                DFSnormal(gt, node, vis, currSCC);
                sccList.add(currSCC);
                scc++;
            }
        }

        // // Print SCCs (optional)
        // System.out.println("Strongly Connected Components:");
        // for (ArrayList<Integer> comp : sccList) {
        //     System.out.println(comp);
        // }

        return scc;
    }

    private void DFSstackOrder(ArrayList<ArrayList<Integer>> g, int node, boolean[] vis, Deque<Integer> st) {
        vis[node] = true;
        for (int nbr : g.get(node)) {
            if (!vis[nbr]) 
                DFSstackOrder(g, nbr, vis, st);
        }
        st.push(node); // Push after finishing DFS
    }

    private void DFSnormal(ArrayList<ArrayList<Integer>> gt, int node, boolean[] vis, ArrayList<Integer> currSCC) {
        vis[node] = true;
        currSCC.add(node);
        for (int nbr : gt.get(node)) {
            if (!vis[nbr]) 
                DFSnormal(gt, nbr, vis, currSCC);
        }
    }
    ////1st attempt, little wrong
    // // Function to find number of strongly connected components in the graph.
    // public int kosaraju(ArrayList<ArrayList<Integer>> g) {
    //     // code here
    //     int n = g.size();
    //     //Do dfs with fifo stack insert at end of calls to get sorted list with dsc finish time.
    //     Deque<Integer> st = new ArrayDeque<>(); //non-thread safe, but faster stack, interface instead of vector class extension
    //     boolean[]vis = new boolean[n];
    //     for(int i=0;i<n;i++){
    //         if(!vis[i]) DFSstackOrder(g, i, vis, st);
    //     }
    //     //Transpose all edges to get reversed edges graph
    //     ArrayList<ArrayList<Integer>> gt = new ArrayList<>();
    //     for (int i = 0; i < n; i++) gt.add(new ArrayList<>());
    //     for(int i=0;i<n;i++){
    //         //if u->v, then add v->u
    //         for(int nbr:g.get(i)){
    //             gt.get(nbr).add(i);
    //         }
    //     }
    //     //DFS over gt to get isolated connected comps
    //     int scc=0;
    //     ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();
    //     while(!st.isEmpty()){
    //         int i=st.pollFirst();
    //         if(vis[i]){//resuse vis but in inversse way
    //             ArrayList<Integer> currSCC = new ArrayList<>();
    //             DFSnormal(gt,i,vis, currSCC);
    //             sccList.add(currSCC);
    //             scc++;
    //         }
    //     }
    //     return scc;

    // }

    // private void DFSnormal(ArrayList<ArrayList<Integer>> gt, int i, boolean[] vis, ArrayList<Integer> currSCC) {
    //     vis[i]=false;
    //     currSCC.add((i));
    //     for(int nbr:gt.get(i)){
    //         if(vis[nbr]){
    //             DFSnormal(gt, nbr, vis, currSCC);
    //         }
    //     }
    // }

    // private void DFSstackOrder(ArrayList<ArrayList<Integer>> g, int i, boolean[] vis, Deque<Integer> st) {
    //     vis[i]=true;
    //     for(int nbr:g.get(i)){
    //         if(!vis[nbr]) DFSstackOrder(g, nbr, vis, st);
    //     }
    //     st.add(i);
    // }

}
