package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec3_Hards.q14_Flatten_BTtoLinkedList.TreeNode;

public class q4_delete_node {

    //Way 2: Iterative w/o value change
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return deleter_Linker(root);
        //Find the node 
        TreeNode t = root;
        //Make t stop at the node that's parent to node to be deleted
        while(t!=null){
            if(t.val > key){
                if(t.left!=null && t.left.val == key){
                    t.left = deleter_Linker(t.left);
                    break;
                } else t = t.left;
            } 
            else // val < key
            {
                if(t.right!=null && t.right.val == key){
                    t.right = deleter_Linker(t.right);
                    break;
                } else t = t.right;
            }
        }
        return root;
    }
    // method which when given node to be deleted, returns ptr to the node where we should jump to from it's parent (ie, change links to) to skip over the node to be deleted
    private TreeNode deleter_Linker(TreeNode t) {
        //if only 1 child exist, return it
        if(t.left == null) return t.right;
        else if(t.right == null) return t.left;
        else //booth child exist
        {
            //2 ways to do it, using left constant bias here
            TreeNode l = t.left;
            TreeNode r = t.right;
            TreeNode righestLeft = l;
            //find rightmost node in left subtree
            while(righestLeft.right !=null) righestLeft = righestLeft.right;
            righestLeft.right = r; //link change -- rightmost node in left subtree connect to deleted node's right subtree
            return l;
        }
    }

    //1st blind attempt, missing edge cases, almost correct logic for important case
    // public TreeNode deleteNode(TreeNode root, int key) {
    //     //find node to be deleted and keep track of its prev
    //     TreeNode t = root;
    //     TreeNode prev = null;
    //     int preflag =-1;
    //     while(t!=null && t.val!=key){
    //         prev = t;
    //         if(t.val>key) {t=t.left; preflag = 0;}
    //         else {t= t.right; preflag = 1;}
    //     }
    //    //if we delete t, we can connect it to t.left or right, if they exist
    //     //say we go to right path
    //     /*if(t.right!=null) {
    //         prev = t.right;
    //         //go to left subtree's rightmost node and 
    //     }*/

    //     if(t.left !=null){
    //         //go to left subtree's rightmost node and
    //         Treenode x = t.left;
    //         while(x.right!=null) x = x.right;
    //         t.val = x.val; //replace
    //         x.right = null; //delete this node
    //     }
    //     else prev.right = t.right;

    //     return root;
    // }
}
/*
//Nice Iterative code with comments, w/ value change
 public TreeNode deleteNode(TreeNode root, int key) {
        // If the root is null, return null (nothing to delete)
        if (root == null) return null;

        TreeNode parent = null;
        TreeNode node = root;

        // Step 1: Find the node to delete and its parent
        while (node != null && node.val != key) {
            parent = node;
            if (key < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // If the node is not found in the tree
        if (node == null) return root;

        // Step 2: Handle the case where the node has two children
        if (node.left != null && node.right != null) {
            // Find the in-order successor (smallest node in the right subtree)
            TreeNode successor = node.right;
            TreeNode successorParent = node;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Replace node's value with its successor's value
            node.val = successor.val;

            // Now, we need to delete the successor node
            node = successor;  // Set node to the successor
            parent = successorParent;  // Adjust parent to successor's parent
        }

        // Step 3: Handle the case where the node has at most one child
        TreeNode child = (node.left != null) ? node.left : node.right;

        if (parent == null) {
            // Case when deleting the root node with one child
            return child;
        }

        // Otherwise, relink the child with the parent
        if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return root;
    }
 */

 /*
  //Nice Recursive code with comments, w/ value change
  public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1: Node with no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node with only one child (either left or right)
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node with two children
            // Replace with the in-order successor (smallest value in the right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            // Delete the in-order successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // Helper function to find the minimum value node (in-order successor)
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
  */