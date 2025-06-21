package Binary_Trees.lec1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Binary_Trees.TreeNode;
public class q11_Iterative_Postorder_2Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;  // Edge case: if the root is null, return an empty list

        Stack<TreeNode> stack1 = new Stack<>();  // First stack for processing nodes
        Stack<TreeNode> stack2 = new Stack<>();  // Second stack to store nodes in postorder sequence

        // Push the root node onto the first stack
        stack1.push(root);

        // Process nodes in reverse order of postorder traversal
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();   // Pop a node from the first stack
            stack2.push(node);              // Push it onto the second stack

            // Push left and right children to the first stack
            if (node.left != null) {
                stack1.push(node.left);     // Push left child first
            }
            if (node.right != null) {
                stack1.push(node.right);    // Push right child second
            }
        }

        // Now, the second stack contains the nodes in postorder
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().data);   // Pop from the second stack and add to the result list
        }

        return result;
    }
    
    // to test the traversal
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        q11_Iterative_Postorder_2Stack traversal = new q11_Iterative_Postorder_2Stack();
        System.out.println(traversal.postorderTraversal(root));
        // Expected Output: [4, 5, 2, 6, 7, 3, 1]
    }
}
