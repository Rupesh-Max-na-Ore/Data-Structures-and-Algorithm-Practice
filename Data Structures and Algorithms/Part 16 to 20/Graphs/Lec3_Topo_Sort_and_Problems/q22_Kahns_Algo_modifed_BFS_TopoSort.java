package Graphs.Lec3_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/* */
public class q22_Kahns_Algo_modifed_BFS_TopoSort {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> g){
        int v=g.size();
        int [] indegree=new int[v];
        for(int i=0;i<v;i++){
            for(int nbr:g.get(i)) indegree[nbr]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0)q.offer(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            i++;
            for(int nbr:g.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr]==0)q.add(nbr);
            }
        }

        return ans;
    }
}
