package Binary_Trees.lec2_Mediums;

import java.util.ArrayList;
import java.util.List;

import Binary_Trees.TreeNode;

public class q7_Boundary_Traversal {

    // Comments by AI

    // Function to check if a node is a leaf (a node with no children).
    // Leaf nodes have no left or right child.
    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    // Function to add the left boundary of the tree (excluding leaf nodes).
    // The left boundary includes nodes on the far left edge from root to the deepest node.
    void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;  // Start with the left child of the root.
        while (curr != null) {
            // Add the node's value to the result list if it is not a leaf.
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            // Move to the left child if it exists; otherwise, move to the right child.
            // We need to keep going down on the left side of the tree.
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Function to add the right boundary of the tree (excluding leaf nodes).
    // The right boundary includes nodes on the far right edge from root to the deepest node.
    void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;  // Start with the right child of the root.
        List<Integer> temp = new ArrayList<>();  // A temporary list to store the right boundary.

        // Traverse down the right side of the tree.
        while (curr != null) {
            // Add the node's value to the temporary list if it is not a leaf.
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            // Move to the right child if it exists; otherwise, move to the left child.
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // The right boundary should be added in reverse order, 
        // so we traverse the temporary list from the end and add it to the final result.
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }

    // Function to add all the leaf nodes of the tree.
    // Leaf nodes are added from the leftmost leaf to the rightmost leaf.
    void addLeaves(TreeNode root, List<Integer> res) {
        // If the node is a leaf, add it to the result.
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        // Recursively visit the left and right children to find and add all leaf nodes.
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    // Main function to perform boundary traversal of the binary tree.
    // Boundary traversal visits the left boundary, leaf nodes, and right boundary.
    List<Integer> printBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();  // The result list to store boundary nodes.

        // If the tree is empty, return an empty list.
        if (root == null) {
            return res;
        }

        // Add the root node's value if it's not a leaf (since root is part of the boundary).
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        // First, add the left boundary (excluding leaves).
        addLeftBoundary(root, res);

        // Next, add all the leaf nodes.
        addLeaves(root, res);

        // Finally, add the right boundary (excluding leaves).
        addRightBoundary(root, res);

        // Return the result list containing the boundary traversal.
        return res;
    }

    // Helper function to print the result in a user-friendly format.
    void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();  // Print a newline after the result.
    }
}
