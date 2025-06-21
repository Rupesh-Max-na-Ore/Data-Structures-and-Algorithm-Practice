package Graphs.Lec3_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;


public class q25_Eventual_safe_nodes_ToposortVersn {
    public List<Integer> eventualSafeNodes(int[][] g) {
        //make reversed graph
        int n=g.length;
        ArrayList<Integer>[] rg=new ArrayList[n];
        for(int i=0;i<n;i++) rg[i] = new ArrayList<>();
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            //i-->j to j-->i : all incoming become outgoing
            for(int nbr:g[i]){
                indegree[i]++;
                rg[nbr].add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        //push 0 indeg
        for(int i=0;i<n;i++) if(indegree[i]==0) q.offer(i);

        //get non-cyclic nodes
        int cnt=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            ans.add(curr);
            for(int nbr:rg[curr]){
                indegree[nbr]--;
                if(indegree[nbr]==0)q.offer(nbr);
            }
        }

        Collections.sort(ans);
        return ans;
    }    
}
