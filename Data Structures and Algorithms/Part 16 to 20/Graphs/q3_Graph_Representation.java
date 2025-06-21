package Graphs;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class q3_Graph_Representation {
    //gfg Q.
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        return graph;
    }
    static long count(int n) {
        // code here
        int totalEdges = n * (n - 1) / 2;
        // Total graphs = 2^(totalEdges)
        return (long) Math.pow(2, totalEdges);

  }


    // public static void main(String[] args) {
    //     Scanner sc=new Scanner(System.in);
    //     System.out.print("Enter the number of vertices: ");
    //     int v=sc.nextInt();
    //     ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    //     for(int i=0; i<=v; i++){
    //         adj.add(new ArrayList<Integer>());
    //     }
    //     System.out.println();
    //     while(true){
    //         System.out.print("Enter vertex1: ");
    //         int v1=sc.nextInt();
    //         System.out.print("\nEnter vertex2: ");
    //         int v2=sc.nextInt();
    //         adj.get(v1).add(v2);
    //         adj.get(v2).add(v1);
    //         System.out.println("Do you want to continue?(Y/N)");
    //         char choice=sc.next().charAt(0);
    //         if(choice=='N' || choice=='n'){
    //             break;
    //         }
    //     }
    //     for(int i=1; i<=v; i++){
    //         System.out.print("vartex"+i+" {");
    //         for(int j=0; j<adj.get(i).size()-1; j++){
    //             System.out.print(adj.get(i).get(j)+", ");
    //         }
    //         System.out.println(adj.get(i).get(adj.get(i).size()-1)+"}");
    //     }
    //     sc.close();
    // }
}
//https://chatgpt.com/share/67ab1291-494c-8005-a99c-d834e3305cb0

// //Wtd graph
// import java.util.*;

// class GraphAdjacencyListWeighted {
//     private int vertices;
//     private List<List<Edge>> adjacencyList;

//     // Edge class to store destination and weight
//     class Edge {
//         int destination, weight;

//         Edge(int destination, int weight) {
//             this.destination = destination;
//             this.weight = weight;
//         }
//     }

//     // Constructor
//     public GraphAdjacencyListWeighted(int vertices) {
//         this.vertices = vertices;
//         adjacencyList = new ArrayList<>(vertices);
//         for (int i = 0; i < vertices; i++) {
//             adjacencyList.add(new ArrayList<>());
//         }
//     }

//     // Add a directed weighted edge
//     public void addEdge(int src, int dest, int weight) {
//         adjacencyList.get(src).add(new Edge(dest, weight));
//     }

//     // Display the graph
//     public void printGraph() {
//         for (int i = 0; i < vertices; i++) {
//             System.out.print("Vertex " + i + " -> ");
//             for (Edge edge : adjacencyList.get(i)) {
//                 System.out.print("(to " + edge.destination + ", weight " + edge.weight + ") ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         GraphAdjacencyListWeighted graph = new GraphAdjacencyListWeighted(5);
//         graph.addEdge(0, 1, 4);
//         graph.addEdge(0, 2, 3);
//         graph.addEdge(1, 2, 2);
//         graph.addEdge(1, 3, 5);
//         graph.addEdge(2, 3, 7);
//         graph.addEdge(3, 4, 1);

//         graph.printGraph();
//     }
// }

// //Using Hashmap
// import java.util.*;

// public class GraphWithHashMap {
//     private Map<Integer, Map<Integer, Integer>> adjacencyList;

//     // Constructor
//     public GraphWithHashMap() {
//         adjacencyList = new HashMap<>();
//     }

//     // Add a directed weighted edge
//     public void addEdge(int src, int dest, int weight) {
//         adjacencyList.putIfAbsent(src, new HashMap<>());
//         adjacencyList.get(src).put(dest, weight);
//     }

//     // Display the graph
//     public void printGraph() {
//         for (int node : adjacencyList.keySet()) {
//             System.out.print("Vertex " + node + " -> ");
//             for (Map.Entry<Integer, Integer> neighbor : adjacencyList.get(node).entrySet()) {
//                 System.out.print("(to " + neighbor.getKey() + ", weight " + neighbor.getValue() + ") ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         GraphWithHashMap graph = new GraphWithHashMap();
//         graph.addEdge(0, 1, 4);
//         graph.addEdge(0, 2, 3);
//         graph.addEdge(1, 2, 2);
//         graph.addEdge(1, 3, 5);
//         graph.addEdge(2, 3, 7);
//         graph.addEdge(3, 4, 1);

//         graph.printGraph();
//     }
// }
/*Advantages of Using TreeMap
Sorted Vertex Traversal: Vertices are automatically ordered based on their natural integer order.

Efficient Range Queries: You can quickly find subgraphs using subMap() and higherKey() methods.

java
Copy
Edit
// Get neighbors of vertex 1 in a sorted manner
TreeMap<Integer, Integer> neighbors = graph.adjacencyList.getOrDefault(1, new TreeMap<>());
System.out.println("Sorted neighbors of 1: " + neighbors);
Useful for Ordered Algorithms: Ideal for algorithms that rely on visiting nodes in sorted order (like Kruskal's). */
// //Using Treemap
// import java.util.*;

// public class GraphWithTreeMap {
//     private TreeMap<Integer, TreeMap<Integer, Integer>> adjacencyList;

//     // Constructor
//     public GraphWithTreeMap() {
//         adjacencyList = new TreeMap<>();
//     }

//     // Add a directed weighted edge
//     public void addEdge(int src, int dest, int weight) {
//         adjacencyList.putIfAbsent(src, new TreeMap<>());
//         adjacencyList.get(src).put(dest, weight);
//     }

//     // Display the graph
//     public void printGraph() {
//         for (int node : adjacencyList.keySet()) {
//             System.out.print("Vertex " + node + " -> ");
//             for (Map.Entry<Integer, Integer> neighbor : adjacencyList.get(node).entrySet()) {
//                 System.out.print("(to " + neighbor.getKey() + ", weight " + neighbor.getValue() + ") ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         GraphWithTreeMap graph = new GraphWithTreeMap();
//         graph.addEdge(2, 3, 5);
//         graph.addEdge(1, 2, 4);
//         graph.addEdge(0, 1, 1);
//         graph.addEdge(3, 4, 2);
//         graph.addEdge(1, 3, 6);

//         graph.printGraph();
//          // Get neighbors of vertex 1 in a sorted manner
//          TreeMap<Integer, Integer> neighbors = graph.adjacencyList.getOrDefault(1, new TreeMap<>());
//          System.out.println("Sorted neighbors of 1: " + neighbors);

//     }
// }

// import java.util.*;

// public class OneBasedIndexGraph {
//     private TreeMap<Integer, TreeMap<Integer, Integer>> adjacencyList;

//     public OneBasedIndexGraph() {
//         adjacencyList = new TreeMap<>();
//     }

//     // Add edge using 1-based indexing
//     public void addEdge(int src, int dest, int weight) {
//         adjacencyList.putIfAbsent(src, new TreeMap<>());
//         adjacencyList.get(src).put(dest, weight);
//     }

//     // Display the graph with 1-based indexing
//     public void printGraph() {
//         for (int node : adjacencyList.keySet()) {
//             System.out.print("Vertex " + node + " -> ");
//             for (Map.Entry<Integer, Integer> neighbor : adjacencyList.get(node).entrySet()) {
//                 System.out.print("(to " + neighbor.getKey() + ", weight " + neighbor.getValue() + ") ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         OneBasedIndexGraph graph = new OneBasedIndexGraph();
//         graph.addEdge(1, 2, 5); // Use 1-based indexing
//         graph.addEdge(2, 3, 4);
//         graph.addEdge(1, 3, 2);

//         graph.printGraph(); // Output matches 1-based indexing
//     }
// }

// import java.util.*;

// public class OneBasedAdjacencyList {
//     private List<List<Integer>> adjacencyList;
//     private int vertices;

//     // Constructor with 1-based indexing
//     public OneBasedAdjacencyList(int vertices) {
//         this.vertices = vertices;
//         adjacencyList = new ArrayList<>(vertices + 1); // Extra space for 1-based indexing
//         for (int i = 0; i <= vertices; i++) {
//             adjacencyList.add(new ArrayList<>());
//         }
//     }

//     // Add edge with 1-based indexing
//     public void addEdge(int src, int dest) {
//         adjacencyList.get(src).add(dest);
//         adjacencyList.get(dest).add(src); // For undirected graph
//     }

//     // Display graph
//     public void printGraph() {
//         for (int i = 1; i <= vertices; i++) {
//             System.out.print("Vertex " + i + ": ");
//             for (int neighbor : adjacencyList.get(i)) {
//                 System.out.print(neighbor + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         OneBasedAdjacencyList graph = new OneBasedAdjacencyList(3);
//         graph.addEdge(1, 2);
//         graph.addEdge(1, 3);
//         graph.addEdge(2, 3);

//         graph.printGraph();
//     }
// }

/*

Print adjacency list
Difficulty: EasyAccuracy: 43.42%Submissions: 157K+Points: 2
Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.

Example 1:

Input:
V = 5, E = 7
edges = [[0,1], [0,4], [4,1], [4,3], [1,3], [1,2], [3,2]]

Output: 
[[1,4], [0,2,3,4], [1,3], [1,2,4], [0,1,3]]
Explanation:
Node 0 is connected to 1 and 4.
Node 1 is connected to 0,2,3 and 4.
Node 2 is connected to 1 and 3.
Node 3 is connected to 1,2 and 4.
Node 4 is connected to 0,1 and 3.
Example 2:

Input:
V = 4, E = 3
edges = [[0,3], [0,2], [2,1]]


Output: 
[[2,3], [2], [0,1], [0]]
Explanation:
Node 0 is connected to 2 and 3.
Node 1 is only connected to 2.
Node 2 is connected to 0 and 1.
Node 3 is only connected to 0.
Constraints:
1 ≤ V, E ≤ 105 */

