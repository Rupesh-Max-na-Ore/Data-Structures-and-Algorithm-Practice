package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
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
