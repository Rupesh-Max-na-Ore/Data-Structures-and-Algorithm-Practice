package Binary_Trees.lec2_Mediums;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class q8_Vertical_Order_Traversal {

  public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

 // Create class tuple to store the node and coordinates.
 class Tuple{
    TreeNode node;
    int row;
    int col;
    // Constructor for tuple.
    public Tuple(TreeNode _node, int _row, int _col){
        node = _node;
        row = _row;
        col = _col;
    }
 }


    // Using Level order traversal 

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // We need a TreeMap to store the vertical values(columns) and PriorityQueue to store the node values in increasing order.
        // (x,y,node)
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        // Create a queue for inserting each node with respective row(x), column(y) values during iteration.
        // Initially coordinates of node are...(node,x->(0),y->(0))
        Queue<Tuple> q = new LinkedList<Tuple>();

        // Insert the tuple
        q.add(new Tuple(root,0,0));

        // Loop until queue is empty.
        while(!q.isEmpty()){

            // Pop the tuple from stack.
            Tuple tuple = q.poll();

            // Initialize the values inside the tuple.
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            // Insert the values into the TreeMap.

            // x - > vertical coordinate --> check example test cases.
            if(!map.containsKey(x)) map.put(x,new TreeMap<>());

            // y - > horizontal coordinate --> check example test cases.
            if(!map.get(x).containsKey(y)) map.get(x).put(y,new PriorityQueue<>());

            // Finally insert node value (!!!not node!!!) into map inside PriorityQueue.
            map.get(x).get(y).add(node.val);

            // Check is there exists a left or right node to the node present in the queue.
            // If present, then add it to the queue.
            if(node.left!=null) q.add(new Tuple(node.left,x-1,y+1));
            if(node.right!=null) q.add(new Tuple(node.right, x+1,y+1));
        }

        // Create a List Of List to store the list of node values.
        List<List<Integer>> list = new ArrayList<>();

        // Loop through the map and add the values.
        // x - > key, (y, nodes) -> values.
        for(TreeMap<Integer,PriorityQueue<Integer>> yn : map.values()){
            // Create a subList to store node values in each vertical.
            list.add(new ArrayList<>());

            // Now iterate in the PriorityQueue.
            for(PriorityQueue<Integer> nodes : yn.values()){
                // Add node into the subList from 
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }return list;
    }

}
// Using Preorder Traversal
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
    
//     // Map<Index, TreeMap<level, node.val>>
//     Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         if (root == null)
//             return null;
//         map = new TreeMap<>();
//         dfs(root, 0, 0);
//         List<List<Integer>> res = new LinkedList<>();
//         for (int key : map.keySet()){
//             List<Integer> list = new LinkedList<>();
//             TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(key);
//             for (int k : tm.keySet()){
//                 PriorityQueue<Integer> pq = tm.get(k);
//                 while (!pq.isEmpty()){
//                     list.add(pq.poll());
//                 }
//             }
//             res.add(list);
//         }
//         return res;
//     }
    
//     private void dfs(TreeNode root, int index, int level){
//         if (root == null)
//             return;
        
//         map.putIfAbsent(index, new TreeMap<>());
//         map.get(index).putIfAbsent(level, new PriorityQueue<>());
//         map.get(index).get(level).add(root.val);
//         dfs(root.left, index - 1, level + 1);
//         dfs(root.right, index + 1, level + 1);
//     }
// }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// With the help of Comparator , Classes And Queues || Level Order traversal
// class Solution {
//     class pair{
//         TreeNode value;
//         int index;
//         int row;
//         pair(TreeNode value,int index,int row){
//             this.value=value;
//             this.index=index;
//             this.row=row;
//         }
//     }  
//     class store{
//         int row;
//         int value;
//         int col;
//         store(int row,int col,int value){
//             this.row=row;
//             this.value=value;
//             this.col=col;
//         }
//     }
//     class Ass implements Comparator<store>{
//         @Override
//       public  int compare(store value,store value2){
//           int ans =Integer.compare(value.row,value2.row);
//           int ans1=Integer.compare(value.col,value2.col);
//           if(ans==ans1){
//               return Integer.compare(value.value,value2.value);
//           }
//           return ans;
//       } 
//     }
// //  use another class and comparator try it yourself and dont care about time and space complexity
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         TreeMap<Integer,List<store>>hm=new TreeMap<>();
//         Queue<pair>q=new LinkedList<>();
//         q.add(new pair(root,0,0));
//         while(!q.isEmpty()){
//         pair p=q.remove();
//             List<store>list1=hm.getOrDefault(p.index,new ArrayList<>());
//             list1.add(new store(p.row,p.index,p.value.val));
//             hm.put(p.index,list1);
//              if(p.value.left!=null){
//                  q.add(new pair(p.value.left,p.index-1,p.row+1));
//              }
//              if(p.value.right!=null){
//                  q.add(new pair(p.value.right,p.index+1,p.row+1));
//              }
//     }
//     List<List<Integer>>list0=new ArrayList<>();
//     for(Integer st:hm.keySet()){
//      List<store>list2=hm.get(st);
//      List<Integer>list=new ArrayList<>();
//      Collections.sort(list2,new Ass());
//      for(int i=0;i<list2.size();i++){
//        list.add(list2.get(i).value);
//      }
//      list0.add(list);
//     }
//     return list0;
//     }
// }

// //more understandable code with comments
// // This method performs vertical order traversal of a binary tree
// public List<List<Integer>> verticalTraversal(TreeNode root) {

//     // TreeMap to store nodes based on their column (x) and row (y) positions
//     // Structure: map<column, map<row, priorityQueue of node values>>
//     TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

//     // Queue to help with level-order traversal (BFS), storing tuples (node, row, col)
//     Queue<Tuple> q = new LinkedList<>();
    
//     // Start BFS with the root node at position (0, 0)
//     q.add(new Tuple(root, 0, 0));

//     // Process all nodes in the tree using BFS
//     while (!q.isEmpty()) {
//         // Get the next tuple (node, row, col) from the queue
//         Tuple tuple = q.poll();

//         // Extract the node and its position from the tuple
//         TreeNode node = tuple.node;
//         int x = tuple.col;  // x represents the vertical (column) position
//         int y = tuple.row;  // y represents the horizontal (row/level) position

//         // If this column (x) is not in the map, create a new entry for it
//         if (!map.containsKey(x)) {
//             map.put(x, new TreeMap<>());
//         }

//         // If this row (y) within the column (x) is not in the map, create a new entry for it
//         if (!map.get(x).containsKey(y)) {
//             map.get(x).put(y, new PriorityQueue<>());
//         }

//         // Add the node's value to the corresponding column and row in the PriorityQueue
//         // PriorityQueue ensures nodes are stored in ascending order if they share the same position
//         map.get(x).get(y).add(node.val);

//         // If the current node has a left child, add it to the queue with updated position
//         if (node.left != null) {
//             q.add(new Tuple(node.left, y + 1, x - 1));  // Go down one level (y+1) and move left (x-1)
//         }

//         // If the current node has a right child, add it to the queue with updated position
//         if (node.right != null) {
//             q.add(new Tuple(node.right, y + 1, x + 1));  // Go down one level (y+1) and move right (x+1)
//         }
//     }

//     // Now, we need to extract the node values from the map and return them as a List of Lists
//     List<List<Integer>> result = new ArrayList<>();

//     // Iterate through the columns (x values) in sorted order (TreeMap ensures this)
//     for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
//         // Create a list to store nodes for the current column
//         List<Integer> colNodes = new ArrayList<>();

//         // For each column, process the rows (y values) in sorted order
//         for (PriorityQueue<Integer> nodes : colMap.values()) {
//             // Extract all nodes from the PriorityQueue (in ascending order) and add to the column list
//             while (!nodes.isEmpty()) {
//                 colNodes.add(nodes.poll());
//             }
//         }

//         // Add the completed column to the result list
//         result.add(colNodes);
//     }

//     // Return the final list of vertical node values
//     return result;
// }
// https://chatgpt.com/share/67076a87-bcc8-8005-a549-088bd5968905

//DFS pre-order method
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// import java.util.*;

// class Solution {
    
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         if (root == null) {
//             return new ArrayList<>();  // Handle edge case where the tree is empty.
//         }
        
//         // Map<Index, TreeMap<level, node.val>>
//         Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
//         // Perform DFS and populate the map.
//         dfs(root, 0, 0, map);
        
//         // Initialize the result list.
//         List<List<Integer>> res = new LinkedList<>();
        
//         // Process the map to create the final result list.
//         for (int key : map.keySet()) {
//             List<Integer> list = new LinkedList<>();
//             TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(key);
            
//             // Extract all values from the PriorityQueues in each level and add to the list.
//             for (int k : tm.keySet()) {
//                 PriorityQueue<Integer> pq = tm.get(k);
//                 while (!pq.isEmpty()) {
//                     list.add(pq.poll());
//                 }
//             }
            
//             // Add the list of nodes at this vertical index to the result.
//             res.add(list);
//         }
        
//         return res;  // Return the final result.
//     }
    
//     // DFS function to traverse the tree and populate the map.
//     private void dfs(TreeNode root, int index, int level, Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
//         if (root == null) {
//             return;  // Base case: stop recursion if the node is null.
//         }
        
//         // Ensure that the vertical index (index) has a TreeMap.
//         map.putIfAbsent(index, new TreeMap<>());
        
//         // Ensure that the level has a PriorityQueue to store nodes at that (index, level).
//         map.get(index).putIfAbsent(level, new PriorityQueue<>());
        
//         // Add the current node's value to the PriorityQueue at (index, level).
//         map.get(index).get(level).add(root.val);
        
//         // Recursively call dfs for the left child (move left: index decreases by 1, level increases by 1).
//         dfs(root.left, index - 1, level + 1, map);
        
//         // Recursively call dfs for the right child (move right: index increases by 1, level increases by 1).
//         dfs(root.right, index + 1, level + 1, map);
//     }
// }
// https://chatgpt.com/share/67076a87-bcc8-8005-a549-088bd5968905
