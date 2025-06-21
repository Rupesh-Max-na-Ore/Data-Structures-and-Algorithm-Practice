package Binary_Trees.lec3_Hards;
/*106. Construct Binary Tree from Inorder and Postorder Traversal
Medium
Topics
Companies
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
704.9K
Submissions
1.1M
Acceptance Rate
64.5% */

import java.util.HashMap;
import java.util.Map;

public class q10_Construct_BT_From_Inorder_Postorder {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Create a map to store the indices of inorder elements for faster lookup
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Start recursive construction from postorder end and full inorder range
        return constructTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1, inMap);
    }

    private TreeNode constructTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postIdx, Map<Integer, Integer> inMap) {
        // Base case: if the start index exceeds the end index, return null
        if (inStart > inEnd) {
            return null;
        }

        // The current root is the last element in the current postorder range
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in the inorder array
        int inIdx = inMap.get(rootVal);

        // Calculate how many nodes are in the right subtree
        int rightSubtreeSize = inEnd - inIdx;

        // Recursively build the right subtree first (due to postorder traversal) and then the left subtree
        root.right = constructTree(inorder, postorder, inIdx + 1, inEnd, postIdx - 1, inMap);
        root.left = constructTree(inorder, postorder, inStart, inIdx - 1, postIdx - rightSubtreeSize - 1, inMap);

        return root;
    }
}
