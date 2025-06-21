package Binary_Trees.lec2_Mediums;

import Binary_Trees.TreeNode;

public class q2_Balanced_or_Not {
    public boolean isBalanced(TreeNode root) {
        return (ht(root) != -1); //if get back height, then can't be unbalanced
    }
    int ht(TreeNode node)
    {
        if(node == null) return 0;
        int l = ht(node.left);
        int r = ht(node.right);
        if(l == -1 || r == -1) return -1; //return to prev fn call
        if(Math.abs((r-l))>1) return -1; //Stops recursion 
        return Math.max(l, r)+1;
    }
}
