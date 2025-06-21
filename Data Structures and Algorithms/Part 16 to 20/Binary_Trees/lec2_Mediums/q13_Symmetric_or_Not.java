package Binary_Trees.lec2_Mediums;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q13_Symmetric_or_Not {
    public boolean isSymmetric(TreeNode root) {
        return (root==null)|| SimultaneousTravel(root.left, root.right);
    }
    boolean SimultaneousTravel(TreeNode L, TreeNode R){
        if(L==null||R==null) return L==R;

        if(L.val!=R.val) return false;

        //Order of below 2 lines doesn't matter, only ll-rr && lr-rl together
        boolean stl = SimultaneousTravel(L.left, R.right);
        boolean str = SimultaneousTravel(L.right, R.left);

        return stl && str;
    }

}
