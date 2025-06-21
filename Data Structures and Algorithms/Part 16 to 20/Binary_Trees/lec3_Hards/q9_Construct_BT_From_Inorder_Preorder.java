package Binary_Trees.lec3_Hards;

import java.util.HashMap;
import java.util.Map;

/*q9 105. Construct Binary Tree from Preorder and Inorder Traversal
Medium
Topics
Companies
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.4M
Submissions
2.1M
Acceptance Rate
65.2% */

public class q9_Construct_BT_From_Inorder_Preorder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store indices of inorder elements
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Call the recursive helper function
        return constructTree(preorder, inorder, 0, inorder.length - 1, 0, inMap);
    }

    private TreeNode constructTree(int[] preorder, int[] inorder, int inStart, int inEnd, int preIdx, Map<Integer, Integer> inMap) {
        // Base case: if the start index exceeds the end index
        if (inStart > inEnd) {
            return null;
        }

        // The current root is preorder[preIdx]
        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in the inorder array using the map
        int inIdx = inMap.get(rootVal);

        // Calculate the number of nodes in the left subtree
        int leftSubtreeSize = inIdx - inStart;

        // Recursively build the left and right subtrees
        root.left = constructTree(preorder, inorder, inStart, inIdx - 1, preIdx + 1, inMap);
        root.right = constructTree(preorder, inorder, inIdx + 1, inEnd, preIdx + 1 + leftSubtreeSize, inMap);

        return root;
    }
}
