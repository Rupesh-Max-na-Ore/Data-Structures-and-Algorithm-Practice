package Graphs.Lec2_ProblemsOnBfsDfs;
/*Number of Provinces
Difficulty: MediumAccuracy: 54.29%Submissions: 141K+Points: 4Average Time: 20m
Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.
Example 2:
Input:
[
 [1, 1],
 [1, 1]
]

Output :
1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function numProvinces() which takes an integer V and an adjacency matrix adj(as a 2d vector) as input and returns the number of provinces. adj[i][j] = 1, if nodes i and j are connected and adj[i][j] = 0, if not connected.


Expected Time Complexity: O(V2)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V ≤ 500 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q8_Number_of_Islands {
    static int numProvinces(ArrayList<ArrayList<Integer>> gp, int v) {
        // code here
        boolean vis[]=new boolean[v];
        int comps=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                comps++;
                bfs(i,v,gp,vis);
            }
        } return comps;

    }
    public static void bfs(int i, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        // mark visited while putting in queue
        // when take out from q, it is only to extract nbrs
        // boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);// s=i
        visited[i]=true;
        ArrayList<Integer> path_taken = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;

            for(int j=0;j<v;j++){
                int nbr=j;
                if(adj.get(node).get(nbr) != 0 && !visited[nbr]){
                    q.offer(nbr);
                    visited[nbr]=true;
                    path_taken.add(nbr);
                }
            }
        } 
    }
}

