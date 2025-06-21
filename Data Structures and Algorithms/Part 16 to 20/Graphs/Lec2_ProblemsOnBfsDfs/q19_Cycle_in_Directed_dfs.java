package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.ArrayList;

public class q19_Cycle_in_Directed_dfs {
    //vis[] to check if every node has been visited at least once(reqd. for multi-component graph) && to not keep re-checking already visited subgraphs, 
    //pathVis[] to check if it exists in current path
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        for(int i=0;i<V;i++){
            //if not visted, then check for cycle using dfs
            if(!vis[i] && dfsCheck(i, adj, vis, pathVis)) return true;
        }
        return false;
    }
    // returns true if cycle detected at any node, else false
    private boolean dfsCheck(int CurrNode, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[]){
        vis[CurrNode]=true;
        pathVis[CurrNode]=true;

        for(int nbr: adj.get(CurrNode)){
            //if not visited, then check for cycle recursively using dfs
            if(!vis[nbr] && dfsCheck(nbr, adj, vis, pathVis)) return true;
            //if it has been visted before, but not in/from same as current path, still no cycle exist
            else if(!pathVis[nbr]) return false;
        }
        //bactrack pathVis marked node
        pathVis[CurrNode]=false;
        return false;
    }
}
