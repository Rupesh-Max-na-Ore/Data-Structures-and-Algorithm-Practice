package Binary_Trees.lec2_Mediums;

import Binary_Trees.TreeNode;

public class q5_Check_if_two_trees_are_identical_or_not {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null) return (p==q);
        //Using Postorder, can use any tho
        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);
        boolean v = p.data == q.data;
        return v && l && r;
    }
}
