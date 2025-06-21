package Graphs.Lec6_Other_Algos;

import java.util.*;

public class Tarjans_SCC {

    private int time = 0;
    private List<List<Integer>> resultSCCs = new ArrayList<>();

    public List<List<Integer>> tarjansSCC(int V, ArrayList<ArrayList<Integer>> graph) {
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] inStack = new boolean[V];
        Arrays.fill(disc, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i, graph, disc, low, inStack, stack);
            }
        }

        return resultSCCs;
    }

    private void dfs(int u, ArrayList<ArrayList<Integer>> graph, int[] disc, int[] low,
                     boolean[] inStack, Deque<Integer> stack) {
        disc[u] = low[u] = time++;
        stack.push(u);
        inStack[u] = true;

        for (int v : graph.get(u)) {
            if (disc[v] == -1) {
                dfs(v, graph, disc, low, inStack, stack);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            List<Integer> scc = new ArrayList<>();
            int node;
            do {
                node = stack.pop();
                inStack[node] = false;
                scc.add(node);
            } while (node != u);
            resultSCCs.add(scc);
        }
    }

    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Adding edges
        graph.get(0).add(1);
        //graph.get(1).add(7);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(7).add(3);
        graph.get(3).add(6);
        graph.get(6).add(0);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(7);

        Tarjans_SCC solver = new Tarjans_SCC();
        List<List<Integer>> SCCs = solver.tarjansSCC(V, graph);

        System.out.println("Total SCCs: " + SCCs.size());
        int i = 1;
        for (List<Integer> scc : SCCs) {
            System.out.println("SCC " + (i++) + ": " + scc);
        }
    }
}
