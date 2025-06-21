package Graphs.Lec6_Other_Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1192. Critical Connections in a Network
Hard
Topics
Companies
Hint
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
267.5K
Submissions
466.4K
Acceptance Rate
57.4%
Topics
Depth-First Search
Graph
Biconnected Component
Companies
Hint 1
 */
public class q55_Bridges {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //make undir graph
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i< connections.size();i++){
         int u= connections.get(i).get(0); int v= connections.get(i).get(1);
         g.get(u).add(v); g.get(v).add(u);
        }
        boolean[]vis = new boolean[n];
        int[]tin=new int[n];
        int[]low=new int[n];
        int timer=1;
        List<List<Integer>> bridges = new ArrayList<>();
        //Start DFS with any node
        int node = 0; int parent =-1;
        DFStarjan(g,node,parent,vis,tin,low,timer,bridges);
        return bridges;
    }

    private void DFStarjan(ArrayList<ArrayList<Integer>> g, int node, int parent, boolean[] vis, int[] tin, int[] low, int timer,
         List<List<Integer>> bridges) {
      vis[node]=true;
      tin[node] = low[node]=timer;
      for(int nbr:g.get(node)){
         if(nbr==parent)continue;
         if(vis[nbr]) low[node] = Math.min(low[node], low[nbr]); //nbr already vistd from some other path
         else{
            DFStarjan(g,nbr,node,vis,tin,low,timer+1,bridges);
            low[node] = Math.min(low[node], low[nbr]);
            if(tin[node]<low[nbr]){
               //can only reach to nbr in lowest time thru curr node-->bridge
               bridges.add(Arrays.asList(nbr,node));
            }
         }
      }
    }
}
/*@pulkitjain5159
1 year ago (edited)
Comments Padke and Video dekh ke I felt thoda lost , doosri teesri baar dekhne pe thoda anaolgy se samjhne ka try kiya then samajh aya thoda kya hora hai.
theek toh m thoda samjhane ka try karta hu , suppose 
1.)  TIN[ node ] is ki mujhe is node tak aane m kitna time laga , 
2.) LOW[ node ] tells ki mujhe is node pe aane pe minimum kitna time laga.

ab ise dekho , suppose m parent pe khada hu aur m child pe gaya tha ->
when we got a bridge :->
parent -> dekh child mujhe khud tak aane m TIN [ parent ] = 8 sec(suppose)  lage hai toh m tujh tak toh 9th second m pahuch jaunga 
child -> yaar parent 🥲, mujhtak toh minimum aane m hi LOW[ child ] = 10 sec lag jayenge , kaha se ayega tu mujhtak
TIN[ parent ]  < low [ child ].
hence we got a bridge.
when not a bridge :->
parent -> dekh child mujhe khud tak aane m TIN [ parent ] = 8(suppose) sec lage hai toh m tujh tak toh 9th second m pahuch jaunga 
child -> are parent mein toh khud par  LOW[ child ] = 6 sec  m hi pahuch jaunga , tu esa kar mere saath aja , jaldi pahuch jayega 
LOW [ parent ] = LOW [ child ].

let's write a pseudo code using this analogy
 dfs( node , parent , timer ){
   visited [ node ] = true; // mark myself visited 
   tin [ node ] = low [ node ] = timer;  // noting the time at which i came on this node
   timer++; // increase the timer
    // get all neighbours 
    for( nbr : adj [ node ] ){
       if(nbr == parent ) continue; // leave it
        if(visited [ nbr ] == true ) {
           // lol , phele se hi visited hai definetly kisi aur raste se aya hoga isliye visited hogya
            // sirf low ki baat cheet kar sakta yani mein
             low [  node ] = min( low [ node ] , low [  nbr ] );
          }else{ 
               // visited nahi hai ,  yani yaha m parent child wali baate kar sakta hu , child mera nbr ban jayega , parent meri node
               dfs( nbr , node  , timer + 1)
               // now , parent bolta , mujhtak aane ka time TIN , tu tera minimum bata 
                // mereko minimu hi LOW[ nbr ] time lagra 🥲, tujhe toh aur time lag jayega 
                  if( low [ nbr ] > tin [ node ] ){
                              // found potential bridge
                   }
               // mereko minimum LOW[ nbr ] time lagra , aur yeh tujhtak ( parent ) pahuchne  ke time se better hai , ise badiya tu mere through aja
                else{
                           low [ node ] = min( low [ node ] , low [ nbr ]);
                 }
               
         }

 */