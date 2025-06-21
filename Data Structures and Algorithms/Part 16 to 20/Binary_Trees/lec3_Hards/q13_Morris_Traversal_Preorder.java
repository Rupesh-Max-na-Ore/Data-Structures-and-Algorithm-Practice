package Binary_Trees.lec3_Hards;

import java.util.ArrayList;
import java.util.List;

/*Q13 Problem Statement: Given a Binary Tree, implement Morris Preorder Traversal and 
return the array containing its preorder sequence.

Morris Preorder Traversal is a tree traversal algorithm aiming to achieve a space complexity of O(1) 
without recursion or an external data structure. The algorithm should efficiently visit each node 
in the binary tree in preorder sequence, 
printing or processing the node values as it traverses, without using a stack or recursion. */
public class q13_Morris_Traversal_Preorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // Process the current node (preorder) and move to the right.
                preorder.add(current.val);
                current = current.right;
            } else {
                // Find the inorder predecessor of current.
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Create a thread from predecessor to current, process the current node.
                    predecessor.right = current;
                    preorder.add(current.val); // Process current node before going left.
                    current = current.left;
                } else {
                    // Predecessor's right is already pointing to current (thread exists), break the thread.
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
        return preorder;
    }
}
