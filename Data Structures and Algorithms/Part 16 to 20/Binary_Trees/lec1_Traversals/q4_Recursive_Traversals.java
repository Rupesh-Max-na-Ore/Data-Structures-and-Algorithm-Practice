package Binary_Trees.lec1_Traversals;
/*Q4  Tree Traversals
Easy
0/40
Average time to solve is 15m
Contributed by
197 upvotes
Asked in companies
Problem statement
You have been given a Binary Tree of 'N'

nodes, where the nodes have integer values.



Your task is to return the ln-Order, Pre-Order, and Post-Order traversals of the given binary tree.



For example :
For the given binary tree:

The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
The Preorder traversal will be [1, 3, 5, 2, 4, 7, 6].
The Postorder traversal will be [5, 2, 3, 7, 6, 4, 1].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1 2 3 -1 -1 -1  6 -1 -1
Sample Output 1 :
2 1 3 6 
1 2 3 6 
2 6 3 1
Explanation of Sample Output 1 :
 The given binary tree is shown below:

Inorder traversal of given tree = [2, 1, 3, 6]
Preorder traversal of given tree = [1, 2, 3, 6]
Postorder traversal of given tree = [2, 6, 3, 1]
Sample Input 2 :
1 2 4 5 3 -1 -1 -1 -1 -1 -1
Sample Output 2 :
5 2 3 1 4 
1 2 5 3 4 
5 3 2 4 1
Explanation of Sample Output 2 :
The given binary tree is shown below:

Inorder traversal of given tree = [5, 2, 3, 1, 4]
Preorder traversal of given tree = [1, 2, 5, 3, 4]
Postorder traversal of given tree = [5, 3, 2, 4, 1]
Constraints :
1 <= 'N' <= 10^5
0 <= 'data' <= 10^5     

where 'N' is the number of nodes and 'data' denotes the node value of the binary tree nodes.

Time limit: 1 sec */
import java.util.ArrayList;
import java.util.List;

import Binary_Trees.TreeNode;

public class q4_Recursive_Traversals
{
    public void preorder(TreeNode root, List<Integer> preorderList) {
        // n l r
        if (root == null) return;
        preorderList.add(root.data);
        preorder(root.left, preorderList);
        preorder(root.right, preorderList);
    }
    
    public void inorder(TreeNode root, List<Integer> inorderList) {
        // l n r
        if (root == null) return;
        inorder(root.left, inorderList);
        inorderList.add(root.data);
        inorder(root.right, inorderList);
    }
    
    public void postorder(TreeNode root, List<Integer> postorderList) {
        // l r n
        if (root == null) return;
        postorder(root.left, postorderList);
        postorder(root.right, postorderList);
        postorderList.add(root.data);
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Lists to store the traversals
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        
        // List to hold all three traversals
        List<List<Integer>> result = new ArrayList<>();
        
        q4_Recursive_Traversals tree = new q4_Recursive_Traversals();
        
        // Fill each traversal list
        tree.preorder(root, preorderList);
        tree.inorder(root, inorderList);
        tree.postorder(root, postorderList);
        
        // Add each traversal to the result list
        result.add(inorderList);  // First, the inorder traversal
        result.add(preorderList); // Second, the preorder traversal
        result.add(postorderList);// Third, the postorder traversal
        
        return result; // Return the final result
    }

    //Sample TCs

    public static void main(String[] args) {
        // Construct a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        // Get the traversals
        List<List<Integer>> traversals = getTreeTraversal(root);
        
        // Output the results
        System.out.println("Inorder Traversal: " + traversals.get(0));
        System.out.println("Preorder Traversal: " + traversals.get(1));
        System.out.println("Postorder Traversal: " + traversals.get(2));
    }

    //1st attempt
    // public void preorder(TreeNode root, List<List<Integer>> al){
    //     //n l r
    //     if(root == null) return;
    //     //System.out.print(root.data);
    //     al.add(new ArrayList<>(List.of(root.data)));
    //     preorder(root.left);
    //     preorder(root.right);
    // }
    // public void inorder(TreeNode root, List<List<Integer>> al){
    //     // l n r
    //     if(root == null) return;
    //     inorder(root.left);
    //     //System.out.print(root.data);
    //     al.add(new ArrayList<>(List.of(root.data)));
    //     inorder(root.right);
    // }
    // public void postorder(TreeNode root, List<List<Integer>> al){
    //     // l r n
    //     if(root == null) return;
    //     postorder(root.left);
    //     postorder(root.right);
    //     //System.out.print(root.data);
    //     al.add(new ArrayList<>(List.of(root.data)));
    // }

    // public static List<List<Integer>> getTreeTraversal(TreeNode root) {
    //     // Write your code here.
    //     List<List<Integer>> al = new ArrayList<>();
    //     preorder(root,al);
    //     //print preorder list
        
    //     inorder(root,al);
    //     //print inorder list

    //     postorder(root,al);
    //     //print  postorder list
    // }
}

