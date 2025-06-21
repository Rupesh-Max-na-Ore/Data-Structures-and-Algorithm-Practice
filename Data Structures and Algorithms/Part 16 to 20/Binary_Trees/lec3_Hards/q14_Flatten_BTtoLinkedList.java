package Binary_Trees.lec3_Hards;
/*Q14 114. Flatten Binary Tree to Linked List
Medium
Topics
Companies
Hint
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1M
Submissions
1.6M
Acceptance Rate
66.6% */
public class q14_Flatten_BTtoLinkedList {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            TreeNode(int val) { this.val = val; }
        }
        //Approach 3: Morris Traversal Threading
        public void flatten(TreeNode root) {
            TreeNode current = root;
    
            while (current != null) {
                if (current.left != null) {
                    // Find the rightmost node in the left subtree
                    TreeNode predecessor = current.left;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
    
                    // Connect the right subtree of the current node to the rightmost node
                    predecessor.right = current.right;
    
                    // Move the left subtree to the right and set left to null
                    current.right = current.left;
                    current.left = null;
                }
    
                // Move to the next node in the right subtree
                current = current.right;
            }
    }
}
//Appropach 2: Explicit Stack
/*                                
import java.util.Stack;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    // Initialize a global variable
    // 'prev' to keep track of the
    // previously processed node.
    TreeNode prev = null;

    // Function to flatten a binary tree
    // to a right next Linked List structure
    public void flatten(TreeNode root) {
        // Base case: If the current
        // node is null, return.
        if (root == null) {
            return;
        }
        // Use a stack for
        // iterative traversal.
        Stack<TreeNode> st = new Stack<>();
        // Push the root node
        // onto the stack.
        st.push(root);
        
        // Continue the loop until
        // the stack is empty.
        while (!st.empty()) {
            // Get the top node from the stack.
            TreeNode cur = st.pop();

            if (cur.right != null) {
                // Push the right child
                // onto the stack.
                st.push(cur.right);
            }

            if (cur.left != null) {
                // Push the left child
                // onto the stack.
                st.push(cur.left);
            }

            if (!st.empty()) {
                // Connect the right child to
                // the next node in the stack.
                cur.right = st.peek();
            }

            // Set the left child to null to
            // form a right-oriented linked list.
            cur.left = null;
        }
    }
}

// Print the preorder traversal of the
// Original Binary Tree
class BinaryTreePrinter {
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Print the Binary Tree along the 
    // Right Pointers after Flattening
    public static void printFlattenTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        Solution sol = new Solution();
        
        System.out.print("Binary Tree Preorder: ");
        BinaryTreePrinter.printPreorder(root);
        System.out.println();
        
        sol.flatten(root);
        
        System.out.print("Binary Tree After Flatten: ");
        BinaryTreePrinter.printFlattenTree(root);
        System.out.println();
    }
}

    
                                
 */
//Approach 1: Recursion
/*                                
import java.util.*;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    // Initialize a global variable
    // 'prev' to keep track of the
    // previously processed node.
    TreeNode prev = null;

    // Function to flatten a binary tree
    // to a right next Linked List structure
    public void flatten(TreeNode root) {
        // Base case: If the current
        // node is null, return.
        if (root == null) {
            return;
        }

        // Recursive call to
        // flatten the right subtree
        flatten(root.right);

        // Recursive call to
        // flatten the left subtree
        flatten(root.left);

        // At this point, both left and right
        // subtrees are flattened, and 'prev'
        // is pointing to the rightmost node
        // in the flattened right subtree.

        // Set the right child of
        // the current node to 'prev'.
        root.right = prev;

        // Set the left child of the
        // current node to null.
        root.left = null;

        // Update 'prev' to the current
        // node for the next iteration.
        prev = root;
    }
}

public class Main {
    // Print the preorder traversal of the
    // Original Binary Tree
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Print the Binary Tree along the
    // Right Pointers after Flattening
    public static void printFlattenTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        Solution sol = new Solution();

        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();

        sol.flatten(root);

        System.out.print("Binary Tree After Flatten: ");
        printFlattenTree(root);
        System.out.println();
    }
}

                                
 */
/*                                
import java.util.*;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to flatten a binary tree
    // to a right next Linked List structure
    public void flatten(TreeNode root) {
        // Initialize a pointer
        // 'curr' to the root of the tree
        TreeNode curr = root;

        // Iterate until 'curr'
        // becomes NULL
        while (curr != null) {
            // Check if the current
            // node has a left child
            if (curr.left != null) {
                // If yes, find the rightmost
                // node in the left subtree
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                pre.right = curr.right;

                // Move the entire left subtree to the
                // right child of the current node
                curr.right = curr.left;

                // Set the left child of
                // the current node to NULL
                curr.left = null;
            }

            // Move to the next node
            // on the right side
            curr = curr.right;
        }
    }
}

// Print the preorder traversal of the
// Original Binary Tree
class Main {
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Print the Binary Tree along the
    // Right Pointers after Flattening
    public static void printFlattenTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        Solution sol = new Solution();

        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();

        sol.flatten(root);

        System.out.print("Binary Tree After Flatten: ");
        printFlattenTree(root);
        System.out.println();
    }
}
                                
                             */