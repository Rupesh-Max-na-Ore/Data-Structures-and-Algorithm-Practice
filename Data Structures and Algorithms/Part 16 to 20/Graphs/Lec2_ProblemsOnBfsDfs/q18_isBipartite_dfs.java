package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class q18_isBipartite_dfs {
    public boolean isBipartite(int[][] graph) {
        int v  = graph.length;
        int  [] color = new int[v];
        for(int i=0;i<v;i++) color[i]=-1;

        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(!dfs_check(graph,i,0,color)) return false;
            }
        }
        return true;
    }

    private boolean dfs_check(int[][] graph, int curNode, int clr, int[] color) {
        color[curNode]=clr;

        for(int nbr: graph[curNode]){
            if(color[nbr]==-1 && !dfs_check(graph, nbr, 1-clr, color)) return false;
            else if(clr==color[nbr]) return false;
        }
        return true;
    }
}
