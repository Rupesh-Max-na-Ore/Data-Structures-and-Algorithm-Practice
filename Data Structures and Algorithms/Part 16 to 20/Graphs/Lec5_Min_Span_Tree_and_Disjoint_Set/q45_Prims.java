package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class q45_Prims {
    //Careful, assuming undirected graph here, evident from gfg driver code
    static int spanningTree(int V, int E, List<List<int[]>> graph) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1])); //sort as per to wts
        boolean[] visited=new boolean[V];
        int par[] = new int[V];
        Arrays.fill(par,-1);
        int sum=0; int lastnode=-1;
        pq.offer(new int[]{0,-1,0}); //node,parent,weight;//treble<>
        ArrayList<int[]>mst = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[0];
            int up=curr[1];
            int uw=curr[2];
            if(visited[u]) continue;
            visited[u]=true; par[u]=up; lastnode=u;
            sum+=uw; mst.add(curr); //or for directed graph: mst.add(new int[]{up,u,uw});
            for(int[] nbr:graph.get(u)){
                int v=nbr[0];
                int vw=nbr[1];
                if(!visited[v]) pq.add(new int[]{v,u,vw});
            }
            
        } return sum;
        // //if need to reconstruct from parent array only
        // ArrayList<int[]>mstp = new ArrayList<>();
        // int sump=0;
        // if(lastnode==-1) return mstp;
        // while(!(par[lastnode]==-1)){
        //     //sum+=graph.get(par[lastnode])[1];//wrong
        //     int uw=0;
        //     for(int[] nbr:graph.get(u)){
        //         int v=nbr[0];
        //         int vw=nbr[1];
        //         if(v==lastnode) uw=vw;
        //     }
        //     sum+=uw;
        //     mst.add(new int[]{par[lastnode],lastnode,uw});
        //     //update
        //     lastnode=par[lastnode];
        // } return sum;return mst; //as asked
    }
}
// //{ Driver Code Starts


// import java.io.*;
// import java.lang.*;
// import java.util.*;

// public class Main {
//     static BufferedReader br;
//     static PrintWriter ot;

//     public static void main(String args[]) throws IOException {
//         br = new BufferedReader(new InputStreamReader(System.in));
//         ot = new PrintWriter(System.out);
//         int t = Integer.parseInt(br.readLine().trim());
//         while (t-- > 0) {
//             int V = Integer.parseInt(br.readLine().trim());
//             int E = Integer.parseInt(br.readLine().trim());
//             List<List<int[]>> list = new ArrayList<>();
//             for (int i = 0; i < V; i++) list.add(new ArrayList<>());
//             for (int i = 0; i < E; i++) {
//                 String[] s = br.readLine().trim().split(" ");
//                 int a = Integer.parseInt(s[0]);
//                 int b = Integer.parseInt(s[1]);
//                 int c = Integer.parseInt(s[2]);
//                 list.get(a).add(new int[] {b, c});
//                 list.get(b).add(new int[] {a, c});
//             }
//             ot.println(new Solution().spanningTree(V, E, list));

//             ot.println("~");
//         }
//         ot.close();
//     }
// }
// //GFG submission
// // // } Driver Code Ends


// // // User function Template for Java

// // class Solution {
// //     static int spanningTree(int V, int E, List<List<int[]>> graph) {
// //         // Code Here.
// //         PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1])); //sorting according to weights
// //         int[] visited=new int[V];
// //         int sum=0;
// //         pq.offer(new int[]{0,0}); //node,weight;
// //         while(!pq.isEmpty()){
// //             int[] curr=pq.poll();
// //             int u=curr[0];
// //             int wt=curr[1];
// //             if(visited[u]==1) continue;
// //             visited[u]=1;
// //             sum+=wt;
// //             for(int[] nbr:graph.get(u)){
// //                 int v=nbr[0];
// //                 int w=nbr[1];
// //                 if(visited[v]==0) pq.add(new int[]{v,w});
// //             }
            
// //         }
// //         return sum;
        
// //     }
// // }