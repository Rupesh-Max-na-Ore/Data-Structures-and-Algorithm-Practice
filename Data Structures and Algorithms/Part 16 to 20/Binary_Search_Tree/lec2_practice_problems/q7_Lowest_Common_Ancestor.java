package Binary_Search_Tree.lec2_practice_problems;

public class q7_Lowest_Common_Ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);
        else if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p, q);

        //else
        return root;

    }
}
