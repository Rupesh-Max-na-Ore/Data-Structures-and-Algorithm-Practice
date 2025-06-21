package Binary_Trees.lec2_Mediums;

import Binary_Trees.TreeNode;

public class q4_Maximum_Path_Sum{
    //without global variable
    public int maxPathSum(TreeNode root) {
        int []maxPS = {Integer.MIN_VALUE};
        cost(root,maxPS);
        return maxPS[0];
    }

    private int cost(TreeNode root, int[] maxPS) {
        if(root==null) return 0;
        int lc = Math.max(0, cost(root.left, maxPS));
        int rc = Math.max(0, cost(root.right, maxPS));
        int currPC = root.data + lc + rc;
        maxPS[0] = Math.max(maxPS[0], currPC);
        return root.data + Math.max(lc, rc);
    }
    
}
// //with global variable
// public class Solution {
//     int maxValue;
    
//     public int maxPathSum(TreeNode root) {
//         maxValue = Integer.MIN_VALUE;
//         maxPathDown(root);
//         return maxValue;
//     }
    
//     private int maxPathDown(TreeNode node) {
//         if (node == null) return 0;
//         int left = Math.max(0, maxPathDown(node.left));
//         int right = Math.max(0, maxPathDown(node.right));
//         maxValue = Math.max(maxValue, left + right + node.val);
//         return Math.max(left, right) + node.val;
//     }
// }