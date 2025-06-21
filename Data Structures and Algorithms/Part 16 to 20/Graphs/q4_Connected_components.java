package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class q4_Connected_components {
     private int vertices;
    private Map<Integer, List<Integer>> adjacencyList;
    private boolean[] visited;
    private List<Integer> componentSizes;

    // Constructor
    public q4_Connected_components(int vertices) {
        this.vertices = vertices;
        adjacencyList = new HashMap<>();
        visited = new boolean[vertices + 1]; // 1-based indexing
        componentSizes = new ArrayList<>();

        for (int i = 1; i <= vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    // DFS to find the size of a component
    private int dfs(int node) {
        visited[node] = true;
        int size = 1;

        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor);
            }
        }
        return size;
    }

    private int bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        int size = 0;
    
        while (!queue.isEmpty()) {
            int node = queue.poll();
            size++;
    
            for (int neighbor : adjacencyList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return size;
    }
    

    // Find connected components and their sizes
    public void findConnectedComponents() {
        componentSizes.clear();
        int count = 0;

        for (int node = 1; node <= vertices; node++) {
            if (!visited[node]) {
                //int size = dfs(node);
                int size2 = bfs(node);
                //componentSizes.add(size);
                componentSizes.add(size2);
                count++;
            }
        }

        System.out.println("Number of Connected Components: " + count);
        System.out.println("Sizes of Connected Components: " + componentSizes);
    }

    public static void main(String[] args) {
        q4_Connected_components graph = new q4_Connected_components(6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);

        graph.findConnectedComponents();
    }
}
