package Binary_Trees.lec2_Mediums;

import Binary_Trees.TreeNode;

public class q3_Diameter {
    int maxim=0;
    public int diameterOfBinaryTree(TreeNode root) {
        ht(root);
        return maxim;
    }
    private int ht(TreeNode root) {
        if(root == null) return 0;
        int lh = ht(root.left);
        int rh = ht(root.right);
        int currdia= lh+rh;
        maxim = Math.max(maxim, currdia);
        return 1 + Math.max(lh, rh);

    }
}
