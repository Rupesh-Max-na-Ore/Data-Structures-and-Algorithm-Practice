package Binary_Search_Tree.lec1_concepts;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q2_SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.val!=val) root = root.val > val ? root.left : root.right;
        return root;
    }
}
