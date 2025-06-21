package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;
/*547. Number of Provinces
Solved
Medium
Topics
Companies
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.2M
Submissions
1.7M
Acceptance Rate
68.1% */
public class q48_NumberOfConnectedCompsUsingDisjointSet {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        DisjointSet dj=new DisjointSet(v);
        for(int i=0;i<v;i+=1){
            for(int j=0;j<v;j++){
                if(isConnected[i][j]==1){
                    //as there is connection, join them
                    int cu=i;
                    int cv=j;
                    dj.unionByRank(cu, cv);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<v;i++){//no. of set representative/ultimate parents is the #connected comps
            if(dj.findParent(i)==i) cnt++;
        }
        return cnt;
    }
}
/*lc submission
 *  class DisjointSet {
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
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        DisjointSet dj=new DisjointSet(v);
        for(int i=0;i<v;i+=1){
            for(int j=0;j<v;j++){
                if(isConnected[i][j]==1){
                    int cu=i;
                    int cv=j;
                    dj.unionByRank(cu, cv);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<v;i++){
            if(dj.findParent(i)==i) cnt++;
        }
        return cnt;
    }

}
 */