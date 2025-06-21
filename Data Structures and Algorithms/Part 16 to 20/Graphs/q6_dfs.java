package Graphs;

import java.util.ArrayList;

public class q6_dfs {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> gp) {
        // Code here
        int v = gp.size();
        boolean visited[]=new boolean[v];//O-based indexing
        ArrayList<Integer> traversal = new ArrayList<>();
        int start = 0;//0 is always start node as per Q.
        for(int i=start;i<v;i++){
            if(!visited[i]){
                dfs(gp,visited,v,i,traversal);
            }
        }
        return traversal;
    }
                
    private void dfs(ArrayList<ArrayList<Integer>> gp, boolean[] visited, int v, int i, ArrayList<Integer> traversal) {
        visited[i]=true;
        traversal.add(i);
        for(int nbr: gp.get(i)){
            if(!visited[nbr]){
                dfs(gp, visited, v, nbr, traversal);
            }
        }
    }
}
