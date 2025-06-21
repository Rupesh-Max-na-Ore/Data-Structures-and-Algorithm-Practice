package Binary_Trees.lec1_Traversals;

public class q7_Postorder {
    
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
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> al = new ArrayList<>();
//         post(root, al);
//         return al;
//     }
//         public void post(TreeNode root, List<Integer> al){
//         // l r n
//         if(root==null) return;
//         post(root.left, al);
//         post(root.right, al);
//         al.add(root.val);
//     }
// }