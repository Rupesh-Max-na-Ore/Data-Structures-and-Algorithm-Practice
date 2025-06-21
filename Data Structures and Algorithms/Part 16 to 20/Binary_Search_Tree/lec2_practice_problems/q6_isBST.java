package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q6_isBST {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        //N L R, tho any will do
        if(root.val>=max||root.val<=min) return false;
        boolean l = isBST(root.left, min, root.val);
        boolean r = isBST(root, root.val, max);
        return l && r;
    }
}
/*//LC submissions
public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long mini,long maxi){
        if(root==null)return true;
        if(root.val>=maxi ||root.val<=mini)return false;
        return isValidBST(root.left,mini,root.val) && isValidBST(root.right,root.val,maxi); 
    }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long mini,long maxi){
        if(root==null)return true;
        if(root.val>=maxi ||root.val<=mini)return false;
        return isValidBST(root.left,mini,root.val) && isValidBST(root.right,root.val,maxi); 
    }
}
 */