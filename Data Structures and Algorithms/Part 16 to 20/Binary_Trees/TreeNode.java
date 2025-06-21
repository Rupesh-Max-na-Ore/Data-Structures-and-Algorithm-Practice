package Binary_Trees;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}