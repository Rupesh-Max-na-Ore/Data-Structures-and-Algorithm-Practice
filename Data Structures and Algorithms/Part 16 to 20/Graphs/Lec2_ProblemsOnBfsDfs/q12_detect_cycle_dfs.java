package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* */
public class q12_detect_cycle_dfs {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> g) {
        // Code here
        int n = g.size();
        boolean[]vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]) if (detectCycle(g, i,-1, vis)) return true;
        }
        return false;
    }
            
    private boolean detectCycle(ArrayList<ArrayList<Integer>> g, int i,int par,  boolean[] vis) {
        vis[i] =true;
        for(int nbr : g.get(i)){
            if(!vis[nbr]){
                if(detectCycle(g, nbr, i, vis)) return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if (par != nbr) return true;
        }
        return false;
    }
}
