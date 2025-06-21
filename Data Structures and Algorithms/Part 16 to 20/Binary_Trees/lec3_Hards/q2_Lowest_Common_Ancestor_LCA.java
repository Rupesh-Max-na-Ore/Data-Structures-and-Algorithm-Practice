package Binary_Trees.lec3_Hards;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q2_Lowest_Common_Ancestor_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==root||q==root) return root;
        
        TreeNode Lft = lowestCommonAncestor(root.left, p, q);
        TreeNode Rht = lowestCommonAncestor(root.right, p, q);
        
        if (Lft == null) return Rht;
        else if(Rht==null) return Lft;
        else return root; //when lft & rht both not null

    }
}
