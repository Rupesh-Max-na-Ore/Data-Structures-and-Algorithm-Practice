package Binary_Trees.lec1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Binary_Trees.TreeNode;

public class q13_All_3_Iterative_Traversals_1Stack {
    // Define a NodeStatus class to store the node and its state
    private static class NodeStatus {
        TreeNode node;
        int state;  // 0 = Preorder, 1 = Inorder, 2 = Postorder

        NodeStatus(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public List<List<Integer>> allTraversals(TreeNode root) {
        // Lists to store preorder, inorder, and postorder traversals
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if (root == null) {
            return List.of(preorder, inorder, postorder);  // Return empty lists if tree is null
        }

        // Stack to store nodes and their current state of traversal
        Stack<NodeStatus> stack = new Stack<>();
        stack.push(new NodeStatus(root, 0));  // Start with the root in preorder state

        // Traverse the tree using a single stack
        while (!stack.isEmpty()) {
            NodeStatus curr = stack.pop();
            
            if (curr.state == 0) {
                // Preorder: Root, Left, Right
                preorder.add(curr.node.data);  // Add node to preorder list
                curr.state++;  // Move to inorder state
                stack.push(curr);  // Push the current node back to stack with updated state

                // Push left child to stack for further processing
                if (curr.node.left != null) {
                    stack.push(new NodeStatus(curr.node.left, 0));  // Left child starts with preorder
                }

            } else if (curr.state == 1) {
                // Inorder: Left, Root, Right
                inorder.add(curr.node.data);  // Add node to inorder list
                curr.state++;  // Move to postorder state
                stack.push(curr);  // Push the current node back to stack with updated state

                // Push right child to stack for further processing
                if (curr.node.right != null) {
                    stack.push(new NodeStatus(curr.node.right, 0));  // Right child starts with preorder
                }

            } else {
                // Postorder: Left, Right, Root
                postorder.add(curr.node.data);  // Add node to postorder list
            }
        }

        // Return the result as a list of lists
        return List.of(preorder, inorder, postorder);
    }

    // Main method to test the traversal
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        q13_All_3_Iterative_Traversals_1Stack traversal = new q13_All_3_Iterative_Traversals_1Stack();
        List<List<Integer>> result = traversal.allTraversals(root);

        System.out.println("Preorder: " + result.get(0));  // Expected: [1, 2, 4, 5, 3, 6, 7]
        System.out.println("Inorder: " + result.get(1));   // Expected: [4, 2, 5, 1, 6, 3, 7]
        System.out.println("Postorder: " + result.get(2)); // Expected: [4, 5, 2, 6, 7, 3, 1]
    }
}
// just take a tree of 3 node. think if u visit 1st time its pre.then after printing 1as pre u moves to lleft so that left will be printed and u can came back and print 1 as in. after that print 1 as inorder u moves to right.

// So just as u visit 1st time putting it in preorder and telling in second visit 1 is used as inorder.