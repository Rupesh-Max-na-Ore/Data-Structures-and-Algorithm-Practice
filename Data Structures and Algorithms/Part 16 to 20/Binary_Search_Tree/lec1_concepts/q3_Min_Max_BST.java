package Binary_Search_Tree.lec1_concepts;

public class q3_Min_Max_BST {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        while(root.left!=null) root = root.left;
        return root.data;
    }
    int maxValue(Node root) {
        // code here
        while(root.right!=null) root = root.right;
        return root.data;
    }

}
