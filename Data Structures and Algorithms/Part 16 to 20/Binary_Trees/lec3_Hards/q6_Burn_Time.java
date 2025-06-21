package Binary_Trees.lec3_Hards;
/*Q6 Burning Tree
Difficulty: HardAccuracy: 53.53%Submissions: 92K+Points: 8
Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
Note: The tree contains unique values.


Examples : 

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    / 
 8    10
Target Node = 10
Output: 5

Expected Time Complexity: O(number of nodes)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ number of nodes ≤ 105

1 ≤ values of nodes ≤ 105 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class q6_Burn_Time {
    
    // Definition for a Node
    class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    // Main function to calculate minimum time to burn the tree
    public static int minTime(Node root, int start) {
        // Step 1: Map each node to its parent
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = mapParent_FindTarget(root, parentMap, start);

        // Step 2: Calculate burn time using BFS from the target node
        return findBurnTime(parentMap, targetNode);
    }

    // Function to calculate burn time from the target node
    private static int findBurnTime(Map<Node, Node> parentMap, Node targetNode) {
        // BFS queue to simulate burning process
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);

        // Set to track visited nodes to avoid re-burning the same node
        Set<Node> visited = new HashSet<>();
        visited.add(targetNode);

        int time = 0;  // To count the time in seconds

        // Perform BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean anyNodeBurned = false;

            // Process all nodes at the current level (1 second for each level)
            for (int i = 0; i < size; i++) {
                Node currentNode = q.poll();

                // Spread fire to the left child if it exists and has not been visited
                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    visited.add(currentNode.left);
                    q.add(currentNode.left);
                    anyNodeBurned = true;
                }

                // Spread fire to the right child if it exists and has not been visited
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    visited.add(currentNode.right);
                    q.add(currentNode.right);
                    anyNodeBurned = true;
                }

                // Spread fire to the parent if it exists and has not been visited
                if (parentMap.containsKey(currentNode) && !visited.contains(parentMap.get(currentNode))) {
                    visited.add(parentMap.get(currentNode));
                    q.add(parentMap.get(currentNode));
                    anyNodeBurned = true;
                }
            }

            // If any node was burned in this iteration, increment the time
            if (anyNodeBurned) {
                time++;
            }
        }

        return time;  // Return the total time required to burn the entire tree
    }

    // Function to map each node to its parent and find the target node
    private static Node mapParent_FindTarget(Node root, Map<Node, Node> parentMap, int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node targetNode = null;

        // BFS to map parents and find the target node
        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            // Check if the current node is the target node
            if (currentNode.data == start) {
                targetNode = currentNode;
            }

            // If the left child exists, map its parent and add it to the queue
            if (currentNode.left != null) {
                parentMap.put(currentNode.left, currentNode);
                q.add(currentNode.left);
            }

            // If the right child exists, map its parent and add it to the queue
            if (currentNode.right != null) {
                parentMap.put(currentNode.right, currentNode);
                q.add(currentNode.right);
            }
        }

        return targetNode;  // Return the node where the fire starts (target node)
    }
}

//1st attempt mistake
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Map;
// import java.util.Queue;

// import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

// public class q6_Burn_Time {
//     class Node {
//     	int data;
//     	Node left;
//     	Node right;
    
//     	Node(int data) {
//     		this.data = data;
//     		left = null;
//     		right = null;
//     	}
//     }
//     public static int minTime(Node root, int start) 
//     {
//         Map<Node,Node> Parent = new HashMap<>();
//         Node targetNode = mapParent_FindTarget(root,Parent,start);
//         if(targetNode.data==start) return findBurnTime(Parent,targetNode);
//         return Integer.MIN_VALUE;
//     }
//     private static int findBurnTime(Map<Node, Node> parent, Node targetNode) {
        
//     }
//     private static Node mapParent_FindTarget(Node root, Map<Node, Node> parent, int start) {
//         Queue<Node> q=new LinkedList<>();
//         q.add(root);
//         Node tgt = new Node(-111); //the main mistake
//         while(!q.isEmpty())
//         {
//             Node node=q.poll();
//             if(node.data==start) tgt=node;
//             if(node.left!=null)
//             {
//                 parent.put(node.left,node);
//                 q.add(node.left);
//             }
//             if(node.right!=null)
//             {
//                 parent.put(node.right,node);
//                 q.add(node.right);
//             }

//         } return tgt;
//     }
// }
