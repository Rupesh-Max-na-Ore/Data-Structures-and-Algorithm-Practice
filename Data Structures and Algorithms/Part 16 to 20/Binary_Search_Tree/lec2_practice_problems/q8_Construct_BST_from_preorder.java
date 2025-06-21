package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec3_Hards.q14_Flatten_BTtoLinkedList.TreeNode;

public class q8_Construct_BST_from_preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    private TreeNode build(int[] a, int UpperBound, int[] i) {
        if (i[0] == a.length || a[i[0]] > UpperBound) return null;
        TreeNode root = new TreeNode(a[i[0]++]);
        root.left = build(a, root.val, i);
        root.right = build(a, UpperBound, i);
        return root;
    }
}
