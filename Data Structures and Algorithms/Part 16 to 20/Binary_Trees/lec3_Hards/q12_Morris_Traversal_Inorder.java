package Binary_Trees.lec3_Hards;
import java.util.ArrayList;
/*Q12 Problem Statement: Given a Binary Tree, implement Morris Inorder Traversal and 
return the array containing its inorder sequence.

Morris Inorder Traversal is a tree traversal algorithm aiming to achieve a 
space complexity of O(1) without recursion or an external data structure. 
The algorithm should efficiently visit each node in the binary tree in inorder sequence, 
printing or processing the node values as it traverses, without using a stack or recursion.*/
import java.util.List;

public class q12_Morris_Traversal_Inorder {
 public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // If there is no left child, process the current node and move to the right.
                inorder.add(current.val);
                current = current.right;
            } else {
                // Find the inorder predecessor (rightmost node of the left subtree).
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Establish the thread from the predecessor to the current node.
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Predecessor's right is already pointing to current (thread exists), so break the thread.
                    predecessor.right = null;
                    inorder.add(current.val);
                    current = current.right;
                }
            }
        }
        return inorder;
    }
}
