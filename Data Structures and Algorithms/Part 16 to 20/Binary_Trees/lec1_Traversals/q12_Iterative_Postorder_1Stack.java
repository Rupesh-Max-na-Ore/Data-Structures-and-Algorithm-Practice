package Binary_Trees.lec1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Binary_Trees.TreeNode;
//Method 1 - with Pair(node,int visited)
class Pair {
    TreeNode node;
    boolean visited;

    Pair(TreeNode node, boolean visited) {
        this.node = node;
        this.visited = visited;
    }
}

public class q12_Iterative_Postorder_1Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        // If root is null, return an empty list
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false));

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            boolean visited = current.visited;

            // If visited is true, we have already processed its children
            if (visited) {
                result.add(node.data);
            } else {
                // Visit the current node
                stack.push(new Pair(node, true));

                // Push the right child first, then the left child
                if (node.right != null) {
                    stack.push(new Pair(node.right, false));
                }
                if (node.left != null) {
                    stack.push(new Pair(node.left, false));
                }
            }
        }

        return result;
    }

    // to test the traversal
    public static void main(String[] args) {
        // Create the binary tree
        q12_Iterative_Postorder_1Stack tree = new q12_Iterative_Postorder_1Stack();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Perform postorder traversal
        List<Integer> result = tree.postorderTraversal(root);
        
        // Print the result
        System.out.println(result);
    }
}
//Method 2 - Pure L R N
// package Binary_Trees.lec1_Traversals;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Stack;

// import Binary_Trees.TreeNode;

// public class q12_Iterative_Postorder_OneStack {

//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;  // Edge case: if the root is null, return an empty list
        
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode current = root;
//         TreeNode lastVisited = null;  // To track the last node we visited

//         while (!stack.isEmpty() || current != null) {
//             // Push all the left children onto the stack
//             if (current != null) {
//                 stack.push(current);
//                 current = current.left;
//             } else {
//                 TreeNode peekNode = stack.peek();
                
//                 // If the right child exists and hasn't been visited yet, move to the right child
//                 if (peekNode.right != null && lastVisited != peekNode.right) {
//                     current = peekNode.right;
//                 } else {
//                     // If no right child exists or it has already been visited, process the node
//                     result.add(peekNode.val);
//                     lastVisited = stack.pop();
//                 }
//             }
//         }

//         return result;
//     }

//     // Main method to test the traversal
//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(3);
//         root.left.left = new TreeNode(4);
//         root.left.right = new TreeNode(5);
//         root.right.left = new TreeNode(6);
//         root.right.right = new TreeNode(7);

//         q12_Iterative_Postorder_OneStack traversal = new q12_Iterative_Postorder_OneStack();
//         System.out.println(traversal.postorderTraversal(root));
//         // Expected Output: [4, 5, 2, 6, 7, 3, 1]
//     }
// }
