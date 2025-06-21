package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;
/*Q6 M-Coloring Problem
MediumAccuracy: 34.42%Submissions: 117K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:

Input:
N = 4
M = 3
E = 5
Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.
Example 2:

Input:
N = 3
M = 2
E = 3
Edges[] = {(0,1),(1,2),(0,2)}
Output: 0
Your Task:
Your task is to complete the function graphColoring() which takes the 2d-array graph[], the number of colours and the number of nodes as inputs and returns true if answer exists otherwise false. 1 is printed if the returned value is true, 0 otherwise. The printing is done by the driver's code.
Note: In Example there are Edges not the graph.Graph will be like, if there is an edge between vertex X and vertex Y graph[] will contain 1 at graph[X-1][Y-1], else 0. In 2d-array graph[ ], nodes are 0-based indexed, i.e. from 0 to N-1.Function will be contain 2-D graph not the edges.

Expected Time Complexity: O(MN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 20
1 ≤ E ≤ (N*(N-1))/2
1 ≤ M ≤ N */
public class M_coloring {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean g[][], int m, int n) {
        // Your code here
        if(m>=n) return true;
        if(n>0 && m==0) return false;
        int color[]=new int[n];//store color of each node
        if(canColor(0, g, m, n, color)) return true;
        return false;
    }

    private boolean canColor(int Node, boolean[][] g, int m, int n, int[] color) {
        if(Node==n) return true; // reach beyond last node == have colored all nodes
        for(int i=1; i<=m;i++){
            if(NeighbourCheck(Node, g, m,n,i, color)){
                color[Node]=i;
                if(canColor((Node+1), g, m, n, color)) return true;
                color[Node]=0; // Backtrack
            }
        } return false;
    }
    private boolean NeighbourCheck(int node, boolean[][] g, int m, int n, int colorToCheck, int[] color) {
        // Srch all neighbor nodes
        for (int j = 0; j < n; j++) {
            // If there's an edge between node and j and j has the same color, return false
            if (g[node][j] && color[j] == colorToCheck) return false;
        }
        return true;
    }
    // private boolean NeighbourCheck(int node, boolean[][] g, int m, int n, int i, int[] color) {
    //     //srch all nbr nodes
    //     for(int j=0; j<g[node].length; j++){
    //         if(color[j]==i) return false;
    //     } return true;
    // }
}
