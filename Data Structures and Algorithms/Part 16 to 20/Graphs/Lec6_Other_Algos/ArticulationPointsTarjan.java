package Graphs.Lec6_Other_Algos;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointsTarjan {
    int time = 0;
    int n;
    ArrayList<ArrayList<Integer>> graph;
    ArticulationPointsTarjan(int v, ArrayList<ArrayList<Integer>> g){
        n=v;
        graph=g;//not reqd actually, just call fn below
        findArticulationPoints(v, g);
    }
    public void findArticulationPoints(int n, ArrayList<ArrayList<Integer>> graph) {
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] isArticulation = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, graph, disc, low, visited, isArticulation);
            }
        }

        // Print articulation points
        for (int i = 0; i < n; i++) {
            if (isArticulation[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private void dfs(int u, int parent, ArrayList<ArrayList<Integer>> graph, int[] disc, int[] low, boolean[] visited, boolean[] isArticulation) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int childCount = 0;

        for (int v : graph.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                childCount++;
                dfs(v, u, graph, disc, low, visited, isArticulation);
                low[u] = Math.min(low[u], low[v]);

                // u is articulation point in 2 cases:
                if (parent != -1 && low[v] >= disc[u]) {
                    isArticulation[u] = true;
                }
            } else {
                low[u] = Math.min(low[u], disc[v]); // back edge
            }
        }

        // Special case for root
        if (parent == -1 && childCount > 1) {
            isArticulation[u] = true;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        ArticulationPointsTarjan aj = new ArticulationPointsTarjan(5, graph);

    }
}

