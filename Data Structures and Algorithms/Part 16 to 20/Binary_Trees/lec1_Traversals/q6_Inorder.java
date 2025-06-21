package Binary_Trees.lec1_Traversals;

public class q6_Inorder {
    
}
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> al = new ArrayList<>();
//         in(root, al);
//         return al;
//     }
//         public void in(TreeNode root, List<Integer> al){
//         // l n r
//         if(root==null) return;
//         in(root.left, al);
//         al.add(root.val);
//         in(root.right, al);
//     }

// }