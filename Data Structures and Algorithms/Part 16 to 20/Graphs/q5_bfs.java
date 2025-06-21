package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class q5_bfs {
    //gfg q.
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // mark visted while putting in queue
        // when take out from q, it is only to extract nbrs
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);// s=0
        visited[0]=true;
        ArrayList<Integer> path_taken = new ArrayList<>();
        path_taken.add(0);
        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;

            for(int nbr : adj.get(node)){
                if(!visited[nbr]){
                    q.offer(nbr);
                    visited[nbr]=true;
                    path_taken.add(nbr);
                }
            }
        } return path_taken;
    }

    public static List<List<Integer>> bfsLevels(Map<Integer, List<Integer>> adjacencyList, int startNode) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                int node = queue.poll();
                currentLevel.add(node);

                for (int neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            levels.add(currentLevel); // Store nodes of the current level
        }
        return levels;
    }

    public static void main(String[] args) {
        // Graph representation using adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6, 7));
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());
        graph.put(6, Collections.emptyList());
        graph.put(7, Collections.emptyList());

        List<List<Integer>> levels = bfsLevels(graph, 1);

        // Print level-wise BFS
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("Level " + i + ": " + levels.get(i));
        }
    }
}

// Handling Disconnected Graphs
// Multiple BFS Calls: We loop through all nodes and run BFS from each unvisited node.
// Components Stored Separately: Each BFS run finds one component.
// Handles Isolated Nodes: Nodes with no edges form their own component.
/*
import java.util.*;

public class BFSDisconnectedGraph {
    public static List<List<Integer>> findConnectedComponents(Map<Integer, List<Integer>> adjacencyList, int totalNodes) {
        List<List<Integer>> allComponents = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int node = 1; node <= totalNodes; node++) {
            if (!visited.contains(node)) {
                List<Integer> component = bfs(adjacencyList, node, visited);
                allComponents.add(component);
            }
        }
        return allComponents;
    }

    private static List<Integer> bfs(Map<Integer, List<Integer>> adjacencyList, int startNode, Set<Integer> visited) {
        List<Integer> component = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);

            for (int neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return component;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4));
        graph.put(6, Collections.emptyList()); // Isolated node

        List<List<Integer>> components = findConnectedComponents(graph, 6);

        System.out.println("Number of Connected Components: " + components.size());
        System.out.println("Components: " + components);
    }
}

 */